package modele.PNJClasses;

import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaquePhysique;

import java.util.HashMap;

public class CorbeauMutant extends PNJ{
        public CorbeauMutant() {
            super.nom = "Corbeau Mutant";
            super.pv = 120;
            super.pvMax = 120;
            super.force = 15;
            super.dexterite = 8;
            super.constitution = 12;
            super.intelligence = 0;
            super.strategy = new AttaquePhysique("Attaque en piqué");
            super.equipementPorte = new HashMap<>();
            equipementPorte.put("main", new Equipement("Bec acéré", "Un bec piquant commant une lance", "main", "arme", 10));
        }

        public char getChar(){
            return 'C';
        }
}
