package modele.StrategyAttack;

import modele.Personnage;

import java.util.Random;

public class AttaqueMagique implements StrategyAttaque {

    private final String nomAttaque;

    public AttaqueMagique() {
        this.nomAttaque = "Sort de feu";
    }

    public AttaqueMagique(String nomAttaque) {
        this.nomAttaque = nomAttaque;
    }

    @Override
    public int calculerDegats(Personnage attaquant, Personnage defenseur) {
        int bonus = attaquant.getEquipementPorte().get("Arme").getBonusIntelligence();
        int degatsBruts = attaquant.getIntelligence() + bonus;
        int reduction = defenseur.getConstitution() / 2;

        int degats = degatsBruts - reduction;
        return Math.max(1, degats);
    }

    @Override
    public String getNomAttaque() {
        return nomAttaque;
    }
}
