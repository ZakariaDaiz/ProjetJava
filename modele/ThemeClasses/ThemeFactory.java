package modele.ThemeClasses;

import modele.ObjetClasses.ObjetFactory;
import modele.PNJClasses.PNJFactory;

public interface ThemeFactory {

    public PNJFactory creerPNJFactory();
    public ObjetFactory creerObjetFactory();
    public String getTheme();
    
}