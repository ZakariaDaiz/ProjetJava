package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.ObjetClasses.ObjetMedievalFactory;
import modele.StrategyAttack.AttaqueDistante;
import modele.StrategyAttack.AttaquePhysique;

import java.util.HashMap;

public class Sorciere extends PNJ {
    public Sorciere() {
        super.nom = "Sorciere";
        super.pv = 100;
        super.pvMax = 100;
        super.force = 0;
        super.dexterite = 8;
        super.constitution = 3;
        super.intelligence = 10;
        super.strategy = new AttaqueDistante("Lancer de sort");
        super.equipementPorte = new HashMap<>();
        equipementPorte.put("arme", new Equipement("Baguette sombre", "Une baguette emanant une noirceur rare", "main", "arme", 10));
    }

    public char getChar(){
        return 'S';
    }
}
