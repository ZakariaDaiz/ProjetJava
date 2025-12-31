package modele.ObjetClasses;

import modele.StrategyAttack.StrategyAttaque;
import modele.CompetencePassive.ICompetencePassive;
import java.util.List;
import java.util.ArrayList;

public class Arme extends Equipement{

    private final StrategyAttaque strategyAttaque;
    private final boolean legendary;
    private String pickupMessage="";
    private List<ICompetencePassive> competences;   

    public Arme(String nom, String description, String typeSlot, int stat, StrategyAttaque strategyAttaque) {
            super(nom, description, typeSlot, stat);
            this.strategyAttaque = strategyAttaque;
            this.legendary = false;
            this.competences = new ArrayList<>();
    }

    public Arme(String nom, String description, String typeSlot, int stat, StrategyAttaque strategyAttaque, String pickupMessage, List<ICompetencePassive> competences) {
        super(nom, description, typeSlot, stat);
        this.strategyAttaque = strategyAttaque;
        this.legendary = true;
        this.pickupMessage = pickupMessage;
        this.competences = competences;
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

    public List<ICompetencePassive> getCompetences() {
        return competences;
    }
}
