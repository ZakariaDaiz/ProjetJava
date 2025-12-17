package modele.PNJClasses;

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
        equipementPorte.put("main", new Equipement("Fusil a plasma", "Une arme a energie", "main", "arme", 15));
        equipementPorte.put("tete", new Equipement("Visiere tactique", "Casque avec ATH integre", "tete", "armure", 5));
        equipementPorte.put("pieds", new Equipement("Bottes gravifiques", "Bottes lourdes stabilisees", "pieds", "armure", 5));
        equipementPorte.put("jambes", new Equipement("Exo-jambieres", "Renforcement mecanique des jambes", "jambes", "armure", 5));
        equipementPorte.put("corps", new Equipement("Plastron en nanocarbone", "Armure legere et resistante", "corps", "armure", 10));
    }

    public char getChar(){
        return 'C';
    }
}
