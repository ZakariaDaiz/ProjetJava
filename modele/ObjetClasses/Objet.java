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

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Objet objet = (Objet) obj;
        return nom.equals(objet.nom) && description.equals(objet.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, description);
    }
}
