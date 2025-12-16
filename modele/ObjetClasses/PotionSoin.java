package modele.ObjetClasses;

import modele.Personnage;

public class PotionSoin extends Objet {
    
    private int soin;
    
    public PotionSoin(String nom, String description, int soin) {
        super(nom, description);
        this.soin = soin;
    }

    public void utiliser(Personnage cible) {
        if( cible.getPv()+soin < cible.getPvMax()) {
            cible.setPv(cible.getPv() + soin);
        }
    }
}
