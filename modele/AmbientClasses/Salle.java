package modele.AmbientClasses;

import modele.ObjetClasses.Objet;
import modele.PNJClasses.PNJ;

import java.util.ArrayList;
import java.util.List;

public class Salle {
 
    protected List<PNJ> ennemies;
    protected List<Objet> objetsAuSol;
    protected String description;
    protected char[][] terrain = new char[4][4];

    public Salle(String description) {
        this.description = description;
        this.ennemies = new ArrayList<>();
        this.objetsAuSol = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                terrain[i][j] = '#';
            }
        }
    }

    public void ajouterPNJ(PNJ pnj) {
        ennemies.add(pnj);
    }

    public void ajouterObjet(Objet objet) {
        objetsAuSol.add(objet);
    }

    public List<PNJ> getEnnemies() {
        return ennemies;
    }

    public List<Objet> getObjetsAuSol() {
        return objetsAuSol;
    }

    public char[][] getTerrain() {
        return terrain;
    }

    public String getDescription() {
        return description;
    }

    public boolean estNettoye() {
        return ennemies.isEmpty();
    }


}
