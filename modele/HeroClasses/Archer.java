package modele.HeroClasses;

import modele.Joueur;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueDistante;

public class Archer extends Joueur {

    public Archer(String nom) {
        super(
                nom,
                100,        // PV
                20,         // Force
                23,         // Dextérité
                12,         // Constitution
                0,          // Intelligence
                new AttaqueDistante() // Tir a l'arc
        );
        Equipement armePrincipale = new Equipement("Arc basique", "Un arc de débutant", "main", 15);
        Equipement armurePrincipale = new Equipement("Cotte de mailles","Une cotte de mailles pas très protectif","corps", 6);
        Equipement bottes = new Equipement("Bottes légères", "Pour courir vite", "pieds",  2);

        equiper(armePrincipale);
        equiper(armurePrincipale);
        equiper(bottes);

        inventaire.put(armePrincipale, 1);
        inventaire.put(armurePrincipale, 1);
        inventaire.put(bottes, 1);
    }
}
