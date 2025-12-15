package modele.StrategyAttack;

public interface StrategyAttaque {

    int calculerDegats(Personnage attaquant, Personnage defenseur);

    String getNomAttaque();
}
