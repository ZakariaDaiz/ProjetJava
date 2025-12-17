package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.ObjetClasses.ObjetMedievalFactory;
import modele.StrategyAttack.AttaquePhysique;

import java.util.HashMap;

public class Vautour extends PNJ{
    public Vautour() {
        super.nom = "Vautour";
        super.pv = 120;
        super.pvMax = 120;
        super.force = 15;
        super.dexterite = 8;
        super.constitution = 12;
        super.intelligence = 0;
        super.strategy = new AttaquePhysique("Attaque en piqué");
        super.equipementPorte = new HashMap<>();
        equipementPorte.put("main", new Equipement("Serres acerees", "Des griffes tranchantes comme des rasoirs", "main", "arme", 10));
    }

    public char getChar(){
        return 'V';
    }
}
