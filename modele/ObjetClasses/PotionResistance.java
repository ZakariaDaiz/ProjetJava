package modele.ObjetClasses;

import modele.Personnage;

public class PotionResistance extends Objet {

    public PotionResistance(String nom, String description) {
        super(nom, description);
    }

    @Override
    public void utiliser(Personnage cible) {
        cible.appliquerResistance();
    }
}

