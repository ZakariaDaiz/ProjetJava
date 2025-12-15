package modele;

public class Alien extends PNJ{

    public Alien() {
        super.nom="Alien";
        super.pv=100;
        super.pvMax=100;
        super.force=5;
        super.dexterite=20;
        super.constitution=5;
        super.intelligence=0;

    }

    @Override
    public void attaquer(Personnage cible) {
    }

    @Override
    public void subirDegats(int degats) {
    }

    @Override
    public void seDefendre() {
    }

    @Override
    public boolean estMort() {
        return false;
    }

    @Override
    public String getNom() {
        return "";
    }
}
