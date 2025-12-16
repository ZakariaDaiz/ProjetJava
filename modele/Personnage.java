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
    protected int dexterite;
    protected int constitution;
    protected int intelligence;
    protected StrategyAttaque strategy;
    protected Map<String, Equipement> equipementPorte;


    public Personnage() {
        equipementPorte = new HashMap<>();
    }


    public Personnage(String nom, int pvMax, int force, int dexterite,
                      int constitution, int intelligence, StrategyAttaque strategy) {
        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pvMax;
        this.force = force;
        this.dexterite = dexterite;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.strategy = strategy;
        this.equipementPorte = new HashMap<>();
    }

    public String attaquer(Personnage cible) {
        int degats = strategy.calculerDegats(this, cible);
        cible.subirDegats(degats);
        return nom + " utilise " + strategy.getNomAttaque()
                + " et inflige " + degats + " dégâts à " + cible.getNom();
    }



    public void subirDegats(int degats) {
        pv -= degats;
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

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getPvMax() {return pvMax;}

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

    public void setPv(int i) { this.pv=i; }

    public void setDexterite(int i) { this.dexterite=i; }

    public void setForce(int i) {this.force=i;}
}
}

