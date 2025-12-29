package modele.ThemeClasses;

import modele.ObjetClasses.ObjetFactory;
import modele.ObjetClasses.ObjetHorreurFactory;
import modele.PNJClasses.PNJFactory;
import modele.PNJClasses.PNJHorreurFactory;


public class ThemeHorreurFactory implements ThemeFactory {

    @Override
    public PNJFactory creerPNJFactory() {
        return new PNJHorreurFactory();
    }

    @Override
    public ObjetFactory creerObjetFactory() {
        return new ObjetHorreurFactory();
    }

    @Override
    public String getTheme() {
        return "Horreur";
    }
}