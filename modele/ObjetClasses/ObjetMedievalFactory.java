package modele.ObjetClasses;

public class ObjetMedievalFactory implements ObjetFactory {

    @Override
    public Objet creerObjetAleatoire() {

        int random = (int) (Math.random() * 19);
        switch(random){
            case 0:
                return new Equipement("epee", "Une epee medieval", "main", "arme", 10);
            case 1:
                return new Equipement("hache", "Une hache medieval", "main", "arme", 15);
            case 2:
                return new Equipement("arc", "Un arc medieval", "main", "arme", 20);
            case 3:
                return new Equipement("baguette", "Une baguette magique", "main", "arme", 10);
            case 4:
                return new Equipement("dagues", "Des dagues acérées", "main", "arme", 10);
            case 5:
                return new Equipement("pieges", "Des pieges à ours", "bras", "arme", 10);
            case 6:
                return new Equipement("dents", "Des dents pointues contaminées par la rage", "main", "arme", 10);
            case 7:
                return new Equipement("serres", "Des serres extrêmement coupantes et pointues", "main", "arme", 10);

            case 8:
                return new Equipement("casque", "Une casque medieval", "tete", "armure", 5);
            case 9:
                return new Equipement("armure", "Une armure medieval", "corps", "armure", 15);
            case 10:
                return new Equipement("bottes", "Une bottes medieval", "pieds", "armure", 10);
            case 11:
                return new Equipement("jambieres", "Une jambiere medieval", "jambes", "armure", 10);
            case 12:
                return new Equipement("bouclier", "Un bouclier en métal", "bras", "armure", 10);


            case 13:
                return new PotionForce("potionForce", "Une potion de force medieval", 10);
            case 14:
                return new PotionDexterite("potionDexterite", "Une potion de dexterite medieval", 10);
            case 15:
                return new PotionSoin("potionSoin", "Une potion de soin medieval", 10);


            case 16:
                return new Aliment("pomme", "Une pomme medieval", 10);
            case 17:
                return new Aliment("steak", "Un steak medieval", 15);
            case 18:
                return new Aliment("poisson", "Un poisson medieval", 20);
        }
        return null;
    }
}