package modele.ObjetClasses;

public class ObjetMedievalFactory implements ObjectFactory {

    @Override
    public Objet createObject(String type) {
       
        switch (type) {
            case "epee":
                return new Equipement("epee", "main", "arme", 10);
            case "hache":
                return new Equipement("hache", "main", "arme", 15);
            case "arc":
                return new Equipement("arc", "main", "arme", 20);
            case "baguette":
                return new Equipement("baguette", "main", "arme", 10);

            
            case "casque":
                return new Equipement("casque", "tete", "armure", 5);
            case "armure":
                return new Equipement("armure", "corps", "armure", 15);
            case "bottes":
                return new Equipement("bottes", "pieds", "armure", 10);
            case "guetres":
                return new Equipement("guetres", "bras", "armure", 10);

            case "potion":
                return new Potion();
            case "potionForce":
                return new PotionForce();
            case "potionDextere":
                return new PotionDextere();
            case "potionSoin":
                return new PotionSoin();

            case "pomme":
                return new Aliment();
            case "steak":
                return new Aliment();
            case "poisson":
                return new Aliment();
            default:
                throw new IllegalArgumentException("Type d'objet invalide: " + type);
        }
    }
}
