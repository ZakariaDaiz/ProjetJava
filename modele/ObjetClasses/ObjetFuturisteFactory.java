package modele.ObjetClasses;

public class ObjetFuturisteFactory implements ObjectFactory {

    @Override
   switch (type) {
            case "epee":
                return new Equipement("epeeLaser", "Une epee laser", "main", "arme", 10);
            case "hache":
                return new Equipement("hache", "Une hache futuriste", "main", "arme", 15);
            case "arc":
                return new Equipement("arc", "Un arc futuriste", "main", "arme", 20);
            case "baguette":
                return new Equipement("baguette", "Une baguette futuriste", "main", "arme", 10);

            
            case "casque":
                return new Equipement("casque", "Une casque futuriste", "tete", "armure", 5);
            case "armure":
                return new Equipement("armure", "Une armure futuriste", "corps", "armure", 15);
            case "bottes":
                return new Equipement("bottes", "Une bottes futuriste", "pieds", "armure", 10);
            case "guetres":
                return new Equipement("guetres", "Une guetres futuriste", "bras", "armure", 10);

            case "potion":
                return new Potion("potion", "Une potion futuriste", 10);
            case "potionForce":
                return new PotionForce("potionForce", "Une potion de force futuriste", 10);
            case "potionDextere":
                return new PotionDextere("potionDextere", "Une potion de dextere futuriste", 10);
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

