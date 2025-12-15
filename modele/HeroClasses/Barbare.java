package modele.HeroClasses;

import modele.StrategyAttack.AttaquePhysique;

public class Barbare extends Joueur {

    public Barbare(String nom) {
        super(
                nom,
                150, // PV
                20,  // Force
                10,  // Dextérité
                15,  // Constitution
                5,   // Intelligence
                new AttaquePhysique()
        );
    }
}
