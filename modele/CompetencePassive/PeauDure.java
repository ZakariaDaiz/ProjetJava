package modele.CompetencePassive;

import modele.Personnage;

public class PeauDure implements ICompetencePassive {
    @Override
    public void reagir(Personnage perso, EvenementJeu event) {
        if (event.getType().equals(TypeEvenement.ATTAQUE_SUBIE)) {
            int degats = event.getValeur();
            int reduction = (int) (degats * 0.15); // 15% reduction

            
            int nouveauxDegats = degats - reduction;
            if (nouveauxDegats < 0) nouveauxDegats = 0;
            
            event.setValeur(nouveauxDegats);
            System.out.println(perso.getNom() + " subit moins de dégâts grâce à Peau Dure ! (Réduction: " + reduction + ")");
        }
    }

    @Override
    public String getNom() {
        return "Peau Dure";
    }

    @Override
    public String getDescription() {
        return "Réduit les dégâts subis de 15%.";
    }
}
