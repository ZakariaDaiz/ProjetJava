package modele.CompetencePassive;

import modele.Personnage;

public class Regeneration implements ICompetencePassive {
    private boolean premierTour = true;

    @Override
    public void reagir(Personnage perso, EvenementJeu event) {
        if (event.getType().equals(TypeEvenement.DEBUT_COMBAT)) {
             premierTour = true;
        }
        else if (event.getType().equals(TypeEvenement.DEBUT_TOUR)) {
            if (premierTour) {
                premierTour = false;
                return;
            }

            int soin = (int) (perso.getPvMax() * ((float)(Math.random() * 0.03)+0.02));
            
            int oldPv = perso.getPv();
            if(oldPv+soin > perso.getPvMax()){
                perso.setPv(perso.getPvMax());
                System.out.println(perso.getNom() + " récupère " + (perso.getPvMax()-oldPv) + " PV grâce à Régénération.");
            }else{
                perso.setPv(oldPv+soin);
                System.out.println(perso.getNom() + " récupère " + (soin) + " PV grâce à Régénération.");
            }

        }
    }

    @Override
    public String getNom() {
        return "Régénération";
    }

    @Override
    public String getDescription() {
        return "Restaure 5% des PV max au début du tour.";
    }
}
