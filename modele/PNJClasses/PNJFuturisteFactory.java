package modele.PNJClasses;

public class PNJFuturisteFactory implements PNJFactory {
    
    @Override
    public PNJ creerPNJAleatoire() {
        int random = (int) (Math.random() * 4);
        switch (random) {
            case 0:
                return new Alien();
            case 1:
                return new DroneCombat();
            case 2:
                return new RobotSentinelle();
            case 3:
                return new SoldatCybernetique();
        }
    }
}