package modele.PNJClasses;
import modele.StrategyAttack.AttaqueMagique;
import modele.StrategyAttack.AttaquePhysique;
import modele.StrategyAttack.StrategyAttaque;

import java.util.HashMap;

public class BossHydreMecha extends PNJ{
    public BossHydreMecha() {
        super.nom = "BossHydreMecha";
        super.pv = 500;
        super.pvMax = 500;
        super.force = 20;
        super.dexterite = 20;
        super.constitution = 5;
        super.intelligence = 15;
        super.strategy = new AttaquePhysique("Coups de poing hydrauliques");
        StrategyAttaque strategy2 = new AttaqueMagique("Tirs de miniguns");
        super.equipementPorte = new HashMap<>();
    }
}
