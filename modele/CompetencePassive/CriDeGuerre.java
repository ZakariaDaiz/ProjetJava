package modele.CompetencePassive;

import modele.Personnage;

public class CriDeGuerre implements ICompetencePassive {
    private int bonusForce = 0;
    private int bonusConst = 0;

    @Override
    public void reagir(Personnage perso, EvenementJeu event) {
        if (event.getType().equals(TypeEvenement.DEBUT_COMBAT)) {
             int f = perso.getForce();
             int c = perso.getConstitution();
             
             bonusForce = (int)(f * 0.03);
             bonusConst = (int)(c * 0.08);
             
             perso.setForce(f + bonusForce);
             perso.setConstitution(c + bonusConst);
             
             System.out.println(perso.getNom() + " lance un Cri de Guerre ! (Force +" + bonusForce + ", Const +" + bonusConst + ")");
        } 
        else if (event.getType().equals(TypeEvenement.FIN_COMBAT)) {
            if (bonusForce > 0 || bonusConst > 0) {
                 perso.setForce(perso.getForce() - bonusForce);
                 perso.setConstitution(perso.getConstitution() - bonusConst);
                 
                 bonusForce = 0;
                 bonusConst = 0;
                 System.out.println("L'effet du Cri de Guerre se dissipe.");
            }
        }
    }

    @Override
    public String getNom() {
        return "Cri de Guerre";
    }

    @Override
    public String getDescription() {
        return "Augmente Force et Constitution pendant le combat.";
    }
}
