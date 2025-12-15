package modele.PNJClasses;

import modele.StrategyAttack.AttaqueMagique;
import modele.StrategyAttack.AttaquePhysique;
import modele.StrategyAttack.StrategyAttaque;

import java.util.HashMap;

public class BossDragon extends PNJ{
    public BossDragon() {
        super.nom = "BossDragon";
        super.pv = 500;
        super.pvMax = 500;
        super.force = 20;
        super.dexterite = 20;
        super.constitution = 5;
        super.intelligence = 15;
        super.strategy = new AttaquePhysique("Griffure du brasier");
        StrategyAttaque strategy2 = new AttaqueMagique("Souffle de feu");
        super.equipementPorte = new HashMap<>();
    }
}
