package modele.ObjetClasses;

public class PotionDextere extends Objet {

    private int dextere;
    
    public PotionDextere(String nom, String description, int dextere) {
        super(nom, description);
        this.dextere = dextere;
    }

    public void utiliser(Personnage cible) {
        cible.setDexterite(cible.getDexterite() + dextere);
    }
}
