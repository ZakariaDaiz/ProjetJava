package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueDistante;

import java.util.HashMap;

public class DroneCombat extends PNJ{

    public DroneCombat() {
        super.nom = "DroneCombat";
        super.pv = 60;
        super.pvMax = 60;
        super.force = 5;
        super.dexterite = 15;
        super.constitution = 5;
        super.intelligence = 0;
        super.strategy = new AttaqueDistante("Tir de missile");
        super.equipementPorte = new HashMap<>();
        equipementPorte.put("main", (Equipement) factoryFuturisteAcreer.createObject("lance-missile"));
    }
}
