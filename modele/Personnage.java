package modele;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.StrategyAttaque;

import java.util.HashMap;
import java.util.Map;

public abstract class Personnage {

    protected String nom;
    protected int pv;
    protected int pvMax;
    protected int force;
    protected int forceBase;
    protected int dexterite;
    protected int constitution;
    protected int intelligence;
    protected StrategyAttaque strategy;
    protected Map<String, Equipement> equipementPorte;

    protected int toursForce = 0;
    protected int toursResistance = 0;
    protected int toursDexterite = 0;

    public Personnage() {
        equipementPorte = new HashMap<>();
    }

    public Personnage(String nom, int pvMax, int force, int dexterite,
                      int constitution, int intelligence, StrategyAttaque strategy) {
        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pvMax;
        this.force = force;
        this.forceBase = force;
        this.dexterite = dexterite;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.strategy = strategy;
        this.equipementPorte = new HashMap<>();
    }

    public char getChar(){
        return '@';
    }

    public String attaquer(Personnage cible) {
        int degats = strategy.calculerDegats(this, cible);
        cible.subirDegats(degats);
        return nom + " utilise " + strategy.getNomAttaque()
                + " et inflige " + degats + " dégâts à " + cible.getNom();
    }


    public void subirDegats(int degats) {
        int degatsFinaux = degats;

        // Appliquer la réduction si résistance active
        if (toursResistance > 0) {
            degatsFinaux = (int) (degats * 0.8); 
        }

        pv -= degatsFinaux;
        if (pv < 0) {
            pv = 0;
        }
    }

    public int seDefendre() {
        return constitution/2;
    }

    public boolean estMort() {
        return pv <= 0;
    }

    public void appliquerBoostForce() {
        if (toursForce == 0) {
            force += 5;
        }
        toursForce = 3;
    }


    public void appliquerResistance() {
        if (toursResistance == 0) {
            constitution = (int) (constitution*1.2);
        }
        toursResistance = 2;
    }

    public void appliquerDexterite() {
        if (toursDexterite == 0) {
            dexterite = (int) (dexterite*1.3);
        }
        toursDexterite = 3;
    }

    
    public String mettreAJourEffets() {
        String message = "";

        // Boost de force
        if (toursForce > 0) {
            toursForce--;
            if (toursForce == 0) {
                force -= 5; // Retirer le bonus
                message += "Boost de Force expiré. ";
            }
        }

        // Résistance
        if (toursResistance > 0) {
            toursResistance--;
            if (toursResistance == 0) {
                message += "Résistance expirée. ";
            }
        }

        // Dexterite
        if (toursDexterite > 0) {
            toursDexterite--;
            if (toursDexterite == 0) {
                message += "Dèxterite expirée. ";
            }
        }

        return message;
    }

    
    public String getEffetsActifs() {
        String effets = "";

        if (toursForce > 0) {
            effets += "Boost de Force (" + toursForce + " tour(s)) ";
        }
        if (toursResistance > 0) {
            effets += "Résistance (" + toursResistance + " tour(s)) ";
        }
        if (toursDexterite > 0) {
            effets += "Dèxterotè (" + toursDexterite + " tour(s)) ";
        }

        return effets.isEmpty() ? "Aucun effet actif" : effets;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getPvMax() {
        return pvMax;
    }

    public int getForce() {
        return force;
    }

    public int getDexterite() {
        return dexterite;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public Map<String, Equipement> getEquipementPorte() {
        return equipementPorte;
    }

    public void setPv(int i) {
        this.pv = i;
    }

    public void setDexterite(int i) {
        this.dexterite = i;
    }

    public void setForce(int i) {
        this.force = i;
    }

    public int getToursBoostForce() {
        return toursForce;
    }

    public int getToursResistance() {
        return toursResistance;
    }

    public int getToursDexterite() {
        return toursDexterite;
    }
}
