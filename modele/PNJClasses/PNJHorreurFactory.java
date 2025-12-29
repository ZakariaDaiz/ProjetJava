package modele.PNJClasses;

public class PNJHorreurFactory implements PNJFactory {
    @Override
    public PNJ creerPNJAleatoire() {
        int random = (int) (Math.random() * 100);

        if (random < 30) {
            return new ZombieMutile();
        } else if (random < 55) {
            return new SorciereVaudou();
        } else if (random < 75) {
            return new CorbeauMutant();
        } else if (random <= 100) {
            return new RatZombie();
        }
        return null;
    }

    public PNJ creerPNJBoss() {
        return new BossZombie();
    }

}

