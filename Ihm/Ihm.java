package Ihm;

import modele.AmbientClasses.Salle;
import modele.HeroClasses.HeroFactory;
import modele.ObjetClasses.Equipement;
import modele.ObjetClasses.Objet;
import modele.PNJClasses.PNJ;
import modele.Personnage;
import modele.Joueur;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe IHM (Interface Homme-Machine)
 * Gère toutes les interactions avec l'utilisateur (affichage et saisie)
 */
public class Ihm {

    // Codes ANSI pour les couleurs de texte
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Codes ANSI pour les couleurs de fond
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private final Scanner scanner;

    /**
     * Constructeur de l'IHM
     */
    public Ihm() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Affiche le menu principal du jeu
     */
    public void afficherMenuPrincipal() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("             BIENVENUE DANS LE DONJON");
        System.out.println("=".repeat(50));
        System.out.println("1. Nouvelle partie");
        System.out.println("2. Quitter");
        System.out.println("=".repeat(50));
    }

    /**
     * Affiche le menu de création de personnage avec stats dynamiques
     * @param hero La factory pour créer des instances temporaires
     */

    public void afficherMenuCreation(HeroFactory hero) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              CRÉATION DE PERSONNAGE");
        System.out.println("=".repeat(50));
        System.out.println("Choisissez votre classe :");
        System.out.println("1 - " + hero.getDescriptionClasse("barbare"));
        System.out.println("2 - " + hero.getDescriptionClasse("sorcier"));
        System.out.println("3 - " + hero.getDescriptionClasse("archer"));
        System.out.println("4 - " + hero.getDescriptionClasse("assassin"));
        System.out.println("=".repeat(50));
    }

    /**
     * Menu AVANT d'entrer dans le donjon
     */
    public void afficherMenuAvantDonjon() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("         AVANT D'ENTRER DANS LE DONJON");
        System.out.println("=".repeat(50));
        System.out.println("1. Afficher l'inventaire du personnage");
        System.out.println("2. Se rendre dans le donjon pour se battre");
        System.out.println("=".repeat(50));
    }

    /**
     * Affiche le menu dans une salle (avec choix de combat)
     */
    public void afficherMenuSalle(boolean ennemisPresents) {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Que voulez-vous faire ?");

        if (ennemisPresents) {
            System.out.println("1. Attaquer les ennemis (déclencher le combat)");
        } else {
            System.out.println("1. Avancer vers la salle suivante");
        }

        System.out.println("2. Ramasser un objet");
        System.out.println("3. Afficher l'inventaire");
        System.out.println("4. Voir les statistiques");
        System.out.println("5. Quitter le jeu");
        System.out.println("-".repeat(50));
    }

    /**
     * Menu de combat - pendant le combat
     */
    public void afficherMenuCombat() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("⚔ ACTIONS DE COMBAT :");
        System.out.println("1. Attaquer un ennemi");
        System.out.println("2. Utiliser un objet (potion, aliment)");
        System.out.println("-".repeat(50));
    }

    /**
     * Affiche la description d'une salle avec son terrain
     */
    public void afficherDescriptionSalle(Salle salle) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("=== " + salle.getDescription() + " ===");
        System.out.println("=".repeat(50));

        // Visualisation du terrain de la salle
        afficherTerrain(salle);

        // Informations détaillées sur les ennemis
        if (!salle.getEnnemies().isEmpty()) {
            System.out.println("\n👹 " + ANSI_YELLOW + "Ennemis :" + ANSI_RESET);
            for (PNJ ennemi : salle.getEnnemies()) {
                if (!ennemi.estMort()) {
                    System.out.println("   - " + ennemi.getNom() + " " + afficherBarreVie(ennemi.getPv(), ennemi.getPvMax()));
                }
            }
        }

        // Informations sur les objets au sol
        if (!salle.getObjetsAuSol().isEmpty()) {
            System.out.println("\n✦ Objets au sol :");
            for (Objet objet : salle.getObjetsAuSol()) {
                System.out.println("   - " + objet.getNom() + " : " + objet.getDescription());
            }
        }

        if (salle.estNettoye()) {
            System.out.println("\n" + ANSI_GREEN + "✓ La salle est sécurisée (aucun ennemi)." + ANSI_RESET);
        }
    }

    /**
     * Affiche l'état du combat en cours
     */
    public void afficherEtatCombat(Joueur joueur, List<PNJ> ennemis) {
        System.out.println("\n" + "╔" + "═".repeat(48) + "╗");
        System.out.println("║" + ANSI_RED + " ".repeat(16) + "⚔ COMBAT EN COURS ⚔" + " ".repeat(13) + ANSI_RESET + "║");
        System.out.println("╚" + "═".repeat(48) + "╝");

        // Affichage du joueur
        System.out.println("\n🗡 " + ANSI_CYAN + "Vous : " + joueur.getNom() + ANSI_RESET);
        System.out.println("   " + afficherBarreVie(joueur.getPv(), joueur.getPvMax()));

        // Affichage des ennemis
        System.out.println("\n👹 " + ANSI_RED + "Ennemis hostiles :" + ANSI_RESET);
        int compteur = 1;
        for (PNJ ennemi : ennemis) {
            if (!ennemi.estMort()) {
                System.out.println("   " + compteur + ". " + ennemi.getNom() + " " +
                        afficherBarreVie(ennemi.getPv(), ennemi.getPvMax()));
                compteur++;
            }
        }
    }

    /**
     * Affiche le terrain de la salle (grille 4x4) avec couleurs
     */
    private void afficherTerrain(Salle salle) {
        System.out.println("\n┌" + "─".repeat(14) + "┐");
        char[][] terrain = salle.getTerrain();
        for (char[] chars : terrain) {
            System.out.print("│ ");
            for (char symbole : chars) {
                System.out.print(obtenirCouleurSymbole(symbole) + " " +symbole + " " + ANSI_RESET);
            }
            System.out.println(" │");
        }
        System.out.println("└" + "─".repeat(14) + "┘");

        // Légende
        System.out.println("\nLégende : " + ANSI_CYAN + "@" + ANSI_RESET + " = Vous | " +
                ANSI_RED + "Lettres" + ANSI_RESET + " = Ennemis | " +
                ANSI_YELLOW + "O" + ANSI_RESET + " = Objets | " +
                ANSI_PURPLE + "B" + ANSI_RESET + " = Boss | " +
                ANSI_WHITE + "#" + ANSI_RESET + " = Vide");
    }

    /**
     * Retourne la couleur ANSI pour un symbole donné
     */
    private String obtenirCouleurSymbole(char symbole) {
        return switch (symbole) {
            case '@' -> ANSI_CYAN;
            case 'O' -> ANSI_YELLOW;
            case '#' -> ANSI_WHITE;
            case 'B' -> ANSI_PURPLE;
            default -> ANSI_RED;
        };
    }

    /**
     * Affiche une barre de vie colorée
     */
    public String afficherBarreVie(int pv, int pvMax) {
        int barreLength = 20;
        int filled = (int) ((double) pv / pvMax * barreLength);

        String couleur;
        if (pv > pvMax * 0.6) {
            couleur = ANSI_GREEN;
        } else if (pv > pvMax * 0.3) {
            couleur = ANSI_YELLOW;
        } else {
            couleur = ANSI_RED;
        }

        String barre = "[" + couleur + "█".repeat(Math.max(0, filled)) +
                ANSI_WHITE + "░".repeat(Math.max(0, barreLength - filled)) +
                ANSI_RESET + "] " + pv + "/" + pvMax + " PV";
        return barre;
    }

    /**
     * Affiche l'inventaire du joueur
     */
    public void afficherInventaire(Map<Objet, Integer> inventaire) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("              INVENTAIRE");
        System.out.println("=".repeat(50));

        if (inventaire.isEmpty()) {
            System.out.println("Votre inventaire est vide.");
        } else {
            int index = 1;
            for (Map.Entry<Objet, Integer> entry : inventaire.entrySet()) {
                Objet obj = entry.getKey();
                int quantite = entry.getValue();
                String type = (obj instanceof Equipement) ? "[Équipement]" : "[Consommable]";
                System.out.println(index + ". " + obj.getNom() + " " + type +
                        " x" + quantite + " - " + obj.getDescription());
                index++;
            }
        }
        System.out.println("=".repeat(50));
    }

    /**
     * Affiche les statistiques du joueur
     */
    public void afficherStatistiques(Joueur joueur) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("      STATISTIQUES DE " + joueur.getNom().toUpperCase());
        System.out.println("=".repeat(50));
        System.out.println("Classe       : " + joueur.getClass().getSimpleName());
        System.out.println("Points de Vie: " + afficherBarreVie(joueur.getPv(), joueur.getPvMax()));
        System.out.println("\nCaractéristiques :");
        System.out.println("  Force        : " + joueur.getForce());
        System.out.println("  Dextérité    : " + joueur.getDexterite());
        System.out.println("  Constitution : " + joueur.getConstitution());
        System.out.println("  Intelligence : " + joueur.getIntelligence());

        // Affichage équipement
        System.out.println("\nÉquipement porté :");
        if (joueur.getEquipementPorte().isEmpty()) {
            System.out.println("  Aucun équipement");
        } else {
            for (Map.Entry<String, Equipement> entry : joueur.getEquipementPorte().entrySet()) {
                Equipement eq = entry.getValue();
                System.out.println("  " + entry.getKey() + " : " + eq.getNom() + " (Bonus: +" + eq.getBonus() + ")");
            }
        }

        // Affichage des effets
        if (joueur.getToursBoostForce() > 0 || joueur.getToursResistance() > 0) {
            System.out.println("\n✨ Effets actifs :");
            System.out.println("  " + joueur.getEffetsActifs());
        }

        System.out.println("=".repeat(50));
    }

    /**
     * Affiche un message générique
     */
    public void afficherMessage(String msg) {
        System.out.println("\n>> " + msg);
    }

    /**
     * Affiche un message de succès (en vert)
     */
    public void afficherSucces(String msg) {
        System.out.println("\n" + ANSI_GREEN + "✓ " + msg + ANSI_RESET);
    }

    /**
     * Affiche un message d'erreur (en rouge)
     */
    public void afficherErreur(String msg) {
        System.out.println("\n" + ANSI_RED + "✗ " + msg + ANSI_RESET);
    }

    /**
     * Affiche un message d'avertissement (en jaune)
     */
    public void afficherAvertissement(String msg) {
        System.out.println("\n" + ANSI_YELLOW + "⚠ " + msg + ANSI_RESET);
    }

    /**
     * Affiche un message d'information (en bleu)
     */
    public void afficherInfo(String msg) {
        System.out.println("\n" + ANSI_BLUE + "ℹ " + msg + ANSI_RESET);
    }

    /**
     * Demande à l'utilisateur de saisir un choix numérique
     */
    public int saisirChoix() {
        System.out.print("\nVotre choix : ");
        try {
            int choix = scanner.nextInt();
            scanner.nextLine();
            return choix;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    /**
     * Demande à l'utilisateur de saisir une chaîne de caractères
     */
    public String saisirChaine() {
        System.out.print("\nVotre saisie : ");
        return scanner.nextLine();
    }

    /**
     * Ferme le scanner
     */
    public void fermer() {
        scanner.close();
    }
}
