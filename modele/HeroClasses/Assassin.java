package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueFurtive;

public class Assassin extends Joueur {

    public Assassin(String nom) {
        super(
                nom,
                110,        // PV
                15,         // Force
                20,         // Dextérité
                10,         // Constitution
                8,          // Intelligence
                new AttaqueFurtive() // Coup de Dague
        );
        Equipement startingEquipement = new Equipement("dague émoussé", "une dague abimée par le temps", "main", "arme", 3);
        equipementPorte.put("main", startingEquipement );
        inventaire.put(startingEquipement, 1);
    }
}
