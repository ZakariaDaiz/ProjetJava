package modele.HeroClasses;

import modele.StrategyAttack.AttaqueMagique;

public class Sorcier extends Joueur {

    public Sorcier(String nom) {
        super(
                nom,
                100,        // PV
                5,         // Force
                8,         // Dextérité
                10,         // Constitution
                25,          // Intelligence
                new AttaqueMagique() // Sort de feu
        );
    }
}
