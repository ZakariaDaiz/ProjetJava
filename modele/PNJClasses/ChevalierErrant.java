package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaquePhysique;
import modele.ObjetClasses.ObjetMedievalFactory;
import modele.ThemeClasses.ThemeMedievalFactory;

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
        equipementPorte.put("main", new Equipement("epee", "épée tranchante","main","arme",15));
        equipementPorte.put("corps", new Equipement("bouclier","bouclier en métal","corps","armure",15));
    }

    public char getChar(){
        return 'C';
    }
}

