package modele.HeroClasses;

import modele.StrategyAttack.AttaqueDistante;

public class Archer extends Joueur {

    public Archer(String nom) {
        super(
                nom,
                120,        // PV
                12,         // Force
                18,         // Dextérité
                12,         // Constitution
                10,          // Intelligence
                new AttaqueDistante() // Tir a l'arc
        );
    }
}
