package modele.HeroClasses;

import modele.Personnage;

public class HeroFactory  {

    public Personnage creerPersonnage(String classe, String nom) {
        switch (classe.toLowerCase()) {
            case "barbare":
                return new Barbare(nom);

            case "sorcier":
                return new Sorcier(nom);

            case "archer":
                return new Archer(nom);

            case "assassin":
                return new Assassin(nom);

            default:
                throw new IllegalArgumentException("Classe de héros inconnue : " + classe);
        }
    }

    public String[] getClassesDisponibles() {
        return new String[]{"barbare", "sorcier", "archer", "assassin"};
    }


    public String getDescriptionClasse(String classe) {
        switch (classe.toLowerCase()) {
            case "barbare":
                return "Barbare - Guerrier puissant\n" +
                        "  PV: 150 | Force: 20 | Dextérité: 10 | Constitution: 15 | Intelligence: 5\n" +
                        "  Attaque: Coup de hache";

            case "sorcier":
                return "Sorcier - Maître de la magie\n" +
                        "  PV: 100 | Force: 5 | Dextérité: 8 | Constitution: 10 | Intelligence: 25\n" +
                        "  Attaque: Sort de feu";

            case "archer":
                return "Archer - Tireur d'élite\n" +
                        "  PV: 120 | Force: 12 | Dextérité: 18 | Constitution: 12 | Intelligence: 10\n" +
                        "  Attaque: Tir à l'arc";

            case "assassin":
                return "Assassin - Combattant furtif\n" +
                        "  PV: 110 | Force: 15 | Dextérité: 20 | Constitution: 10 | Intelligence: 8\n" +
                        "  Attaque: Coup de dague furtif";

            default:
                return "Classe inconnue";
        }
    }
}
