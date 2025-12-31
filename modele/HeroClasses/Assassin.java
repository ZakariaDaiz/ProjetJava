package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Arme;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueFurtive;
import modele.CompetencePassive.*;

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
        
        ajouterCompetence(new Regeneration());
        ajouterCompetence(new ContreAttaque());
        ajouterCompetence(new Adrenaline());

        Equipement startingEquipement = new Arme("dague émoussé", "une dague abimée par le temps", "main",  20, strategy);
        Equipement armureCuir = new Equipement("Armure de cuir", "Légère et silencieuse", "corps",  4);
        Equipement cape = new Equipement("Cape de l'ombre", "Permet de se fondre dans la nuit", "dos",  2);

        equiper(startingEquipement);
        equiper(armureCuir);
        equiper(cape);

        inventaire.put(startingEquipement, 1);
        inventaire.put(armureCuir, 1);
        inventaire.put(cape, 1);
    }
}
