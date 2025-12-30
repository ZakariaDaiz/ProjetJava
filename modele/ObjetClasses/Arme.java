package modele.ObjetClasses;

import modele.StrategyAttack.StrategyAttaque;

public class Arme extends Equipement{

    private final StrategyAttaque strategyAttaque;
    private final boolean legendary;
    private String pickupMessage="";

    public Arme(String nom, String description, String typeSlot, int stat, StrategyAttaque strategyAttaque) {
            super(nom, description, typeSlot, stat);
            this.strategyAttaque = strategyAttaque;
            this.legendary = false;
    }

    public Arme(String nom, String description, String typeSlot, int stat, StrategyAttaque strategyAttaque, String pickupMessage) {
        super(nom, description, typeSlot, stat);
        this.strategyAttaque = strategyAttaque;
        this.legendary = true;
        this.pickupMessage = pickupMessage;
    }


    public StrategyAttaque getStrategyAttaque() {
        return strategyAttaque;
    }

    public boolean isLegendary() {
        return legendary;
    }

    public String getPickupMessage() {
        return pickupMessage;
    }
}
