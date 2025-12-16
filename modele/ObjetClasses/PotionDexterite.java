package modele.ObjetClasses;

import modele.Personnage;

public class PotionDexterite extends Objet {

    private int dexterite;

    public PotionDexterite(String nom, String description, int dexterite) {
        super(nom, description);
        this.dexterite = dexterite;
    }

    public void utiliser(Personnage cible) {
        cible.setDexterite(cible.getDexterite() + dexterite);
    }
}