package modele;

public abstract class Personnage {
    protected String nom;
    protected int pv;
    protected int pvMax;
    protected int force;
    protected int dexterite;
    protected int constitution;
    protected int intelligence;
    protected StrategieAttaque strategie;

    public abstract void attaquer(Personnage cible);
    public abstract void subirDegats(int degats);
    public abstract void seDefendre();
    public abstract boolean estMort();
    public abstract String getNom();

}
