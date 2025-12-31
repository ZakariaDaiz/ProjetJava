package modele.CompetencePassive;

import modele.Personnage;

public class Adrenaline implements ICompetencePassive {
    private int bonusActif = 0;
    private int bonusEnAttente = 0;

    @Override
    public void reagir(Personnage perso, EvenementJeu event) {
        if (event.getType().equals(TypeEvenement.DEBUT_TOUR)) {
            // Fin du bonus précédent
            if (bonusActif > 0) {
                perso.setForce(perso.getForce() - bonusActif);
                System.out.println("Fin d'Adrénaline (Force -" + bonusActif + ").");
                bonusActif = 0;
            }

            // Application du nouveau bonus
            if (bonusEnAttente > 0) {
                bonusActif = bonusEnAttente;
                perso.setForce(perso.getForce() + bonusActif);
                System.out.println("Adrénaline active ! (Force +" + bonusActif + " pour ce tour).");
                bonusEnAttente = 0;
            }
        } 
        else if (event.getType().equals(TypeEvenement.ATTAQUE_EFFECTUEE)) {
            // "Augmente la force de 10-20% pour 1 tour."
            int forceActuelle = perso.getForce();
            bonusEnAttente = (int) (forceActuelle * ((float)(Math.random() * 0.10)+0.10));
            System.out.println(perso.getNom() + " sent l'Adrénaline monter pour le prochain tour !");
        }
    }

    @Override
    public String getNom() {
        return "Adrénaline";
    }

    @Override
    public String getDescription() {
        return "Augmente la force de 15% pour le tour suivant après une attaque.";
    }
}
