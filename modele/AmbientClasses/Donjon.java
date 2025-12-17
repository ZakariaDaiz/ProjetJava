package modele.AmbientClasses;

import modele.ObjetClasses.ObjetFactory;
import modele.PNJClasses.PNJFactory;
import modele.ThemeClasses.ThemeFactory;

import java.util.List;

public class Donjon {

    protected List<Salle> salles;
    protected Salle salleActuelle; 
    protected int salleActuelleIndex;
    protected ThemeFactory theme;
    
    public Donjon(List<Salle> salles, ThemeFactory theme) {
        this.salles = salles;
        this.salleActuelle = salles.get(0);
        this.salleActuelleIndex = 0;
        this.theme = theme;
    }
    
    public Salle getSalleActuelle() {
        return salleActuelle;
    }
    
    public void setSalleActuelle(Salle salleActuelle) {
        this.salleActuelle = salleActuelle;
    }
    
    public int getSalleActuelleIndex() {
        return salleActuelleIndex;
    }
    
    public void setSalleActuelleIndex(int salleActuelleIndex) {
        this.salleActuelleIndex = salleActuelleIndex;
    }
    
    public void genererDonjon(ThemeFactory theme) {

        PNJFactory pnjFactory = theme.creerPNJFactory();
        ObjetFactory objetFactory = theme.creerObjetFactory();

        for (int i = 0; i < 5; i++) {
            Salle salle = new Salle("Salle numero "+i);
            for(int j = 0; j<4; j++){
                salle.ajouterPNJ(pnjFactory.creerPNJAleatoire());
            }
            for(int j = 0; j<4; j++){
                salle.ajouterObjet(objetFactory.creerObjetAleatoire());
            }
            salles.add(salle);
        }

        Salle salleBoss = new Salle("Salle Boss");
        salleBoss.ajouterPNJ(pnjFactory.creerPNJBoss());
        salles.add(salleBoss);
        
    }
}
