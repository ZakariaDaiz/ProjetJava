package modele.PNJClasses;

public class PNJFuturisteFactory implements PNJFactory {
    
    @Override
    public PNJ creerPNJAleatoire() {
        int random = (int) (Math.random() * 100);

        if (random < 25) {
            return new Alien();
        }
        else if (random < 50) {
            return new DroneCombat();
        }
        else if (random < 75) {
            return new RobotSentinelle();
        }
        else if (random <= 100) {
            return new SoldatCybernetique();
        }
        return null;
    }

    public PNJ creerPNJBoss() {
        return new BossHydreMecha();
    }
}