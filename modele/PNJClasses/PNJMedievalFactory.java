package modele.PNJClasses;

public class PNJMedievalFactory implements PNJFactory {
    
    @Override
    public PNJ creerPNJAleatoire() {
        int random = (int) (Math.random() * 5);
        switch (random) {
            case 0:
                return new Gobelin();
            case 1:
                return new RatEnrage();
            case 2:
                return new Sorciere();
            case 3:
                return new Vautour();
            case 4:
                return new ChevalierErrant();
        }
    }
}