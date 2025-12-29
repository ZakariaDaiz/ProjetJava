package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaquePhysique;

import java.util.HashMap;

public class SorciereVaudou extends PNJ{
    public SorciereVaudou(){
        super.nom = "Sorciere Vaudou";
        super.pv = 120;
        super.pvMax = 120;
        super.force = 15;
        super.dexterite = 8;
        super.constitution = 12;
        super.intelligence = 0;
        super.strategy = new AttaquePhysique("Attaque Ouija");
        super.equipementPorte = new HashMap<>();
        equipementPorte.put("main", new Equipement("Table Ouija", "Un outile permettant de jeter des malédictions", "main", "arme", 10));
    }

    public char getChar(){ return 'S'; }
}

