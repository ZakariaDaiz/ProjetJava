package modele.PNJClasses;

import modele.ObjetClasses.Arme;
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
        equiper( new Arme("Baguette sombre", "Une baguette emanant une noirceur rare", "main",  10, strategy));
    }

    public char getChar(){
        return 'S';
    }
}
