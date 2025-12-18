package modele.ObjetClasses;

public class ObjetMedievalFactory implements ObjetFactory {

    @Override
    public Objet creerObjetAleatoire() {

        int random = (int) (Math.random() * 18);
        switch(random){
            case 0:
                return new Equipement("Epée", "Une épée medievale", "main", "arme", 10);
            case 1:
                return new Equipement("Hache", "Une hache medieval", "main", "arme", 15);
            case 2:
                return new Equipement("Arc", "Un arc medieval", "main", "arme", 20);
            case 3:
                return new Equipement("Baguette", "Une baguette magique", "main", "arme", 10);
            case 4:
                return new Equipement("Dagues", "Des dagues acérées", "main", "arme", 10);
            case 5:
                return new Equipement("Pieges", "Des pieges à ours", "bras", "arme", 10);

            case 6:
                return new Equipement("Casque", "Une casque medieval", "tete", "armure", 5);
            case 7:
                return new Equipement("Armure", "Une armure medievale", "corps", "armure", 15);
            case 8:
                return new Equipement("Bottes", "Des bottes medievales", "pieds", "armure", 10);
            case 9:
                return new Equipement("Jambieres", "Des jambieres medievales", "jambes", "armure", 10);
            case 10:
                return new Equipement("Bouclier", "Un bouclier en métal", "bras", "armure", 10);


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
        }
        return null;
    }
}