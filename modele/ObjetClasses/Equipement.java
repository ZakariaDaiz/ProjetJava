package modele.ObjetClasses;

public class Equipement extends Objet {
    private String typeSlot;
    private String typeEquipement;
    private int stat;

    public Equipement(String nom, String description, String typeSlot, String typeEquipement, int stat) {
        super(nom, description);
        this.typeSlot = typeSlot;
        this.typeEquipement = typeEquipement;
        this.stat = stat;
    }

    public int getStat() {
        return stat;
    }

    public void utiliser(Personnage cible) {
    
        System.out.println("Tu peux pas utiliser un equipement, tu dois l'equiper!");
    }
}
