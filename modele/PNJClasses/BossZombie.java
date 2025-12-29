package modele.PNJClasses;
import modele.ObjetClasses.Equipement;
import modele.Personnage;
import modele.StrategyAttack.AttaqueMagique;
import modele.StrategyAttack.AttaquePhysique;
import modele.StrategyAttack.StrategyAttaque;

import java.util.HashMap;

public class BossZombie extends PNJ{
    protected StrategyAttaque strategy2;
    public BossZombie() {
        super.nom = "Boss Zombie";
        super.pv = 500;
        super.pvMax = 500;
        super.force = 20;
        super.dexterite = 20;
        super.constitution = 5;
        super.intelligence = 15;
        super.strategy = new AttaquePhysique("Morsure nécrotique");
        strategy2 = new AttaqueMagique("Cri d'épouvante");
        super.equipementPorte = new HashMap<>();
        equiper(new Equipement("Griffes putrides", "Ongles décomposés suintant un poison mortel", "main",  15));
    }
    public String attaquer(Personnage cible) {
        StrategyAttaque strat;
        if (((Math.random() * 1))==0) {
            strat= this.strategy;
        }
        else {
            strat= strategy2;
        }

        int degats = strat.calculerDegats(this, cible);
        cible.subirDegats(degats);

        return nom + " utilise " + strat.getNomAttaque()
                + " et inflige " + degats + " dégâts à " + cible.getNom();
    }
}

