package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaquePhysique;

public class Barbare extends Joueur {

    public Barbare(String nom) {
        super(
                nom,
                150, // PV
                20,  // Force
                10,  // Dextérité
                15,  // Constitution
                5,   // Intelligence
                new AttaquePhysique()
        );
        equipementPorte.put("arme", new Equipement("Hache ebrechée", "Une hache ayant vu maintes batailles", "main", "arme", 4));
    }
}
