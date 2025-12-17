package modele.HeroClasses;

import modele.Personnage;

public class HeroFactory {

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

    /**
     * Retourne la description complète d'une classe avec ses stats DYNAMIQUES
     * @param classe Le nom de la classe
     * @return La description formatée avec les stats réelles
     */
    public String getDescriptionClasse(String classe) {
        // Créer une instance temporaire pour récupérer les vraies stats
        Personnage perso = creerPersonnage(classe, "temp");

        String description = "";

        switch (classe.toLowerCase()) {
            case "barbare":
                description = "Barbare - Puissant guerrier au combat rapproché";
                break;
            case "sorcier":
                description = "Sorcier - Maître de la magie";
                break;
            case "archer":
                description = "Archer - Expert du tir à distance";
                break;
            case "assassin":
                description = "Assassin - Spécialiste des attaques furtives";
                break;
            default:
                return "Classe inconnue";
        }

        // Ajouter les stats dynamiques
        description += "\n   (PV: " + perso.getPvMax() +
                ", Force: " + perso.getForce() +
                ", Dextérité: " + perso.getDexterite() +
                ", Constitution: " + perso.getConstitution() +
                ", Intelligence: " + perso.getIntelligence() + ")";

        return description;
    }
}
