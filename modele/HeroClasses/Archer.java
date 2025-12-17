package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueDistante;

public class Archer extends Joueur {

    public Archer(String nom) {
        super(
                nom,
                10000,        // PV
                10000,         // Force
                23,         // Dextérité
                12,         // Constitution
                0,          // Intelligence
                new AttaqueDistante() // Tir a l'arc
        );
        Equipement startingEquipement = new Equipement("Arc basique", "Un arc de débutant", "main", "arme", 3);
        equipementPorte.put("main", startingEquipement );
        inventaire.put(startingEquipement, 1);
    }
}
