package modele;

import modele.ObjetClasses.Arme;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.StrategyAttaque;
import modele.CompetencePassive.EvenementJeu;
import modele.CompetencePassive.ICompetencePassive;
import modele.CompetencePassive.TypeEvenement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    protected StrategyAttaque startingStrategy;
    protected Map<String, Equipement> equipementPorte;
    protected Arme arme;
    protected int toursForce = 0;
    protected int toursResistance = 0;
    protected int toursDexterite = 0;

    protected List<ICompetencePassive> competences = new ArrayList<>();


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
        this.startingStrategy = strategy;
        this.equipementPorte = new HashMap<>();
    }

    public char getChar(){
        return '@';
    }

    public void equiper(Equipement eq) {
        // Mettre l'objet dans le slot
        if(!Objects.equals(eq.getTypeSlot(), "main")) {
            if(!equipementPorte.containsKey(eq.getTypeSlot())) {
                equipementPorte.put(eq.getTypeSlot(), eq);
                constitution+=eq.getBonus();
            }
            else {
                constitution-=equipementPorte.get(eq.getTypeSlot()).getBonus();
                equipementPorte.put(eq.getTypeSlot(), eq);
                constitution+=eq.getBonus();
            }
        }
        // On gere les armes, mais aussi les Passives des armes legendaries
        else {
            
            // On enleve les passives de l'ancienne arme
            if(this.arme != null && this.arme.getCompetences() != null) {
                competences.removeAll(this.arme.getCompetences());
            }
            equipementPorte.put(eq.getTypeSlot(), eq);
            arme = (Arme) eq;
            strategy = ((Arme) eq).getStrategyAttaque();

            // On ajoute les passives de la nouvelle arme
            if (arme.getCompetences() != null) {
                this.competences.addAll(arme.getCompetences());
            }
        }
    }

    public void ajouterCompetence(ICompetencePassive competence) {
        this.competences.add(competence);
    }

    public void notifierCompetences(EvenementJeu event) {
        for (ICompetencePassive competence : competences) {
            competence.reagir(this, event);
        }
    }

    public String attaquer(Personnage cible) {
        int degats = strategy.calculerDegats(this, cible);
        
        EvenementJeu event = new EvenementJeu(TypeEvenement.ATTAQUE_EFFECTUEE, this, cible, degats, null);
        notifierCompetences(event);

        int degatsFinaux = event.getValeur();
        
        cible.subirDegats(degatsFinaux, this);
        
        return nom + " utilise " + strategy.getNomAttaque()
                + " et inflige " + degatsFinaux + " dégâts à " + cible.getNom();
    }

    public String attaquerStartingStrategy(Personnage cible) {
        int degats = startingStrategy.calculerDegats(this, cible);
        
        EvenementJeu event = new EvenementJeu(TypeEvenement.ATTAQUE_EFFECTUEE, this, cible, degats, null);
        notifierCompetences(event);

        int degatsFinaux = event.getValeur();

        cible.subirDegats(degatsFinaux, this);
        return nom + " utilise " + startingStrategy.getNomAttaque()
                + " et inflige " + degatsFinaux + " dégâts à " + cible.getNom();
    }


    public void subirDegats(int degats) {
        subirDegats(degats, null);
    }
    
    public void subirDegats(int degats, Personnage attaquant) {
        EvenementJeu event = new EvenementJeu(TypeEvenement.ATTAQUE_SUBIE, attaquant, this, degats, null);
        notifierCompetences(event);
        
        int degatsApresPassif = event.getValeur();
        if (toursResistance > 0) {
            degatsApresPassif = (int) (degatsApresPassif * 0.8); 
        }

        pv -= degatsApresPassif;
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


    public Arme getArme() {
        return arme;
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
        
        if (!competences.isEmpty()) {
             effets += " | Passifs: ";
             for (ICompetencePassive c : competences) {
                 effets += c.getNom() + " ";
             }
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
    
    public void setConstitution(int i) {
        this.constitution = i;
    }

    public int getToursBoostForce() {
        return toursForce;
    }

    public StrategyAttaque getStartingStrategy() {
        return startingStrategy;
    }

    public StrategyAttaque getStrategy() {
        return strategy;
    }

    public int getToursResistance() {
        return toursResistance;
    }

    public int getToursDexterite() {
        return toursDexterite;
    }
}
