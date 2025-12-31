package modele.CompetencePassive;

import modele.Personnage;

public class EvenementJeu {
    private String type;
    private Personnage source;


    private Personnage declencheur;
    private Personnage cible;
    private int valeur;
    private Object objet;

    public EvenementJeu(String type, Personnage declencheur, Personnage cible, int valeur, Object objet) {
        this.type = type;
        this.declencheur = declencheur;
        this.cible = cible;
        this.valeur = valeur;
        this.objet = objet;
    }


    public String getType() { return type; }
    public Personnage getDeclencheur() { return declencheur; }
    public Personnage getCible() { return cible; }
    public int getValeur() { return valeur; }
    public void setValeur(int v) { this.valeur = v; }
    public Object getObjet() { return objet; }
}
