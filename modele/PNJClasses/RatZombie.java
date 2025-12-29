package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaquePhysique;
import java.util.HashMap;

public class RatZombie extends PNJ {
    public RatZombie() {
        super.nom = "RatEnrage";
        super.pv = 120;
        super.pvMax = 120;
        super.force = 15;
        super.dexterite = 8;
        super.constitution = 12;
        super.intelligence = 0;
        super.strategy = new AttaquePhysique("Morsure infectieuse");
        super.equipementPorte = new HashMap<>();
        equipementPorte.put("main", new Equipement("Dents pointues", "Des dents zombifiées porteuses de maladies", "main", "arme", 10));
    }

    public char getChar(){
        return 'r';
    }
}