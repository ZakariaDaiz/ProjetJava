package modele;

import java.util.*;

import modele.ObjetClasses.Equipement;
import modele.ObjetClasses.Objet;
import modele.StrategyAttack.StrategyAttaque;

public class Joueur extends Personnage {

    private Map<Objet, Integer> inventaire;

    public Joueur(String nom, int pvMax, int force, int dexterite,
                  int constitution, int intelligence, StrategyAttaque strategy) {
        super(nom, pvMax, force, dexterite, constitution, intelligence, strategy);
        this.inventaire = new HashMap<>();
    }

    public void prendreObjet(Objet obj) {
        inventaire.put(obj, inventaire.getOrDefault(obj, 0) + 1);
    }

    public void utiliserObjet(Objet obj) {
        if (inventaire.containsKey(obj)) {
            obj.utiliser(this);
            int quantite = inventaire.get(obj) - 1;
            if (quantite <= 0) {
                inventaire.remove(obj);
            } else {
                inventaire.put(obj, quantite);
            }
        }
    }

    public int seDefendre() {
        return (constitution + dexterite) /4;
    }

    public void equiper(Equipement eq) {
        equipementPorte.put(eq.getTypeSlot(), eq);
        eq.equiper(this);
    }

    public Map<Objet, Integer> getInventaire() {
        return inventaire;
    }
}
