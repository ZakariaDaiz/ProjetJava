package modele;

public abstract class Objet {

    protected String nom;
    protected String description;

    public Objet(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public abstract void utiliser(Personnage cible);

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return nom;
    }
}
