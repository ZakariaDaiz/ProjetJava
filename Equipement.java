package modele;

public abstract class Equipement extends Objet {

    protected String typeSlot;   // ex : "arme", "casque", "armure"
    protected int bonusForce;
    protected int bonusIntelligence;

    public Equipement(String nom, String description, String typeSlot,
                      int bonusForce, int bonusDexterite) {
        super(nom, description);
        this.typeSlot = typeSlot;
        this.bonusForce = bonusForce;
        this.bonusIntelligence = bonusDexterite;
    }

    @Override
    public void utiliser(Personnage cible) {
        if (cible instanceof Joueur joueur) {
            equiper(joueur);
        }
    }

    public void equiper(Joueur joueur) {
        joueur.force += bonusForce;
        joueur.dexterite += bonusIntelligence;
    }

    public String getTypeSlot() {
        return typeSlot;
    }

    public int getBonusForce() {
        return bonusForce;
    }

    public int getBonusIntelligence() {
        return bonusIntelligence;
    }
}
