package modele.StrategyAttack;

import java.util.Random;

public class AttaqueDistante implements StrategyAttaque {

    private static final Random random = new Random();

    @Override
    public int calculerDegats(Personnage attaquant, Personnage defenseur) {
        int bonus = attaquant.getEquipementPorte().get("Arme").getBonusForce();
        int degatsBruts = attaquant.getForce() + bonus;
        int reduction = defenseur.getConstitution() / 2;

        int degats = degatsBruts - reduction;
        return Math.max(1, degats);
    }

    @Override
    public String getNomAttaque() {
        return "Tir a l'arc";
    }
}
