package modele.StrategyAttack;

import modele.Personnage;

import java.util.Random;

public class AttaqueFurtive implements StrategyAttaque {

    private final String nomAttaque;

    public AttaqueFurtive() {
        this.nomAttaque = "attaque furtive";
    }

    public AttaqueFurtive(String nomAttaque) {
        this.nomAttaque = nomAttaque;
    }


    @Override
    public int calculerDegats(Personnage attaquant, Personnage defenseur) {
        int bonus = attaquant.getEquipementPorte().get("main").getBonus();
        int degatsBruts = attaquant.getForce() + bonus;
        int reduction = defenseur.seDefendre();

        int degats = degatsBruts - reduction;
        return Math.max(1, degats);
    }

    @Override
    public String getNomAttaque() {
        return nomAttaque;
    }
}
