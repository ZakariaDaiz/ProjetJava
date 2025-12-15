package modele.ObjetClasses;

public class ObjetMedievalFactory implements ObjectFactory {

    @Override
    public Objet createObject(String type) {
       
        switch (type) {
            case "epee":
                return new Equipement("epee", "Une epee medieval", "main", "arme", 10);
            case "hache":
                return new Equipement("hache", "Une hache medieval", "main", "arme", 15);
            case "arc":
                return new Equipement("arc", "Un arc medieval", "main", "arme", 20);
            case "baguette":
                return new Equipement("baguette", "Une baguette medieval", "main", "arme", 10);

            
            case "casque":
                return new Equipement("casque", "Une casque medieval", "tete", "armure", 5);
            case "armure":
                return new Equipement("armure", "Une armure medieval", "corps", "armure", 15);
            case "bottes":
                return new Equipement("bottes", "Une bottes medieval", "pieds", "armure", 10);
            case "guetres":
                return new Equipement("guetres", "Une guetres medieval", "bras", "armure", 10);

            case "potion":
                return new Potion("potion", "Une potion medieval", 10);
            case "potionForce":
                return new PotionForce("potionForce", "Une potion de force medieval", 10);
            case "potionDextere":
                return new PotionDextere("potionDextere", "Une potion de dextere medieval", 10);
            case "potionSoin":
                return new PotionSoin("potionSoin", "Une potion de soin medieval", 10);

            case "pomme":
                return new Aliment("pomme", "Une pomme medieval", 10);
            case "steak":
                return new Aliment("steak", "Un steak medieval", 15);
            case "poisson":
                return new Aliment("poisson", "Un poisson medieval", 20);
            default:
                throw new IllegalArgumentException("Type d'objet invalide: " + type);
        }
    }
}
