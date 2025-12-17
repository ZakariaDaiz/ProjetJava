package modele.ThemeClasses;

import modele.ObjetClasses.ObjetFactory;
import modele.ObjetClasses.ObjetFuturisteFactory;
import modele.PNJClasses.PNJFactory;
import modele.PNJClasses.PNJFuturisteFactory;

public class ThemeFuturisteFactory implements ThemeFactory {
    
    @Override
    public PNJFactory creerPNJFactory() {
        return new PNJFuturisteFactory();
    }

    @Override
    public ObjetFactory creerObjetFactory() {
        return new ObjetFuturisteFactory();
    }

    @Override
    public String getTheme() {
        return "Futuriste";
    }
}