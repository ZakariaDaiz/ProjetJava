package modele.PNJClasses;

import modele.Personnage;
import modele.StrategyAttack.AttaquePhysique;

import java.util.HashMap;

public class Alien extends PNJ {

    public Alien() {
        super.nom = "Alien";
        super.pv = 100;
        super.pvMax = 100;
        super.force = 5;
        super.dexterite = 20;
        super.constitution = 5;
        super.intelligence = 0;
        super.strategy = new AttaquePhysique();
        super.equipementPorte = new HashMap<>();
    }
}