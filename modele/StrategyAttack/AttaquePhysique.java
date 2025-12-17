package modele.StrategyAttack;

import modele.Personnage;

import java.util.Random;

public class AttaquePhysique implements StrategyAttaque {

    private final String nomAttaque;

    public AttaquePhysique() {
        this.nomAttaque = "Attaque au corps à corps";
    }

    public AttaquePhysique(String nomAttaque) {
        this.nomAttaque = nomAttaque;
    }

    @Override
    public int calculerDegats(Personnage attaquant, Personnage defenseur) {
        int bonus = attaquant.getEquipementPorte().get("main").getBonus();
        int degatsBruts = attaquant.getForce() + bonus;
        int reduction = defenseur.getConstitution() / 2;

        int degats = degatsBruts - reduction;
        return Math.max(1, degats);
    }

    @Override
    public String getNomAttaque() {
        return nomAttaque;
    }
}
