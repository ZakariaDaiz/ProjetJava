package modele.ObjetClasses;

public class ObjetFuturisteFactory implements ObjetFactory {
    @Override
    public Objet creerObjetAleatoire() {
        int random = (int) (Math.random() * 15);
        switch (random) {
            case 0:
                return new Equipement("epee laser", "Une epee laser", "main", "arme", 10);
            case 1:
                return new Equipement("massue", "Une massue futuriste", "main", "arme", 15);
            case 2:
                return new Equipement("pistolaser", "Pistolaser futuriste", "main", "arme", 20);
            case 3:
                return new Equipement("baguette", "Une baguette futuriste", "main", "arme", 10);
            case 4:
                return new Equipement("lance-missile", "Un lance missile dernier cri", "main", "arme", 10);
            case 5:
                return new Equipement("arme a energie", "Une arme a energie surpuissante", "main", "arme", 10);

            case 6:
                return new Equipement("casque signature thermique", "Un casque equipé d'une vison thermique", "tete", "armure", 5);
            case 7:
                return new Equipement("exosquelette", "Une armure ultra-resistante", "corps", "armure", 15);
            case 8:
                return new Equipement("bottes à reaction", "Des bottes futuriste permettant de voler bas", "pieds", "armure", 10);
            case 9:
                return new Equipement("jambieres", "Des jambieres futuriste", "jambes", "armure", 10);

            case 10:
                return new PotionForce("potionForce", "Une potion de force futuriste", 10);
            case 11:
                return new PotionDexterite("potionDexterite", "Une potion de dexterite futuriste", 10);
            case 12:
                return new PotionSoin("potionSoin", "Une potion de soin futuriste", 10);

            case 13:
                return new Aliment("pomme", "Une pomme futuriste", 10);
            case 14:
                return new Aliment("steak", "Un steak futuriste", 15);
            case 15:
                return new Aliment("poisson", "Un poisson futuriste", 20);
        }
        return null;
    }
}

