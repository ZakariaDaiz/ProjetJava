package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.ObjetClasses.ObjetMedievalFactory;
import modele.StrategyAttack.AttaquePhysique;

import java.util.HashMap;

public class RatEnrage extends PNJ{
    public RatEnrage() {
        super.nom = "RatEnrage";
        super.pv = 120;
        super.pvMax = 120;
        super.force = 15;
        super.dexterite = 8;
        super.constitution = 12;
        super.intelligence = 0;
        super.strategy = new AttaquePhysique("Morsure de rage");
        super.equipementPorte = new HashMap<>();
        equipementPorte.put("arme", (Equipement) factoryMedievealeAcreer.createObject("dents"));
    }
}
