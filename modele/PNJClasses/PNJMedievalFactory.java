package modele.PNJClasses;

public class PNJMedievalFactory implements PNJFactory {
    
    @Override
    public PNJ creerPNJAleatoire() {
        int random = (int) (Math.random() * 100);

        if (random < 30) {
            return new ChevalierErrant();
        }
        else if (random < 55) {
            return new Sorciere();
        }
        else if (random < 75) {
            return new Vautour();
        }
        else if (random <= 100) {
            return new RatEnrage();
        }
        return null;
    }

    public PNJ creerPNJBoss() {
        return new BossDragon();
    }
}