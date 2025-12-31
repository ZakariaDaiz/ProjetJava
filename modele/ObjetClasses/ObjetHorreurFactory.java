package modele.ObjetClasses;

import modele.StrategyAttack.*;
import modele.CompetencePassive.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ObjetHorreurFactory implements ObjetFactory {
    @Override
    public Objet creerObjetAleatoire() {
        int random = (int) (Math.random() * 20);
        switch (random) {
            case 0:
                return new Arme("Couteau rouillé", "Une lame souillée de sang séché", "main", 10, new AttaquePhysique("Poignarder"));
            case 1:
                return new Arme("Machette ébréchée", "Outil de torture devenu arme", "main", 15, new AttaquePhysique("Entaille"));
            case 2:
                return new Arme("Tronçonneuse", "Rugissement mécanique du chaos", "main", 20, new AttaquePhysique("Massacre"));
            case 3:
                return new Arme("Os aiguisé", "Vestiges maudits d'une victime", "main",  10, new AttaquePhysique("Empaler"));
            case 4:
                return new Arme("Lance-seringue", "Injecte un sérum de terreur", "main",  10, new AttaqueDistante("Injection"));
            case 5:
                return new Arme("Griffe de cadavre", "Ongles arrachés à un corps déformé", "main",  10, new AttaquePhysique("Griffure"));

            case 6:
                return new Equipement("Masque de chair", "Visage arraché d'une âme perdue", "tete",  5);
            case 7:
                return new Equipement("Gilet de peau tannée", "Armure faite de peaux humaines cousues", "corps",  15);
            case 8:
                return new Equipement("Bottes ensanglantées", "Laissent des traces de sang à chaque pas", "pieds", 10);
            case 9:
                return new Equipement("Jambières d'os", "Protections sculptées dans des tibias", "jambes",  10);

            case 10:
                return new PotionForce("Potion de Force", "Liquide noir qui décuple la force");
            case 11:
                return new PotionDexterite("Potion de Dexterite", "Rend les mouvements aussi vifs qu'une araignée");
            case 12:
                return new PotionSoin("Potion de Soin", "Régénère la chair à partir de sang ancien", 10);
            case 13:
                return new PotionResistance("Potion de Resistance", "Immunise temporairement contre la douleur");

            case 14:
                return new Aliment("Pomme pourrie", "Fruit infesté de vers, étrangement nutritif", 10);
            case 15:
                return new Aliment("Viande suspecte", "Morceau de chair à l'origine incertaine", 15);
            case 16:
                return new Aliment("Oeil conservé", "Globe oculaire baignant dans le formol", 20);

            // Armes Legendaries
            case 17:
                return new Arme("\u001B[33m"+"Necronomicon"+"\u001B[0m", "Le livre des morts...", "main", 45, new AttaqueMagique("\u001B[31m"+"Invocation des Ombres"+"\u001B[0m"), "Vous ouvrez le livre... Les ombres dansent autour de vous et murmurent votre nom et vous donne la classe Mage!",new ArrayList<ICompetencePassive>(Arrays.asList(new BouclierMagique())));
            case 18:
                return new Arme("\u001B[33m"+"Machette Maudite"+"\u001B[0m", "Elle a soif de sang...", "main", 55, new AttaquePhysique("\u001B[31m"+"Boucherie"+"\u001B[0m"), "La machette se soude à votre main. Elle pulse comme un coeur vivant et vous donne la classe Barbare!",new ArrayList<ICompetencePassive>(Arrays.asList(new PeauDure(), new ContreAttaque(),new CriDeGuerre())));
            case 19:
                return new Arme("\u001B[33m"+"Appel de Cthulhu"+"\u001B[0m", "Une statuette qui induit la folie", "main", 50, new AttaqueMagique("\u001B[31m"+"Folie Ancienne"+"\u001B[0m"), "Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn... et vous donne la classe Archer!", new ArrayList<ICompetencePassive>(Arrays.asList(new PeauDure(), new Adrenaline())));
            case 20:
                return new Arme("\u001B[33m"+"Dague du Vampire"+"\u001B[0m", "Une dague appartenant à Dracula", "main", 50, new AttaqueFurtive("\u001B[31m"+"SchwanengenSang"+"\u001B[0m"), "La dague reclame votre sang et vous donne la classe Assassin en plus de votre classe actuelle", new ArrayList<ICompetencePassive>(Arrays.asList(new ContreAttaque(),new Adrenaline())));
            }
        return null;
    }
}
