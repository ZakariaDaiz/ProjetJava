package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueDistante;

import java.util.HashMap;

public class DroneCombat extends PNJ{

    public DroneCombat() {
        super.nom = "DroneCombat";
        super.pv = 100;
        super.pvMax = 100;
        super.force = 5;
        super.dexterite = 20;
        super.constitution = 5;
        super.intelligence = 0;
        super.strategy = new AttaqueDistante("Tir de missile");
        super.equipementPorte = new HashMap<String, Equipement>();
    }
}
