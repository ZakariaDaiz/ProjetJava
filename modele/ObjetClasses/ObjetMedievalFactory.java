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
                return new Equipement("baguette", "Une baguette magique", "main", "arme", 10);
            case "dagues":
                return new Equipement("dagues", "Des dagues acérées", "main", "arme", 10);
            case "pieges":
                return new Equipement("pieges", "Des pieges à ours", "bras", "arme", 10);
            case "dents":
                return new Equipement("dents", "Des dents pointues contaminées par la rage", "main", "arme", 10);
            case "serres":
                return new Equipement("serres", "Des serres extrêmement coupantes et pointues", "main", "arme", 10);

            case "casque":
                return new Equipement("casque", "Une casque medieval", "tete", "armure", 5);
            case "armure":
                return new Equipement("armure", "Une armure medieval", "corps", "armure", 15);
            case "bottes":
                return new Equipement("bottes", "Une bottes medieval", "pieds", "armure", 10);
            case "jambieres":
                return new Equipement("jambieres", "Une jambiere medieval", "jambes", "armure", 10);
            case "bouclier":
                return new Equipement("bouclier", "Un bouclier en métal", "bras", "armure", 10);


            case "potionForce":
                return new PotionForce("potionForce", "Une potion de force medieval", 10);
            case "potionDextere":
                return new PotionDexterite("potionDexterite", "Une potion de dexterite medieval", 10);
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
