package modele.ThemeClasses;

import modele.ObjetClasses.ObjetFactory;
import modele.ObjetClasses.ObjetMedievalFactory;
import modele.PNJClasses.PNJFactory;
import modele.PNJClasses.PNJMedievalFactory;

public class ThemeMedievalFactory implements ThemeFactory {
    
    @Override
    public PNJFactory creerPNJFactory() {
        return new PNJMedievalFactory();
    }

    @Override
    public ObjetFactory creerObjetFactory() {
        return new ObjetMedievalFactory();
    }

    @Override
    public String getTheme() {
        return "Medieval";
    }
}