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
        Equipement startingEquipement = new Equipement("Baton en bouleau", "une baguette fragile en bouleau", "main", "arme", 3);
        equipementPorte.put("main", startingEquipement );
        inventaire.put(startingEquipement, 1);
    }
}
