package Controleur;

import modele.*;
import modele.AmbientClasses.*;
import modele.HeroClasses.HeroFactory;
import modele.ObjetClasses.Objet;
import modele.ObjetClasses.Equipement;
import modele.PNJClasses.PNJ;
import modele.ThemeClasses.*;
import Ihm.Ihm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
     */
    public void jouerPartie() {
        // --- 1. Menu Principal ---
        ihm.afficherMenuPrincipal();
        int choixMenu = ihm.saisirChoix();

        if (choixMenu == 2) {
            ihm.afficherMessage("Au revoir !");
            return;
        }

        // --- 2. Création du Personnage ---
        ihm.afficherMessage("Entrez le nom de votre héros :");
        String nom = ihm.saisirChaine();

        ihm.afficherMenuCreation();
        int choixClasse = ihm.saisirChoix();

        String[] classes = heroFactory.getClassesDisponibles();
        if (choixClasse < 1 || choixClasse > classes.length) {
            ihm.afficherErreur("Choix invalide !");
            return;
        }

        String classeChoisie = classes[choixClasse - 1];
        Joueur joueur = (Joueur) heroFactory.creerPersonnage(classeChoisie, nom);
        ihm.afficherSucces("Personnage créé : " + joueur.getNom() + " (" + classeChoisie + ")");

        // --- 3. Choix du Thème ---
        ihm.afficherMessage("Choix du thème :\n1. Médiéval\n2. Futuriste");
        int choixTheme = ihm.saisirChoix();

        ThemeFactory themeFactory;
        if (choixTheme == 1) {
            themeFactory = new ThemeMedievalFactory();
            ihm.afficherInfo("Thème médiéval sélectionné !");
        } else {
            themeFactory = new ThemeFuturisteFactory();
            ihm.afficherInfo("Thème futuriste sélectionné !");
        }

        // --- 4. Menu AVANT d'entrer dans le donjon (conforme au sujet) ---
        boolean entrerDonjon = false;
        while (!entrerDonjon) {
            ihm.afficherMenuAvantDonjon();
            int choixAvant = ihm.saisirChoix();

            switch (choixAvant) {
                case 1:
                    // Afficher l'inventaire
                    ihm.afficherInventaire(joueur.getInventaire());
                    ihm.afficherStatistiques(joueur);
                    break;
                case 2:
                    // Se rendre dans le donjon
                    entrerDonjon = true;
                    ihm.afficherSucces("Vous entrez dans le donjon...");
                    break;
                default:
                    ihm.afficherErreur("Choix invalide !");
            }
        }

        // --- 5. Génération du Donjon ---
        Donjon donjon = new Donjon(new ArrayList<>(), themeFactory);
        donjon.genererDonjon(themeFactory);
        ihm.afficherSucces("Donjon généré ! 10 salles vous attendent.");

        // --- 6. Boucle Principale du Jeu ---
        while (!joueur.estMort() && donjon.getSalleActuelleIndex() < 10) {
            Salle salleActuelle = donjon.getNextSalle();
            donjon.setSalleActuelle(salleActuelle);
            ihm.afficherDescriptionSalle(salleActuelle);

            // Si des ennemis sont présents, combat obligatoire
            if (!salleActuelle.estNettoye()) {
                ihm.afficherAvertissement("Des ennemis vous barrent la route !");
                boolean victoire = gererCombat(joueur, salleActuelle);
                if (!victoire) {
                    ihm.afficherErreur("GAME OVER - Vous êtes mort...");
                    return;
                }
                ihm.afficherSucces("Vous avez vaincu tous les ennemis !");
            }

            // Menu d'exploration
            ihm.afficherMenuJeu();
            int choixJeu = ihm.saisirChoix();

            switch (choixJeu) {
                case 1:
                    // Avancer vers la salle suivante
                    if (salleActuelle.estNettoye()) {
                        donjon.setSalleActuelleIndex(donjon.getSalleActuelleIndex() + 1);
                        ihm.afficherInfo("Vous avancez vers la salle suivante...");
                    } else {
                        ihm.afficherErreur("Vous ne pouvez pas avancer tant que des ennemis sont présents !");
                    }
                    break;
                case 2:
                    // Examiner la salle / Ramasser objet
                    gererLoot(joueur, salleActuelle);
                    break;
                case 3:
                    // Afficher inventaire
                    ihm.afficherInventaire(joueur.getInventaire());
                    gererInventaire(joueur);
                    break;
                case 4:
                    // Voir statistiques
                    ihm.afficherStatistiques(joueur);
                    break;
                case 5:
                    // Quitter
                    ihm.afficherMessage("Vous quittez le donjon...");
                    return;
                default:
                    ihm.afficherErreur("Choix invalide !");
            }
        }

        if (!joueur.estMort()) {
            ihm.afficherSucces("VICTOIRE ! Vous avez terminé le donjon !");
        }
    }

    /**
     * Gère le système de loot (ramasser des objets)
     */
    private void gererLoot(Joueur joueur, Salle salle) {
        if (salle.getObjetsAuSol().isEmpty()) {
            ihm.afficherMessage("Il n'y a rien à ramasser dans cette salle.");
            return;
        }

        ihm.afficherMessage("Objets disponibles :");
        for (int i = 0; i < salle.getObjetsAuSol().size(); i++) {
            Objet obj = salle.getObjetsAuSol().get(i);
            System.out.println((i + 1) + ". " + obj.getNom() + " - " + obj.getDescription());
        }

        ihm.afficherMessage("Quel objet voulez-vous ramasser ? (0 pour annuler)");
        int choix = ihm.saisirChoix();

        if (choix > 0 && choix <= salle.getObjetsAuSol().size()) {
            Objet obj = salle.getObjetsAuSol().get(choix - 1);
            joueur.prendreObjet(obj);
            salle.getObjetsAuSol().remove(obj);
            ihm.afficherSucces("Objet ramassé : " + obj.getNom());
        }
    }

    /**
     * Gère l'inventaire (utiliser/équiper des objets)
     */
    private void gererInventaire(Joueur joueur) {
        if (joueur.getInventaire().isEmpty()) {
            ihm.afficherMessage("Votre inventaire est vide.");
            return;
        }

        ihm.afficherMessage("Que voulez-vous faire ?\n1. Consommer un objet\n2. Équiper un objet\n3. Retour");
        int choix = ihm.saisirChoix();

        switch (choix) {
            case 1:
                consommerObjet(joueur);
                break;
            case 2:
                equiperObjet(joueur);
                break;
            case 3:
                return;
        }
    }

    /**
     * Consommer un objet (aliment, potion)
     */
    private void consommerObjet(Joueur joueur) {
        List<Objet> consommables = new ArrayList<>();
        for (Objet obj : joueur.getInventaire().keySet()) {
            if (!(obj instanceof Equipement)) {
                consommables.add(obj);
            }
        }

        if (consommables.isEmpty()) {
            ihm.afficherMessage("Vous n'avez aucun objet consommable.");
            return;
        }

        ihm.afficherMessage("Objets consommables :");
        for (int i = 0; i < consommables.size(); i++) {
            System.out.println((i + 1) + ". " + consommables.get(i).getNom());
        }

        int choix = ihm.saisirChoix();
        if (choix > 0 && choix <= consommables.size()) {
            Objet obj = consommables.get(choix - 1);
            joueur.utiliserObjet(obj);
            ihm.afficherSucces("Vous avez consommé : " + obj.getNom());
        }
    }

    /**
     * Équiper un objet
     */
    private void equiperObjet(Joueur joueur) {
        List<Equipement> equipements = new ArrayList<>();
        for (Objet obj : joueur.getInventaire().keySet()) {
            if (obj instanceof Equipement) {
                equipements.add((Equipement) obj);
            }
        }

        if (equipements.isEmpty()) {
            ihm.afficherMessage("Vous n'avez aucun équipement à porter.");
            return;
        }

        ihm.afficherMessage("Équipements disponibles :");
        for (int i = 0; i < equipements.size(); i++) {
            Equipement eq = equipements.get(i);
            System.out.println((i + 1) + ". " + eq.getNom() + " (Slot: " + eq.getTypeSlot() + ", Bonus: +" + eq.getBonus() + ")");
        }

        int choix = ihm.saisirChoix();
        if (choix > 0 && choix <= equipements.size()) {
            Equipement eq = equipements.get(choix - 1);
            joueur.equiper(eq);
            ihm.afficherSucces("Vous avez équipé : " + eq.getNom());
        }
    }

    /**
     * Gère le système de combat
     */
    private boolean gererCombat(Joueur joueur, Salle salle) {
        Combat combat = new Combat(joueur, salle.getEnnemies(), salle);

        while (!combat.estTerminer()) {
            ihm.afficherCombat(joueur, salle.getEnnemies());
            ihm.afficherMenuCombat();
            int action = ihm.saisirChoix();

            switch (action) {
                case 1:
                    // Attaquer
                    attaquerEnnemi(joueur, salle);
                    break;
                case 2:
                    // Consommer un objet (manger, boire potion)
                    consommerObjet(joueur);
                    break;
                case 3:
                    // S'équiper avec un objet
                    equiperObjet(joueur);
                    break;
                default:
                    ihm.afficherErreur("Action invalide !");
                    continue;
            }

            // Riposte des ennemis
            if (!salle.estNettoye()) {
                for (PNJ ennemi : salle.getEnnemies()) {
                    if (!ennemi.estMort()) {
                        String attaque = ennemi.attaquer(joueur);
                        ihm.afficherMessage(attaque);
                        if (joueur.estMort()) {
                            return false;
                        }
                    }
                }
            }
        }

        return !joueur.estMort();
    }

    /**
     * Attaquer un ennemi
     */
    private void attaquerEnnemi(Joueur joueur, Salle salle) {
        List<PNJ> ennemisVivants = new ArrayList<>();
        for (PNJ ennemi : salle.getEnnemies()) {
            if (!ennemi.estMort()) {
                ennemisVivants.add(ennemi);
            }
        }

        if (ennemisVivants.isEmpty()) {
            return;
        }

        ihm.afficherMessage("Quel ennemi attaquer ?");
        for (int i = 0; i < ennemisVivants.size(); i++) {
            System.out.println((i + 1) + ". " + ennemisVivants.get(i).getNom() + " (" + ennemisVivants.get(i).getPv() + " PV)");
        }

        int choix = ihm.saisirChoix();
        if (choix > 0 && choix <= ennemisVivants.size()) {
            PNJ cible = ennemisVivants.get(choix - 1);
            String resultat = joueur.attaquer(cible);
            ihm.afficherMessage(resultat);

            if (cible.estMort()) {
                ihm.afficherSucces(cible.getNom() + " a été vaincu !");
                salle.getEnnemies().remove(cible);
            }
        }
    }
}
