package modele.ObjetClasses;

import modele.Personnage;

public class Equipement extends Objet {
    private String typeSlot;
    private int stat;

    public Equipement(String nom, String description, String typeSlot, int stat) {
        super(nom, description);
        this.typeSlot = typeSlot;
        this.stat = stat;
    }

    public int getBonus() {
        return stat;
    }

    public void utiliser(Personnage cible) {
    
        System.out.println("Tu peux pas utiliser un equipement, tu dois l'equiper!");
    }

    public String getTypeSlot() {
        return typeSlot;
    }
}
