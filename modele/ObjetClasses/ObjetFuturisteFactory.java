package modele.ObjetClasses;

public class ObjetFuturisteFactory implements ObjectFactory {

    @Override
    public Objet createObject(String type) {
        switch (type) {
            case "arme":
                return new Arme();
            case "armure":
                return new Armure();
            default:
                throw new IllegalArgumentException("Type d'objet invalide: " + type);
        }
    }
}
