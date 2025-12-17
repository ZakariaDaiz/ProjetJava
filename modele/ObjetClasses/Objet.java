package modele.ObjetClasses;

import modele.Personnage;

public abstract class Objet {
    private String nom;
    private String description;

    public Objet(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
    public void utiliser(Personnage cible){

    }
}
