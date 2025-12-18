package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueFurtive;

public class Assassin extends Joueur {

    public Assassin(String nom) {
        super(
                nom,
                110,        // PV
                50,         // Force
                30,         // Dextérité
                10,         // Constitution
                0,          // Intelligence
                new AttaqueFurtive() // Coup de Dague
        );
        Equipement startingEquipement = new Equipement("dague émoussé", "une dague abimée par le temps", "main", "arme", 20);
        Equipement armureCuir = new Equipement("Armure de cuir", "Légère et silencieuse", "corps", "armure", 4);
        Equipement cape = new Equipement("Cape de l'ombre", "Permet de se fondre dans la nuit", "dos", "armure", 2);

        equipementPorte.put("main", startingEquipement);
        equipementPorte.put("corps", armureCuir);
        equipementPorte.put("dos", cape);

        inventaire.put(startingEquipement, 1);
        inventaire.put(armureCuir, 1);
        inventaire.put(cape, 1);
    }
}
