package modele.CompetencePassive;

import modele.Personnage;

public class BouclierMagique implements ICompetencePassive {
    private boolean utiliseCeCombat = false;
    private boolean effetActif = false;

    @Override
    public void reagir(Personnage perso, EvenementJeu event) {
        if (event.getType().equals(TypeEvenement.DEBUT_COMBAT)) {
            utiliseCeCombat = false;
            effetActif = false;
        } else if (event.getType().equals(TypeEvenement.DEBUT_TOUR)) {
            if (effetActif) {
                effetActif = false;
                System.out.println("Le Bouclier Magique de " + perso.getNom() + " se dissipe.");
            }
        } else if (event.getType().equals(TypeEvenement.ATTAQUE_SUBIE)) {
            if (effetActif) {
                event.setValeur(0);
                System.out.println(perso.getNom() + " est protégé par Bouclier Magique ! (0 dégâts)");
            } else if (!utiliseCeCombat) {
                utiliseCeCombat = true;
                effetActif = true;
                event.setValeur(0);
                System.out.println(perso.getNom() + " active Bouclier Magique ! Les dégâts sont annulés pour ce tour.");
            }
        }
    }

    @Override
    public String getNom() {
        return "Bouclier Magique";
    }

    @Override
    public String getDescription() {
        return "Annule les dégâts pendant 1 tour (1er coup subi déclenche). 1 fois par combat.";
    }
}
