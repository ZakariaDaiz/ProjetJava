package modele.ObjetClasses;

public class PotionForce extends Objet {

    private int force;
    
    public PotionForce(String nom, String description, int force) {
        super(nom, description);
        this.force = force;
    }

    public void utiliser(Personnage cible) {
        cible.setForce(cible.getForce() + force);
    }
}
