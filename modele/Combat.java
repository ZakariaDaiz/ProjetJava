package modele;

import modele.AmbientClasses.Salle;
import modele.PNJClasses.PNJ;

import java.util.List;

public class Combat {

    protected Joueur joueur;
    protected List<PNJ> ennemies;
    protected int tour;
    protected Salle salleActuelle;
    
    public Combat(Joueur joueur, List<PNJ> ennemies, Salle salleActuelle) {
        this.joueur = joueur;
        this.ennemies = ennemies;
        this.tour = 1;
        this.salleActuelle = salleActuelle;
    }
    
    
    public String personnageAttaque(Personnage cible) {
        return joueur.attaquer(cible);
    }

    public String personnageSubirDegats(int degats) {
        joueur.subirDegats(degats);
        return " " + degats;
    }

    public boolean estTerminer() {
        return joueur.estMort() || salleActuelle.estNettoye();
    }

}