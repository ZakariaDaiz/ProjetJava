package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueDistante;
import modele.StrategyAttack.AttaqueFurtive;

import java.util.HashMap;

public class RobotSentinelle extends PNJ{
    public RobotSentinelle() {
        super.nom = "RobotSentinelle";
        super.pv = 110;
        super.pvMax = 110;
        super.force = 12;
        super.dexterite = 27;
        super.constitution = 5;
        super.intelligence = 0;
        super.strategy = new AttaqueDistante("Tirs de lasers");
        super.equipementPorte = new HashMap<>();
        equipementPorte.put("main", (Equipement) factoryFuturisteAcreer.createObject("pistolaser"));
    }
}
