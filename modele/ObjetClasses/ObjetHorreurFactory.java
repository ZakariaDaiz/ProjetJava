package modele.ObjetClasses;

public class ObjetHorreurFactory implements ObjetFactory {
    @Override
    public Objet creerObjetAleatoire() {
        int random = (int) (Math.random() * 17);
        switch (random) {
            case 0:
                return new Equipement("Couteau rouillé", "Une lame souillée de sang séché", "main", 10);
            case 1:
                return new Equipement("Machette ébréchée", "Outil de torture devenu arme", "main", 15);
            case 2:
                return new Equipement("Tronçonneuse", "Rugissement mécanique du chaos", "main", 20);
            case 3:
                return new Equipement("Os aiguisé", "Vestiges maudits d'une victime", "main",  10);
            case 4:
                return new Equipement("Lance-seringue", "Injecte un sérum de terreur", "main",  10);
            case 5:
                return new Equipement("Griffe de cadavre", "Ongles arrachés à un corps déformé", "main",  10);

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
        }
        return null;
    }
}
