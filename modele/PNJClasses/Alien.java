package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
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
        super.strategy = new AttaquePhysique("Griffure acide");
        super.equipementPorte = new HashMap<>();
        equipementPorte.put("main", new Equipement("Griffes Toxiques", "Des griffes empoisonnées", "main", "arme", 15));
    }

    public char getChar(){
        return 'A';
    }
}