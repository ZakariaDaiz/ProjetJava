package modele.ObjetClasses;

import modele.StrategyAttack.*;
import modele.CompetencePassive.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ObjetMedievalFactory implements ObjetFactory {

    @Override
    public Objet creerObjetAleatoire() {

        int random = (int) (Math.random() * 21);
        switch(random){
            case 0:
                return new Arme("Epée", "Une épée medievale", "main",  10, new AttaquePhysique("Coup d'épée"));
            case 1:
                return new Arme("Hache", "Une hache medieval", "main",  15, new AttaquePhysique("Coup de hache"));
            case 2:
                return new Arme("Arc", "Un arc medieval", "main",  20, new AttaqueDistante("Tir de flèche"));
            case 3:
                return new Arme("Baguette", "Une baguette magique", "main",  10, new AttaqueMagique("Sortilège"));
            case 4:
                return new Arme("Dagues", "Des dagues acérées", "main",  10, new AttaqueFurtive("Attaque sournoise"));
            case 5:
                return new Arme("Pieges", "Des pieges à ours", "bras",  10, new AttaqueFurtive("Piège"));

            case 6:
                return new Equipement("Casque", "Une casque medieval", "tete",  5);
            case 7:
                return new Equipement("Armure", "Une armure medievale", "corps",  15);
            case 8:
                return new Equipement("Bottes", "Des bottes medievales", "pieds",  10);
            case 9:
                return new Equipement("Jambieres", "Des jambieres medievales", "jambes", 10);
            case 10:
                return new Equipement("Bouclier", "Un bouclier en métal", "bras",  10);


            case 11:
                return new PotionForce("Potion de force", "Augmente la force de +5 pour 3 tours");
            case 12:
                return new PotionResistance("Potion de Résistance", "Réduit les dégâts subis de 20% pour 2 tours");
            case 13:
                return new PotionDexterite("Potion de dextérité", "Une potion de dexterite medievale");
            case 14:
                return new PotionSoin("Potion de soin", "Une potion de soin medievale", 10);


            case 15:
                return new Aliment("Pomme", "Une pomme", 10);
            case 16:
                return new Aliment("Steak", "Un steak", 15);
            case 17:
                return new Aliment("Poisson", "Un poisson", 20);

            // Armes Legendaries
            case 18:
                return new Arme("\u001B[33m"+"Excalibur"+"\u001B[0m", "L'épée légendaire du Roi Arthur", "main", 50, new AttaquePhysique("\u001B[31m"+"Lumière Sacrée"+"\u001B[0m"), "Vous retirez l'épée du rocher... Une aura royale vous entoure et vous donne la classe Barbare!",new ArrayList<ICompetencePassive>(Arrays.asList(new PeauDure(), new ContreAttaque(),new CriDeGuerre())));
            case 19:
                return new Arme("\u001B[33m"+"Arc du Dragon"+"\u001B[0m", "Un arc forgé dans une écaille de dragon", "main", 45, new AttaqueDistante("\u001B[31m"+"Flèche de Feu"+"\u001B[0m"), "L'arc vibre de chaleur... Vous sentez la puissance du dragon et vous donne la classe Archer!", new ArrayList<ICompetencePassive>(Arrays.asList(new PeauDure(), new Adrenaline())));
            case 20:
                return new Arme("\u001B[33m"+"Bague de Sauron"+"\u001B[0m", "La bague de Sauron", "main", 40, new AttaqueMagique("\u001B[31m"+"Foudre Arcanique"+"\u001B[0m"), "Les runes du bâton s'illuminent... La magie coule en vous et vous donne la classe Mage!", new ArrayList<ICompetencePassive>(Arrays.asList(new BouclierMagique())));
            case 21:
                return new Arme("\u001B[33m"+"Dagues de l'ordre Ancien"+"\u001B[0m", "Dagues forgées dans des os d'hommes", "main", 50, new AttaqueFurtive("\u001B[31m"+"Frappe Véritable"+"\u001B[0m"), "Les dagues s'illuminent... Vous sentez la puissance de l'ordre ancien et vous donne la classe Assassin en plus de votre classe actuelle", new ArrayList<ICompetencePassive>(Arrays.asList(new ContreAttaque(),new Adrenaline())));
            }
        return null;
    }
}