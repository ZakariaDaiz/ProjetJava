package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueMagique;

public class Sorcier extends Joueur {

    public Sorcier(String nom) {
        super(
                nom,
                160,        // PV
                5,         // Force
                8,         // Dextérité
                10,         // Constitution
                40,          // Intelligence

                new AttaqueMagique() // Sort de feu
        );
        Equipement startingEquipement = new Equipement("Baton en bouleau", "une baguette fragile en bouleau", "main", "arme", 30);
        Equipement chapeau = new Equipement("Chapeau pointu", "Un chapeau de sorcier classique", "tete", "armure", 2);

        equipementPorte.put("main", startingEquipement);
        equipementPorte.put("tete", chapeau);

        inventaire.put(startingEquipement, 1);
        inventaire.put(chapeau, 1);
    }
}
