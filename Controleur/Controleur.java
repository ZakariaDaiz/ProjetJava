package Controleur;

import modele.*;
import modele.AmbientClasses.*;
import modele.HeroClasses.HeroFactory;
import modele.ObjetClasses.Objet;
import modele.ObjetClasses.Equipement;
import modele.ObjetClasses.Consommable; // Supposé si vous faites une interface ou check instance
import modele.PNJClasses.PNJ;
import modele.ThemeClasses.*;
import Ihm.Ihm;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Controleur gère le déroulement des tours et de l'avancement dans les donjons.
 */
public class Controleur {

    private Ihm ihm;
    private HeroFactory heroFactory;


    public Controleur(Ihm ihm) {
        this.ihm = ihm;
        this.heroFactory = new HeroFactory();

    }

    /**
     * Boucle principale du jeu.
     * Gère l'initialisation, la boucle des salles et la fin de partie.
     */
    public void jouerPartie() {
        // --- 1. Initialisation du Personnage ---
        String nom = ihm.demanderNom();
        // On suppose que l'IHM affiche les choix et renvoie une String valide (Barbare, Sorcier...)
        String classeChoisie = ihm.demanderClasse(heroFactory.getClassesDisponibles());

        // Création du joueur via la factory
        Joueur joueur = (Joueur) heroFactory.creerPersonnage(classeChoisie, nom);
        ihm.afficherMessage("Personnage créé : " + heroFactory.getDescriptionClasse(classeChoisie));

        // --- 2. Choix du Thème ---
        // On suppose que l'IHM renvoie 1 pour Médiéval, 2 pour Futuriste
        int choixTheme = ihm.demanderTheme();
        ThemeFactory themeFactory;

        if (choixTheme == 1) {
            themeFactory = new ThemeMedievalFactory();
        } else {
            themeFactory = new ThemeFuturisteFactory();
        }

        // --- 3. Génération du Donjon ---
        // On initialise une liste vide, la méthode genererDonjon la remplira
        Donjon donjon = new Donjon(new ArrayList<>(), themeFactory);
        donjon.genererDonjon(themeFactory);

        ihm.afficherMessage("Le donjon " + themeFactory.getTheme() + " a été généré avec succès !");
        ihm.afficherMessage("Vous entrez dans le donjon...");

        // --- 4. Boucle de jeu (Navigation Salle par Salle) ---
        // On parcourt les salles tant que le joueur est vivant et qu'il reste des salles
        while (!joueur.estMort() && donjon.getSalleActuelleIndex() < 10) { // 10 salles selon le sujet

            // Récupérer la salle actuelle
            // Note: Il faudra peut-être ajouter une méthode getSalles() dans Donjon ou utiliser l'index
            Salle salleActuelle = donjon.getSalleActuelle();
            donjon.setSalleActuelle(salleActuelle);

            ihm.afficherDescriptionSalle(salleActuelle); // Affiche description, ennemis, objets

            // --- Phase de Combat ---
            if (!salleActuelle.estNettoye()) {
                ihm.afficherMessage("Des ennemis vous bloquent le passage ! Combat engagé !");
                boolean victoire = gererCombat(joueur, salleActuelle);

                if (!victoire) {
                    ihm.afficherMessage("Vous avez été vaincu... Game Over.");
                    return; // Fin de la partie
                }

                ihm.afficherMessage("Salle nettoyée !");
            }

            // --- Phase d'Exploration (Loot) ---
            // Tant qu'il y a des objets et que le joueur veut fouiller
            while (!salleActuelle.getObjetsAuSol().isEmpty()) {
                boolean veutRamasser = ihm.demanderSiRamasserObjet();
                if (!veutRamasser) break;

                // L'IHM demande quel objet ramasser parmi la liste au sol
                Objet objetChoisi = ihm.choisirObjetAuSol(salleActuelle.getObjetsAuSol());
                if (objetChoisi != null) {
                    joueur.prendreObjet(objetChoisi);
                    salleActuelle.getObjetsAuSol().remove(objetChoisi);
                    ihm.afficherMessage("Vous avez ramassé : " + objetChoisi.getNom());
                }
            }

            // Passage à la salle suivante
            donjon.setSalleActuelleIndex(donjon.getSalleActuelleIndex() + 1);
            if(donjon.getSalleActuelleIndex() < 10) {
                ihm.afficherMessage("Vous avancez vers la salle suivante...");
            }
        }

        // --- 5. Fin de partie (Victoire) ---
        if (!joueur.estMort()) {
            ihm.afficherMessage("FÉLICITATIONS ! Vous avez traversé le donjon et vaincu le Boss !");
        }
    }

    /**
     * Gère la logique d'un combat dans une salle spécifique.
     * @return true si le joueur gagne, false s'il meurt.
     */
    private boolean gererCombat(Joueur joueur, Salle salle) {
        Combat combat = new Combat(joueur, salle.getEnnemies(), salle);

        // Boucle du combat
        while (!combat.estTerminer()) {
            ihm.afficherCombat(joueur, salle.getEnnemies());

            // --- Tour du Joueur ---
            // 1. Attaquer ou 2. Inventaire
            int action = ihm.demanderActionCombat();

            if (action == 1) { // Attaquer
                PNJ cible = ihm.choisirCible(salle.getEnnemies());
                String resultatAttaque = joueur.attaquer(cible);
                ihm.afficherMessage(resultatAttaque);

                // Vérifier si la cible est morte
                if (cible.estMort()) {
                    ihm.afficherMessage(cible.getNom() + " s'effondre !");
                    salle.getEnnemies().remove(cible);
                }

            } else if (action == 2) { // Inventaire
                // Affiche l'inventaire et permet d'utiliser/équiper
                gererInventaireCombat(joueur);
            }

            // Vérification fin combat (tous ennemis morts)
            if (salle.estNettoye()) {
                return true;
            }

            // --- Tour des Ennemis ---
            ihm.afficherMessage("--- Tour des ennemis ---");
            for (Object obj : salle.getEnnemies()) { // Utilisation de Object car List générique dans Salle, cast nécessaire
                PNJ ennemi = (PNJ) obj;
                if (!ennemi.estMort()) {
                    String resultatAttaqueEnnemi = ennemi.attaquer(joueur);
                    ihm.afficherMessage(resultatAttaqueEnnemi);

                    if (joueur.estMort()) {
                        return false;
                    }
                }
            }
        }

        return !joueur.estMort();
    }

    /**
     * Gère l'accès à l'inventaire pendant le combat (consommer ou équiper).
     */
    private void gererInventaireCombat(Joueur joueur) {
        if (joueur.getInventaire().isEmpty()) {
            ihm.afficherMessage("Votre inventaire est vide !");
            return;
        }

        Objet objet = ihm.choisirObjetInventaire(joueur.getInventaire());

        if (objet != null) {
            if (objet instanceof Equipement) {
                joueur.equiper((Equipement) objet);
                ihm.afficherMessage("Vous vous équipez de : " + objet.getNom());
            } else {
                // On suppose que c'est une potion ou un aliment
                joueur.utiliserObjet(objet);
                ihm.afficherMessage("Vous utilisez : " + objet.getNom());
                ihm.afficherInfosJoueur(joueur); // Pour voir les PV remontés par exemple
            }
        }
    }
}
