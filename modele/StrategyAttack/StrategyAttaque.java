package modele.StrategyAttack;

import modele.Personnage;

public interface StrategyAttaque {


    int calculerDegats(Personnage attaquant, Personnage defenseur);

    String getNomAttaque();
}
