package modele.PNJClasses;

import modele.ObjetClasses.Arme;
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
        equiper(new Arme("Dents pointues", "Des dents zombifiées porteuses de maladies", "main", 10, strategy));
    }

    public char getChar(){
        return 'r';
    }
}