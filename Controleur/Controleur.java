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

/**
 * La classe Controleur gère le déroulement des tours et de l'avancement dans les donjons.
 */
public class Controleur {

    private final Ihm ihm;
    private final HeroFactory heroFactory;

    public Controleur(Ihm ihm) {
        this.ihm = ihm;
        this.heroFactory = new HeroFactory();
    }

    /**
     * Boucle principale du jeu.
     */
    public void jouerPartie() {
        while (true) {
            //Menu Principal
            int choixMenu = 0;

            while(choixMenu!=1 && choixMenu!=2 ) {
                ihm.afficherMenuPrincipal();
                choixMenu=ihm.saisirChoix();
            }

            if (choixMenu == 2) {
                ihm.afficherMessage("Au revoir !");
                return;
            }

            //Création du Personnage
            ihm.afficherMessage("Entrez le nom de votre héros :");
            String nom = ihm.saisirChaine();

            ihm.afficherMenuCreation(heroFactory);
            int choixClasse = ihm.saisirChoix();

            String[] classes = heroFactory.getClassesDisponibles();
            while (choixClasse < 1 || choixClasse > classes.length) {
                ihm.afficherErreur("Choix invalide !");
                choixClasse = ihm.saisirChoix();
            }

            String classeChoisie = classes[choixClasse - 1];
            Joueur joueur = (Joueur) heroFactory.creerPersonnage(classeChoisie, nom);
            ihm.afficherSucces("Personnage créé : " + joueur.getNom() + " (" + classeChoisie + ")");

            //Choix du Thème
            ihm.afficherMessage("Choix du thème :\n1. Médiéval\n2. Futuriste");
            int choixTheme = ihm.saisirChoix();

            while(choixTheme!=1 && choixTheme!=2 ) {
                ihm.afficherMessage("Choix du thème :\n1. Médiéval\n2. Futuriste");
                choixTheme=ihm.saisirChoix();
            }

            ThemeFactory themeFactory;
            if (choixTheme == 1) {
                themeFactory = new ThemeMedievalFactory();
                ihm.afficherInfo("Thème médiéval sélectionné !");
            } else {
                themeFactory = new ThemeFuturisteFactory();
                ihm.afficherInfo("Thème futuriste sélectionné !");
            }

            //Menu AVANT d'entrer dans le donjon
            boolean entrerDonjon = false;
            while (!entrerDonjon) {
                int choixAvant = 0;

                while(choixAvant!=1 && choixAvant!=2 ) {
                    ihm.afficherMenuAvantDonjon();
                    choixAvant=ihm.saisirChoix();
                }


                switch (choixAvant) {
                    case 1:
                        // Afficher l'inventaire et statistiques
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

            //Génération du Donjon
            Donjon donjon = new Donjon(new ArrayList<>(), themeFactory);
            donjon.genererDonjon(themeFactory);
            ihm.afficherSucces("Donjon généré ! 10 salles vous attendent.");

            //Boucle Principale du Jeu
            boolean abandon = false;
            while (!joueur.estMort() && donjon.getSalleActuelleIndex() < 10) {
                Salle salleActuelle = donjon.getNextSalle();
                donjon.setSalleActuelle(salleActuelle);
                ihm.afficherDescriptionSalle(salleActuelle);

                boolean enCombat = false;
                boolean ennemisPresents = !salleActuelle.estNettoye();

                // Menu de la salle
                while (!joueur.estMort() && !enCombat) {
                    ihm.afficherMenuSalle(ennemisPresents);
                    int choixSalle = 0;


                    while( choixSalle<1 || choixSalle >5 ) {
                        choixSalle=ihm.saisirChoix();
                    }

                    switch (choixSalle) {
                        case 1:
                            if (ennemisPresents) {
                                // Attaquer les ennemis
                                ihm.afficherAvertissement("Vous déclenchez le combat en attaquant les ennemis !");
                                enCombat = true;
                            } else {
                                // Avancer vers la salle suivante
                                donjon.setSalleActuelleIndex(donjon.getSalleActuelleIndex() + 1);
                                ihm.afficherInfo("Vous avancez vers la salle suivante...");
                                break;
                            }
                            break;
                        case 2:
                            // Ramasser un objet
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
                            abandon = true;
                            break; 
                        default:
                            ihm.afficherErreur("Choix invalide !");
                    }

                    // Si on a avancé de salle ou abandonné, sortir de la boucle
                    if (abandon || (choixSalle == 1 && !ennemisPresents)) {
                        break;
                    }
                }
                
                if (abandon) {
                    break;
                }

                //Gestion du Combat
                if (enCombat) {
                    boolean combatTermine = gererCombat(joueur, salleActuelle);

                    if (!combatTermine) {
                        ihm.afficherErreur("GAME OVER - Vous êtes mort...");
                        break; // Sort du jeu, retourne au menu principal
                    }

                    ihm.afficherSucces("Vous avez vaincu tous les ennemis de cette salle !");

                    // Avancer automatiquement après avoir vaincu tous les ennemis
                    if (donjon.getSalleActuelleIndex() < 9) {
                        donjon.setSalleActuelleIndex(donjon.getSalleActuelleIndex() + 1);
                        ihm.afficherInfo("Vous pouvez maintenant avancer...");
                    }
                }
            }
            
            if (abandon) {
                 continue; // Retour au menu principal
            }

            if (!joueur.estMort()) {
                ihm.afficherSucces("VICTOIRE ! Vous avez terminé le donjon !");
            }
            
            // Demander si le joueur veut rejouer directement ou retourner au menu
            ihm.afficherMessage("\nAppuyez sur n'importe quelle touche pour retourner au menu principal...");
            ihm.saisirChaine();
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
            ihm.afficherMessage((i + 1) + ". " + obj.getNom() + " - " + obj.getDescription());
        }

        ihm.afficherMessage("Quel objet voulez-vous ramasser ? (0 pour annuler)");
        int choix = ihm.saisirChoix();

        while (choix < 1 || choix > salle.getObjetsAuSol().size()) {
            ihm.afficherErreur("Choix invalide !");
            choix = ihm.saisirChoix();
        }

        Objet obj = salle.getObjetsAuSol().get(choix - 1);
        joueur.prendreObjet(obj);
        salle.getObjetsAuSol().remove(obj);
        ihm.afficherSucces("Objet ramassé : " + obj.getNom());
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
        int choix = 0;

        while(choix != 1 && choix != 2) {
            choix=ihm.saisirChoix();
        }

        switch (choix) {
            case 1:
                consommerObjet(joueur, false);
                break;
            case 2:
                equiperObjet(joueur);
                break;
        }
    }

    /**
     * Consommer un objet (aliment, potion)
     * @param afficherImpact si true, affiche l'impact sur l'état du joueur
     */
    private boolean consommerObjet(Joueur joueur, boolean afficherImpact) {
        List<Objet> consommables = new ArrayList<>();
        for (Objet obj : joueur.getInventaire().keySet()) {
            if (!(obj instanceof Equipement)) {
                consommables.add(obj);
            }
        }

        if (consommables.isEmpty()) {
            ihm.afficherAvertissement("Vous n'avez aucun objet consommable.");
            return false;
        }


        int choix = -1;

        while (choix < 0 || choix > consommables.size()) {
            ihm.afficherMessage("Objets consommables :");
            for (int i = 0; i < consommables.size(); i++) {
                ihm.afficherMessage((i + 1) + ". " + consommables.get(i).getNom());
            }
            choix = ihm.saisirChoix();
        }

            Objet obj = consommables.get(choix - 1);

        // Sauvegarder l'état avant
        int pvAvant = joueur.getPv();
        int forceAvant = joueur.getForce();
        int dexteriteAvant = joueur.getDexterite();
        int constitutionAvant = joueur.getConstitution();

        joueur.utiliserObjet(obj);
        ihm.afficherSucces("Vous avez consommé : " + obj.getNom());

        // Afficher l'impact si demandé
        if (afficherImpact) {
            ihm.afficherMessage("\n📊 Impact sur votre état :");
            if (joueur.getPv() != pvAvant) {
                ihm.afficherMessage("   PV : " + pvAvant + " → " + joueur.getPv() +
                        " (" + (joueur.getPv() > pvAvant ? "+" : "") + (joueur.getPv() - pvAvant) + ")");
            }
            if (joueur.getForce() != forceAvant) {
                ihm.afficherMessage("   Force : " + forceAvant + " → " + joueur.getForce());
            }
            if (joueur.getDexterite() != dexteriteAvant) {
                ihm.afficherMessage("   Dextérité : " + dexteriteAvant + " → " + joueur.getDexterite());
            }
            if (joueur.getConstitution() != constitutionAvant) {
                ihm.afficherMessage("   Constitution : " + constitutionAvant + " → " + joueur.getConstitution());
            }
            ihm.afficherMessage("   État actuel : " + ihm.afficherBarreVie(joueur.getPv(), joueur.getPvMax()));
        }
        return true;
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

        int choix = -1;

        while (choix < 0 || choix > equipements.size()) {
            ihm.afficherMessage("Équipements disponibles :");
            for (int i = 0; i < equipements.size(); i++) {
                Equipement eq = equipements.get(i);
                ihm.afficherMessage((i + 1) + ". " + eq.getNom() + " (Slot: " + eq.getTypeSlot() + ", Bonus: +" + eq.getBonus() + ")");
            }
            choix = ihm.saisirChoix();
        }

        Equipement eq = equipements.get(choix - 1);
        joueur.equiper(eq);
        ihm.afficherSucces("Vous avez équipé : " + eq.getNom());
    }

    /**
     * Gère le système de combat
     * Les ennemis n'attaquent QUE si le joueur les provoque
     * Tous les PNJ attaquent si le joueur a attaqué un des PNJ
     */
    private boolean gererCombat(Joueur joueur, Salle salle) {
        boolean combatProvoque = false;

        while (!joueur.estMort() && !salle.estNettoye()) {
            ihm.afficherEtatCombat(joueur, salle.getEnnemies());

            // Afficher les effets actifs
            if (joueur.getToursBoostForce() > 0 || joueur.getToursResistance() > 0) {
                ihm.afficherInfo("✨ Effets actifs : " + joueur.getEffetsActifs());
            }

            ihm.afficherMenuCombat();
            int action = ihm.saisirChoix();

            while (action != 1 && action != 2) {
                ihm.afficherErreur("choix invalide !");
                action = ihm.saisirChoix();
            }



            switch (action) {
                case 1:
                    attaquerEnnemi(joueur, salle);
                    combatProvoque = true;
                    break;
                case 2:
                    if(!consommerObjet(joueur, true)) {
                        ihm.afficherAvertissement("L'attaque est la seule option !");
                        attaquerEnnemi(joueur, salle);
                        combatProvoque = true;
                    };
                    break;
                default:
                    ihm.afficherErreur("Action invalide !");
                    continue;
            }

            // Mettre à jour les effets du joueur
            String effetsExpires = joueur.mettreAJourEffets();
            if (!effetsExpires.isEmpty()) {
                ihm.afficherAvertissement(effetsExpires);
            }

            // Les ennemis ripostent
            // Les ennemis ripostent
            if (combatProvoque && !salle.estNettoye()) {
                ihm.afficherAvertissement("\n⚔ Les ennemis ripostent !");

                for (PNJ ennemi : salle.getEnnemies()) {
                    if (!ennemi.estMort()) {
                        int pvAvant = joueur.getPv();
                        String attaque = ennemi.attaquer(joueur);

                        ihm.afficherMessage(attaque);
                        ihm.afficherMessage("   Votre état : " + pvAvant + " PV → " + joueur.getPv() + " PV");
                        ihm.afficherMessage("   " + ihm.afficherBarreVie(joueur.getPv(), joueur.getPvMax()));

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
     * Attaquer un ennemi - affiche l'évolution précise
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


        int choix = -1;

        while (choix < 1 || choix > ennemisVivants.size()) {
            ihm.afficherMessage("Quel ennemi attaquer ?");
            for (int i = 0; i < ennemisVivants.size(); i++) {
                ihm.afficherMessage((i + 1) + ". " + ennemisVivants.get(i).getNom() +
                        " (" + ennemisVivants.get(i).getPv() + " PV)");
            }
            choix = ihm.saisirChoix();
        }

        PNJ cible = ennemisVivants.get(choix - 1);
        int pvAvant = cible.getPv();

        String resultat = joueur.attaquer(cible);

        // Affichage précis de l'évolution
        ihm.afficherMessage(resultat);
        ihm.afficherMessage("   État de l'ennemi : " + pvAvant + " PV → " + cible.getPv() + " PV");
        ihm.afficherMessage("   " + ihm.afficherBarreVie(cible.getPv(), cible.getPvMax()));

        if (cible.estMort()) {
            ihm.afficherSucces("💀 " + cible.getNom() + " a été vaincu.e !");
            salle.getEnnemies().remove(cible);
        }
    }
}
