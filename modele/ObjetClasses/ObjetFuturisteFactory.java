package modele.ObjetClasses;

public class ObjetFuturisteFactory implements ObjetFactory {
    @Override
    public Objet creerObjetAleatoire() {
        int random = (int) (Math.random() * 15);
        switch (random) {
            case 0:
                return new Equipement("Epée laser", "Une epee laser", "main", "arme", 10);
            case 1:
                return new Equipement("Massue", "Une massue futuriste", "main", "arme", 15);
            case 2:
                return new Equipement("Pistolaser", "Pistolaser futuriste", "main", "arme", 20);
            case 3:
                return new Equipement("Baguette", "Une baguette futuriste", "main", "arme", 10);
            case 4:
                return new Equipement("Lance-missile", "Un lance missile dernier cri", "main", "arme", 10);
            case 5:
                return new Equipement("Arme a energie", "Une arme à energie surpuissante", "main", "arme", 10);

            case 6:
                return new Equipement("Casque à signature thermique", "Un casque equipé d'une vison thermique", "tete", "armure", 5);
            case 7:
                return new Equipement("Exosquelette", "Une armure ultra-resistante", "corps", "armure", 15);
            case 8:
                return new Equipement("Bottes à reaction", "Des bottes futuristes permettant de voler bas", "pieds", "armure", 10);
            case 9:
                return new Equipement("Jambieres", "Des jambieres futuristes", "jambes", "armure", 10);

            case 10:
                return new PotionForce("Potion de force", "Une potion de force futuriste", 10);
            case 11:
                return new PotionDexterite("Potion de dexterite", "Une potion de dexterite futuriste", 10);
            case 12:
                return new PotionSoin("Potion de soin", "Une potion de soin futuriste", 10);

            case 13:
                return new Aliment("Pomme", "Une pomme futuriste", 10);
            case 14:
                return new Aliment("Steak", "Un steak futuriste", 15);
            case 15:
                return new Aliment("Poisson", "Un poisson futuriste", 20);
        }
        return null;
    }
}

