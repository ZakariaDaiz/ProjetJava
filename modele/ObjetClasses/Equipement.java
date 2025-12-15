package modele.ObjetClasses;

public class Equipement extends Objet {
    private String nom;
    private String typeSlot;
    private String typeArmure;
    private int stat;

    public Equipement(String nom, String typeSlot, String typeArmure, int stat) {
        this.nom = nom;
        this.typeSlot = typeSlot;
        this.typeArmure = typeArmure;
        this.stat = stat;
    }

    public int getStat() {
        return stat;
    }
}
