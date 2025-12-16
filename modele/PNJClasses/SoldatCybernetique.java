package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueDistante;

import java.util.HashMap;

public class SoldatCybernetique extends PNJ{
    public SoldatCybernetique() {
        super.nom = "SoldatCybernetique";
        super.pv = 110;
        super.pvMax = 110;
        super.force = 12;
        super.dexterite = 27;
        super.constitution = 5;
        super.intelligence = 0;
        super.strategy = new AttaqueDistante("Tirs bioniques");
        super.equipementPorte = new HashMap<>();
        equipementPorte.put("main", (Equipement) factoryFuturisteAcreer.createObject("arme a energie"));
        equipementPorte.put("tete", (Equipement) factoryFuturisteAcreer.createObject("casque"));
        equipementPorte.put("pieds", (Equipement) factoryFuturisteAcreer.createObject("bottes"));
        equipementPorte.put("jambes", (Equipement) factoryFuturisteAcreer.createObject("jambieres"));
        equipementPorte.put("corps", (Equipement) factoryFuturisteAcreer.createObject("armure"));
    }
}
