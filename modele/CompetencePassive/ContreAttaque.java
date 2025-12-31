package modele.CompetencePassive;

import modele.Personnage;

public class ContreAttaque implements ICompetencePassive {
    @Override
    public void reagir(Personnage perso, EvenementJeu event) {
        if (event.getType().equals(TypeEvenement.ATTAQUE_SUBIE)) {
            Personnage attaquant = event.getDeclencheur();
            if (attaquant != null && attaquant != perso) {
                int degatsRecus = event.getValeur();
                int degatsRenvoi = (int)(degatsRecus * 0.2);
                System.out.println(perso.getNom() + " riposte avec Contre-Attaque !");
                attaquant.subirDegats(degatsRenvoi);
            }
        }
    }

    @Override
    public String getNom() {
        return "Contre-Attaque";
    }

    @Override
    public String getDescription() {
        return "Renvoie 20% des dégâts subis à l'attaquant.";
    }
}
