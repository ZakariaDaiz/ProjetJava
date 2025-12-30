package modele.PNJClasses;

import modele.ObjetClasses.Arme;
import modele.ObjetClasses.Equipement;
import modele.StrategyAttack.AttaqueDistante;

import java.util.HashMap;

public class SoldatCybernetique extends PNJ{
    public SoldatCybernetique() {
        super.nom = "SoldatCybernetique";
        super.pv = 110;
        super.pvMax = 110;
        super.force = 12;
        super.dexterite = 27;
        super.constitution = 5;
        super.intelligence = 0;
        super.strategy = new AttaqueDistante("Tirs bioniques");
        super.equipementPorte = new HashMap<>();
        equiper( new Arme("Fusil a plasma", "Une arme a energie", "main",  15, strategy));
        equiper( new Equipement("Visiere tactique", "Casque avec ATH integre", "tete",  5));
        equiper( new Equipement("Bottes gravifiques", "Bottes lourdes stabilisees", "pieds",  5));
        equiper( new Equipement("Exo-jambieres", "Renforcement mecanique des jambes", "jambes",  5));
        equiper(new Equipement("Plastron en nanocarbone", "Armure legere et resistante", "corps",  10));
    }

    public char getChar(){
        return 'C';
    }
}
