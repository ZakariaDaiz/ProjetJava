package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaquePhysique;

public class Barbare extends Joueur {

    public Barbare(String nom) {
        super(
                nom,
                2200, // PV
                20,  // Force
                10,  // Dextérité
                15,  // Constitution
                5,   // Intelligence
                new AttaquePhysique()
        );
        Equipement startingEquipement = new Equipement("Hache ebrechée", "Une hache ayant vu maintes batailles", "main",  30);
        Equipement armurePrincipale = new Equipement("Armure de fer","Une armure de fer très protectif","corps", 10);
        Equipement casque = new Equipement("Casque à cornes", "Un casque effrayant", "tete",  5);
        Equipement bottes = new Equipement("Bottes de cuir", "Des bottes de cuir", "pieds",  5);

        equiper(startingEquipement);
        equiper(armurePrincipale);
        equiper(casque);
        equiper(bottes);

        inventaire.put(startingEquipement, 1);
        inventaire.put(armurePrincipale, 1);
        inventaire.put(casque, 1);
        inventaire.put(bottes, 1);
    }
}
