package modele.PNJClasses;

import modele.ObjetClasses.Arme;
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
        equiper( new Arme("Lance-missile tactique", "Un module lance-missile compact", "main",  10, strategy));
    }

    public char getChar(){
        return 'D';
    }
}
