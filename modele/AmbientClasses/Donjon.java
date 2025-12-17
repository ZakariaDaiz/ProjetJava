package modele.AmbientClasses;

import modele.ObjetClasses.ObjetFactory;
import modele.PNJClasses.PNJ;
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
        this.salleActuelleIndex = 0;
        this.theme = theme;
    }
    
    public Salle getSalleActuelle() {
        return salleActuelle;
    }

    public Salle getNextSalle() {
        return salles.get(salleActuelleIndex++);
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


        for (int i = 0; i < 9; i++) {
            Salle salle = new Salle("Salle numero "+i);

            for(int j = 0; j< (int) (Math.random() * 4); j++){
                PNJ pnj = pnjFactory.creerPNJAleatoire();
                salle.ajouterPNJ(pnj);
                int x = (int) (Math.random() * 4);
                int y = (int) (Math.random() * 4);

                while (salle.terrain[x][y] != '#'){
                    x = (int) (Math.random() * 4);
                    y = (int) (Math.random() * 4);
                }
                salle.terrain[x][y] = pnj.getChar();
            }

            for(int j = 0; j<2; j++){
                salle.ajouterObjet(objetFactory.creerObjetAleatoire());
                int x = (int) (Math.random() * 4);
                int y = (int) (Math.random() * 4);

                while (salle.terrain[x][y] != '#'){
                    x = (int) (Math.random() * 4);
                    y = (int) (Math.random() * 4);
                }
                salle.terrain[x][y] ='O';
            }

            salle.terrain[3][2] = '@';
            salles.add(salle);
        }

        Salle salleBoss = new Salle("Salle Boss");
        salleBoss.ajouterPNJ(pnjFactory.creerPNJBoss());
        salleBoss.terrain[2][2] = 'B';
        salleBoss.terrain[3][2] = '@';
        salles.add(salleBoss);
        
    }
}
