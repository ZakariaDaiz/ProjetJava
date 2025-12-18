package modele.ObjetClasses;

import modele.Personnage;

public class PotionDexterite extends Objet {


    public PotionDexterite(String nom, String description) {
        super(nom, description);
    }

    public void utiliser(Personnage cible) {
        cible.appliquerDexterite();;
    }
}