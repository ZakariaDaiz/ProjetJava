package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Arme;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueMagique;
import modele.StrategyAttack.AttaquePhysique;
import modele.StrategyAttack.StrategyAttaque;

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

        Equipement startingEquipement = new Arme("Hache ebrechée", "Une hache ayant vu maintes batailles", "main",  30, strategy);
        Equipement armurePrincipale = new Equipement("Armure de fer","Une armure de fer très protectif","corps", 10);
        Equipement casque = new Equipement("Casque à cornes", "Un casque effrayant", "tete",  5);
        Equipement bottes = new Equipement("Bottes de cuir", "Des bottes de cuir", "pieds",  5);

        equiper(startingEquipement);
        equiper(armurePrincipale);
        equiper(casque);
        equiper(bottes);

        StrategyAttaque Legend = new AttaqueMagique("Flammes des Ténèbres");
        Equipement legendary = new Arme("\u001B[33m"+"Grimoire Antique" + "\u001B[0m", "Un grimoire a l'aura menaçante", "main",  30, Legend, "Le grimoire vous envoute, vous obtenez les pouvoirs du sorcier maléfique en plus de votre classe actuelle.");
        inventaire.put(startingEquipement, 1);
        inventaire.put(armurePrincipale, 1);
        inventaire.put(casque, 1);
        inventaire.put(bottes, 1);
        inventaire.put(legendary, 1);
    }
}
