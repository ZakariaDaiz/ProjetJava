package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Arme;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueMagique;
import modele.CompetencePassive.*;

public class Sorcier extends Joueur {

    public Sorcier(String nom) {
        super(
                nom,
                160,        // PV
                5,         // Force
                8,         // Dextérité
                10,         // Constitution
                40,          // Intelligence

                new AttaqueMagique() // Sort de feu
        );
        
        ajouterCompetence(new Regeneration());
        ajouterCompetence(new BouclierMagique());

        Equipement startingEquipement = new Arme("Baton en bouleau", "une baguette fragile en bouleau", "main", 30, strategy);
        Equipement chapeau = new Equipement("Chapeau pointu", "Un chapeau de sorcier classique", "tete",  2);

        equiper(startingEquipement);
        equiper(chapeau);

        inventaire.put(startingEquipement, 1);
        inventaire.put(chapeau, 1);
    }
}
