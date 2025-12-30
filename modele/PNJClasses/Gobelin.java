package modele.PNJClasses;

import modele.ObjetClasses.Arme;
import modele.ObjetClasses.Equipement;
import modele.ObjetClasses.ObjetMedievalFactory;
import modele.StrategyAttack.AttaqueFurtive;
import modele.StrategyAttack.AttaquePhysique;

import java.util.HashMap;

public class Gobelin extends PNJ{
    public Gobelin() {
        super.nom = "Gobelin";
        super.pv = 80;
        super.pvMax = 120;
        super.force = 15;
        super.dexterite = 8;
        super.constitution = 12;
        super.intelligence = 0;
        super.strategy = new AttaqueFurtive("Coup de dague");
        super.equipementPorte = new HashMap<>();
        equiper( new Arme("Dagues", "Des dagues rouillées et ebrechées", "main",  10, strategy));
        }

    public char getChar(){
        return 'G';
    }
}
