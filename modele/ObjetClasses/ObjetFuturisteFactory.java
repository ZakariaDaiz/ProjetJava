package modele.ObjetClasses;

public class ObjetFuturisteFactory implements ObjectFactory {
    @Override
    public Objet createObject(String type) {
        switch (type) {
            case "epee laser":
                return new Equipement("epee laser", "Une epee laser", "main", "arme", 10);
            case "massue":
                return new Equipement("massue", "Une massue futuriste", "main", "arme", 15);
            case "pistolaser":
                return new Equipement("pistolaser", "Pistolaser futuriste", "main", "arme", 20);
            case "baguette":
                return new Equipement("baguette", "Une baguette futuriste", "main", "arme", 10);
            case "lance-missile":
                return new Equipement("lance-missile", "Un lance missile dernier cri", "main", "arme", 10);
            case "arme a energie":
                return new Equipement("arme a energie", "Une arme a energie surpuissante", "main", "arme", 10);


            case "casque":
                return new Equipement("casque signature thermique", "Un casque equipé d'une vison thermique", "tete", "armure", 5);
            case "armure":
                return new Equipement("exosquelette", "Une armure ultra-resistante", "corps", "armure", 15);
            case "bottes":
                return new Equipement("bottes à reaction", "Des bottes futuriste permettant de voler bas", "pieds", "armure", 10);
            case "jambieres":
                return new Equipement("jambieres", "Des jambieres futuriste", "jambes", "armure", 10);

            case "potionForce":
                return new PotionForce("potionForce", "Une potion de force futuriste", 10);
            case "potionDextere":
                return new PotionDexterite("potionDexterite", "Une potion de dexterite futuriste", 10);
            case "potionSoin":
                return new PotionSoin("potionSoin", "Une potion de soin futuriste", 10);

            case "pomme":
                return new Aliment("pomme", "Une pomme futuriste", 10);
            case "steak":
                return new Aliment("steak", "Un steak futuriste", 15);
            case "poisson":
                return new Aliment("poisson", "Un poisson futuriste", 20);
            default:
                throw new IllegalArgumentException("Type d'objet invalide: " + type);
        }
    }
}

