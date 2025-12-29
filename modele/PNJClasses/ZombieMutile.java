package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaquePhysique;
import java.util.HashMap;

public class ZombieMutile extends PNJ{
    public ZombieMutile() {
        super.nom = "Zombie Mutilé";
        super.pv = 120;
        super.pvMax = 120;
        super.force = 15;
        super.dexterite = 8;
        super.constitution = 12;
        super.intelligence = 0;
        super.strategy = new AttaquePhysique("Griffure infectieuse");
        super.equipementPorte = new HashMap<>();
        equiper(new Equipement("Ongles", "Des ongles porteurs du virus zombie", "main",  10));
    }

    public char getChar(){
        return 'Z';
    }
}
