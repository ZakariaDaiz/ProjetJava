package modele.ObjetClasses;

import modele.StrategyAttack.*;
import modele.CompetencePassive.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ObjetFuturisteFactory implements ObjetFactory {
    @Override
    public Objet creerObjetAleatoire() {
        int random = (int) (Math.random() * 20);
        switch (random) {
            case 0:
                return new Arme("Epée laser", "Une epee laser", "main", 10, new AttaquePhysique("Fente Laser"));
            case 1:
                return new Arme("Massue", "Une massue futuriste", "main", 15, new AttaquePhysique("Ecrasement"));
            case 2:
                return new Arme("Pistolaser", "Pistolaser futuriste", "main", 20, new AttaqueDistante("Tir Laser"));
            case 3:
                return new Arme("Baguette", "Une baguette futuriste", "main", 10, new AttaqueMagique("Etincelle"));
            case 4:
                return new Arme("Lance-missile", "Un lance missile dernier cri", "main", 10, new AttaqueDistante("Explosion"));
            case 5:
                return new Arme("Arme a energie", "Une arme à energie surpuissante", "main", 10, new AttaqueMagique("Rayon Gamma"));

            case 6:
                return new Equipement("Casque à signature thermique", "Un casque equipé d'une vison thermique", "tete", 5);
            case 7:
                return new Equipement("Exosquelette", "Une armure ultra-resistante", "corps", 15);
            case 8:
                return new Equipement("Bottes à reaction", "Des bottes futuristes permettant de voler bas", "pieds", 10);
            case 9:
                return new Equipement("Jambieres", "Des jambieres futuristes", "jambes", 10);

            case 10:
                return new PotionForce("Potion de force", "Une potion de force futuriste");
            case 11:
                return new PotionDexterite("Potion de dexterite", "Une potion de dexterite futuriste");
            case 12:
                return new PotionSoin("Potion de soin", "Une potion de soin futuriste", 10);
            case 13:
                return new PotionResistance("Potion de resistance", "Une potion de resistance futuriste");

            case 14:
                return new Aliment("Pomme", "Une pomme futuriste", 10);
            case 15:
                return new Aliment("Steak", "Un steak futuriste", 15);
            case 16:
                return new Aliment("Poisson", "Un poisson futuriste", 20);

            // Armes Legendaries
            case 17:
                return new Arme("\u001B[33m"+"Sabre Laser Ancestral"+"\u001B[0m", "Une arme noble pour une ère civilisée", "main", 50, new AttaquePhysique("\u001B[31m"+"Maîtrise de la Force"+"\u001B[0m"), "Vroum... Le sabre s'allume avec un son caractéristique et vous donne la classe Barbare!", new ArrayList<ICompetencePassive>(Arrays.asList(new PeauDure(), new ContreAttaque(),new CriDeGuerre())));
            case 18:
                return new Arme("\u001B[33m"+"BFG 9000"+"\u001B[0m", "L'arme ultime de destruction massive", "main", 60, new AttaqueDistante("\u001B[31m"+"Sphère de Plasma"+"\u001B[0m"), "Une explosion massive capable de détruire tout sur son chemin. Vous obtenez la classe Mage en plus de votre classe actuelle", new ArrayList<ICompetencePassive>(Arrays.asList(new BouclierMagique())));
            case 19:
                return new Arme("\u001B[33m"+"Nanobots"+"\u001B[0m", "Essaim de nanorobots contrôlés par la pensée", "main", 40, new AttaqueMagique("\u001B[31m"+"Nuée Métallique"+"\u001B[0m"), "Les nanobots s'activent et forment un nuage autour de vous. Vous obtenez la classe Archer en plus de votre classe actuelle", new ArrayList<ICompetencePassive>(Arrays.asList(new PeauDure(), new Adrenaline())));
            case 20:
                return new Arme("\u001B[33m"+"XF-14-Stealth"+"\u001B[0m", "Une dague qui permet de se cacher", "main", 40, new AttaqueFurtive("\u001B[31m"+"Pénétration de Vide"+"\u001B[0m"), "La dague s'illumine en vous rendant invisible. Vous obtenez la classe Assassin en plus de votre classe actuelle", new ArrayList<ICompetencePassive>(Arrays.asList(new ContreAttaque(),new Adrenaline())));
        }
        return null;
    }
}
