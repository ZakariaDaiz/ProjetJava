package modele.AmbientClasses;

import modele.ObjetClasses.Objet;
import modele.PNJClasses.PNJ;

import java.util.ArrayList;
import java.util.List;

public class Salle {
 
    protected List<PNJ> ennemies;
    protected List<Objet> objetsAuSol;
    protected String description;

    public Salle(String description) {
        this.description = description;
        this.ennemies = new ArrayList<>();
        this.objetsAuSol = new ArrayList<>();
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

    public String getDescription() {
        return description;
    }

    public boolean estNettoye() {
        return ennemies.isEmpty();
    }
}
