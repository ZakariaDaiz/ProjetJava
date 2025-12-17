package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaquePhysique;

public class Barbare extends Joueur {

    public Barbare(String nom) {
        super(
                nom,
                220, // PV
                20,  // Force
                10,  // Dextérité
                15,  // Constitution
                5,   // Intelligence
                new AttaquePhysique()
        );
        Equipement startingEquipement = new Equipement("Hache ebrechée", "Une hache ayant vu maintes batailles", "main", "arme", 4);
        equipementPorte.put("main", startingEquipement );
        inventaire.put(startingEquipement, 1);
    }
}
