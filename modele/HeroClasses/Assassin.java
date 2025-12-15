package modele.HeroClasses;

import modele.StrategyAttack.AttaqueFurtive;

public class Assassin extends Joueur {

    public Assassin(String nom) {
        super(
                nom,
                110,        // PV
                15,         // Force
                20,         // Dextérité
                10,         // Constitution
                8,          // Intelligence
                new AttaqueFurtive() // Coup de Dague
        );
    }
}
