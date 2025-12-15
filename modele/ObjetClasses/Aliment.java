package modele.ObjetClasses;

import modele.Personnage;

public class Aliment extends Objet {

    protected int pvRendu;

    public Aliment(String nom, String description, int pvRendu) {
        super(nom, description);
        this.pvRendu = pvRendu;
    }

    public void utiliser(Personnage cible) {
        if (cible.getPv()+pvRendu <= cible.getPvMax()) {
            cible.setPv(cible.getPv() + pvRendu);
        }
    }
}


