package modele.PNJClasses;
import modele.ObjetClasses.Equipement;
import modele.Personnage;
import modele.StrategyAttack.AttaqueMagique;
import modele.StrategyAttack.AttaquePhysique;
import modele.StrategyAttack.StrategyAttaque;

import java.util.HashMap;

public class BossHydreMecha extends PNJ{
    protected StrategyAttaque strategy2;
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
        equipementPorte.put("main", new Equipement("Noyau d'energie", "Amat d'energie lui permettant d'utiliser ses differentes attaques", "main", "arme", 15));
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
