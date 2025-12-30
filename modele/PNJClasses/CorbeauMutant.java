package modele.PNJClasses;

import modele.ObjetClasses.Arme;
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
            equiper( new Arme("Bec acéré", "Un bec piquant commant une lance", "main",  10, strategy));
        }

        public char getChar(){
            return 'C';
        }
}
