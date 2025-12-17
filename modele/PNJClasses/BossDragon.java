package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.Personnage;
import modele.StrategyAttack.AttaqueMagique;
import modele.StrategyAttack.AttaquePhysique;
import modele.StrategyAttack.StrategyAttaque;


import java.util.HashMap;

public class BossDragon extends PNJ{
    protected StrategyAttaque strategy2;
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
        equipementPorte.put("main", new Equipement("Coeur enflammé du dragon", "Puissance volcanique venant des tréfonds de volcans lointains", "main", "arme", 20));

    }
    public String attaquer(Personnage cible) {
        StrategyAttaque strat;
        if (((Math.random() * 1))==0) {
            strat= this.strategy;
        }
        else {
            strat= strategy2;
        }

        int degats = strategy.calculerDegats(this, cible);
        cible.subirDegats(degats);

        return nom + " utilise " + strat
                + " et inflige " + degats + " dégâts à " + cible.getNom();
    }
}
