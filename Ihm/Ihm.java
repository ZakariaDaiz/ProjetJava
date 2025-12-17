package Ihm;

import modele.AmbientClasses.Salle;
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
        System.out.println("       BIENVENUE DANS LE DONJON");
        System.out.println("=".repeat(50));
        System.out.println("1. Nouvelle partie");
        System.out.println("2. Quitter");
        System.out.println("=".repeat(50));
    }

    /**
     * Affiche le menu de création de personnage
     */
    public void afficherMenuCreation() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("       CRÉATION DE PERSONNAGE");
        System.out.println("=".repeat(50));
        System.out.println("Choisissez votre classe :");
        System.out.println("1. Barbare - Puissant guerrier au combat rapproché");
        System.out.println("   (PV: 150, Force: 20, Dextérité: 10, Constitution: 15, Intelligence: 5)");
        System.out.println("2. Sorcier - Maître de la magie");
        System.out.println("   (PV: 100, Force: 5, Dextérité: 8, Constitution: 10, Intelligence: 25)");
        System.out.println("3. Archer - Expert du tir à distance");
        System.out.println("   (PV: 120, Force: 12, Dextérité: 18, Constitution: 12, Intelligence: 10)");
        System.out.println("4. Assassin - Spécialiste des attaques furtives");
        System.out.println("   (PV: 110, Force: 15, Dextérité: 20, Constitution: 10, Intelligence: 8)");
        System.out.println("=".repeat(50));
    }

    /**
     * Affiche le menu de jeu (exploration)
     */
    public void afficherMenuJeu() {
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1. Avancer vers la salle suivante");
        System.out.println("2. Examiner la salle");
        System.out.println("3. Gérer l'inventaire");
        System.out.println("4. Voir les statistiques");
        System.out.println("5. Quitter le jeu");
        System.out.println("-".repeat(50));
    }

    /**
     * Affiche la description d'une salle avec son terrain
     * @param salle La salle à décrire
     */
    public void afficherDescriptionSalle(Salle salle) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("=== " + salle.getDescription() + " ===");
        System.out.println("=".repeat(50));

        // Visualisation du terrain de la salle
        afficherTerrain(salle);

        // Informations détaillées sur les ennemis
        if (!salle.getEnnemies().isEmpty()) {
            System.out.println("\n⚔ Ennemis présents :");
            for (PNJ ennemi : salle.getEnnemies()) {
                if (!ennemi.estMort()) {
                    System.out.println("  - " + ennemi.getNom() + " (PV: " + ennemi.getPv() + "/" + ennemi.getPvMax() + ")");
                }
            }
        }

        // Informations sur les objets au sol
        if (!salle.getObjetsAuSol().isEmpty()) {
            System.out.println("\n✦ Objets au sol :");
            for (Objet objet : salle.getObjetsAuSol()) {
                System.out.println("  - " + objet.getNom() + " : " + objet.getDescription());
            }
        }

        if (salle.estNettoye()) {
            System.out.println("\n" + ANSI_GREEN + "✓ La salle est sécurisée." + ANSI_RESET);
        }
    }

    /**
     * Affiche le terrain de la salle (grille 5x5) avec couleurs
     * @param salle La salle dont on veut afficher le terrain
     */
    private void afficherTerrain(Salle salle) {
        System.out.println("\n┌" + "─".repeat(22) + "┐");

        char[][] terrain = salle.getTerrain();

        for (char[] chars : terrain) {
            System.out.print("│ ");
            for (char symbole : chars) {
                System.out.print(obtenirCouleurSymbole(symbole) + symbole + " " + ANSI_RESET);
            }
            System.out.println(" │");
        }

        System.out.println("└" + "─".repeat(22) + "┘");

        // Légende
        System.out.println("\nLégende : " + ANSI_CYAN + "@" + ANSI_RESET + " = Vous  " +
                ANSI_RED + "Lettres" + ANSI_RESET + " = Ennemis  " +
                ANSI_YELLOW + "O" + ANSI_RESET + " = Objets  " +
                ANSI_PURPLE + "B" + ANSI_RESET + " = Boss  " +
                ANSI_WHITE + "#" + ANSI_RESET + " = Vide");
    }

    /**
     * Retourne la couleur ANSI pour un symbole donné
     */
    private String obtenirCouleurSymbole(char symbole) {
        return switch (symbole) {
            case '@' -> // Joueur
                    ANSI_PURPLE+ANSI_CYAN;
            case 'O' -> // Objets
                    ANSI_BLUE_BACKGROUND+ANSI_YELLOW;
            case '#' -> // Cases vides
                    ANSI_PURPLE_BACKGROUND+ANSI_WHITE;
            case 'B' -> // Boss
                    ANSI_GREEN_BACKGROUND+ANSI_PURPLE;
            default -> // Ennemis (toutes les autres lettres)
                    ANSI_BLACK_BACKGROUND+ANSI_RED;
        };
    }

    /**
     * Affiche l'interface de combat
     * @param joueur Le joueur
     * @param ennemis La liste des ennemis
     */
    public void afficherCombat(Personnage joueur, List<PNJ> ennemis) {
        System.out.println("\n" + "╔" + "═".repeat(48) + "╗");
        System.out.println("║" + ANSI_RED + " ".repeat(18) + "COMBAT !" + " ".repeat(19) + ANSI_RESET + "║");
        System.out.println("╚" + "═".repeat(48) + "╝");

        // Affichage du joueur
        System.out.println("\n🗡 " + ANSI_CYAN + "Vous : " + joueur.getNom() + ANSI_RESET);
        System.out.println("   PV : " + joueur.getPv() + "/" + joueur.getPvMax());
        System.out.println(joueur.getPv());

        // Affichage des ennemis
        System.out.println("\n👹 " + ANSI_RED + "Ennemis :" + ANSI_RESET);
        for (int i = 0; i < ennemis.size(); i++) {
            PNJ ennemi = ennemis.get(i);
            if (!ennemi.estMort()) {
                System.out.println("   " + (i + 1) + ". " + ennemi.getNom() +
                        " - PV : " + ennemi.getPv() + "/" + ennemi.getPvMax());
                System.out.println(ennemi.getPv());
            }
        }

        System.out.println("\n" + "-".repeat(50));
        System.out.println("Actions :");
        System.out.println("1. Attaquer un ennemi");
        System.out.println("2. Utiliser un objet");
        System.out.println("3. Se défendre");
        System.out.println("-".repeat(50));
    }

    /**
     * Affiche l'inventaire du joueur
     * @param inventaire Map contenant les objets et leur quantité
     */
    public void afficherInventaire(Map<Objet, Integer> inventaire) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("       INVENTAIRE");
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
        System.out.println("1. Utiliser un objet");
        System.out.println("2. Équiper un objet (si équipement)");
        System.out.println("3. Retour");
        System.out.println("=".repeat(50));
    }

    /**
     * Affiche les statistiques du joueur
     * @param joueur Le joueur
     */
    public void afficherStatistiques(Joueur joueur) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("       STATISTIQUES DE " + joueur.getNom().toUpperCase());
        System.out.println("=".repeat(50));
        System.out.println("Classe : " + joueur.getClass().getSimpleName());
        System.out.println("Points de Vie : " + joueur.getPv() + "/" + joueur.getPvMax());
        System.out.println("\nCaractéristiques :");
        System.out.println("  Force : " + joueur.getForce());
        System.out.println("  Dextérité : " + joueur.getDexterite());
        System.out.println("  Constitution : " + joueur.getConstitution());
        System.out.println("  Intelligence : " + joueur.getIntelligence());
        System.out.println("=".repeat(50));
    }

    /**
     * Affiche un message générique
     * @param msg Le message à afficher
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
     * @return Le choix de l'utilisateur
     */
    public int saisirChoix() {
        System.out.print("\nVotre choix : ");
        try {
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne
            return choix;
        } catch (Exception e) {
            scanner.nextLine(); // Nettoyer le buffer
            return -1; // Choix invalide
        }
    }

    /**
     * Demande à l'utilisateur de saisir une chaîne de caractères
     * @return La chaîne saisie par l'utilisateur
     */
    public String saisirChaine() {
        System.out.print("\nVotre saisie : ");
        return scanner.nextLine();
    }

    /**
     * Ferme le scanner (à appeler à la fin du programme)
     */
    public void fermer() {
        scanner.close();
    }
}