package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaquePhysique;
import modele.ObjetClasses.ObjetMedievalFactory;
import java.util.HashMap;

public class ChevalierErrant extends PNJ {
    public ChevalierErrant() {
        super.nom = "ChevalierErrant";
        super.pv = 120;
        super.pvMax = 120;
        super.force = 15;
        super.dexterite = 8;
        super.constitution = 12;
        super.intelligence = 0;
        super.strategy = new AttaquePhysique("Coup d'épée");
        super.equipementPorte = new HashMap<>();
        equipementPorte.put("main", (Equipement) factoryMedievealeAcreer.createObject("epee"));
        equipementPorte.put("bras", (Equipement) factoryMedievealeAcreer.createObject("bouclier"));
    }
}

