package modele.CompetencePassive;

import modele.Personnage;

public interface ICompetencePassive {
    void reagir(Personnage perso, EvenementJeu event);
    String getNom();
    String getDescription();
}
