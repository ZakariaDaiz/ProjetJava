# Document Design patterns & justifications :

Projet RPG COO - Itération 1

Groupe : TP2

Zakaria Daiz / Vivien Brioul / Corentin Fellouh

Introduction :

Ce document va montrer les designs patterns que nous avons choisi pour implémenter
le prototype de RPG pour l'itération 1, pourquoi nous les avons choisis, ainsi que leur utilité au sein du projet.
Nous avons principalement choisi 3 designs patterns qui nous semblaient important et qui apporte une réelle valeur ajoutée
en terme de lisibilité et de respect du principe ouvert-fermé, sans pour autant aller jusqu'à la sur-ingénierie inutile.

## 1. Factory Method (Pattern Fabrique)

### *Problème initial*

Le jeu requiert la création de plusieurs types de personnages, tous avec des caractéristiques différentes.

- Héros : 4 classes jouables (Barbare, Sorcier, Archer, Assassin)

- PNJ : Plusieurs types d'ennemis dépendant du thème choisi

Chaque type de personnages possède des statistiques uniques (PV, Force, Dextérité, Constitution, Intelligence)
et un comportement d'attaque qui lui est propre. Sans pattern de création, on aurait énormément de conditions et de duplication
de code lors de l'instanciation des personnages.

### *Solution*

Le pattern Fabrique (Factory Method) encapsule la logique de création des personnages dans des classes dédiées, séparant la
responsabilité de création de la logique du jeu.

### *Structure*

Il y aura 2 Factory principales :

- HeroFactory : Crée les personnages jouables par l'utilisateur

- PNJFactory : Crée les ennemis (classe abstraite, spécialisée par thème)

Les dex implémentent l'interfact PersonnageFactory avec la méthode creerPersonnage(String type, String nom).

### *Applications*

- *Création du héros* :

Le joueur choisit sa classe, et la factory se charge de créer le personnage avec toutes ses caractéristiques :

```
HeroFactory factory = new HeroFactory();
Personnage hero = factory.creerPersonnage("barbare", "Grom");
// → Retourne un Barbare avec 150 PV, 20 Force, 10 Dex, 15 Const, 5 Intel
```

- *Création de PNJ* :
La factory de PNJ varie selon le thème et gère les probabilités d'apparition :
```
PNJFactory pnjFactory = theme.creerPNJFactory();
Personnage ennemi = pnjFactory.creerPNJAleatoire();
// → Retourne un PNJ selon les probabilités du thème
```

### *Avantages*

- Centralisation : Toute la logique de création est réunie au même endroit, ce qui évite la duplication de code
- Lisibilité : Le code du contrôleur reste propre, sans détails de création.
- Extensibilité : si l'on souhaite rajouter une classe, cela se fait facilement en modifiant la Factory.

## 2. Abstract Factory (Fabrique Abstraite)

### *Problème initial*

Le jeu doit proposer deux thèmes distincts (Médieval et Futuriste) qui va influencer plusieurs éléments :

- Les types d'ennemis rencontrés (Chevalier ou robot par exemple)
- les objets qu'il sera possible de trouver (potion de force ou seringue d'adrénaline par exemple)
- le boss final (Dragon ou Mecha par exemple)

Sans pattern, le code serait très vite envahi de conditionnelle à la ```if (theme == "medieval")``` partout où
un élément dépendant du thème sera instancié, ce qui va rendre le code difficile à lire, maintenir et/ou étendre.

### *Solution*

Le pattern Abstract Factory permet de créer des familles d'objets cohérentes selon le thème choisi. Il va garantir
que tous les éléments qui compose le jeu appartiennent au même univers sans avoir besoin de faire des vérification
conditionnelles a tout bout de champ.

### *Structure*

L'interface ThemeFactory définit les méthodes de création :

- creerPNJFactory() : Retourne la factory de PNJ appropriée
- creerObjetFactory() : Retourne la factory d'objets appropriée
- creerBossFinal() : Crée le boss correspondant au thème
- getNomTheme() : Retourne le nom du thème

Deux implémentations concrètes :

- ThemeMedievalFactory : Crée des éléments médiévaux
- ThemeFuturisteFactory : Crée des éléments futuristes

### *Applications*

- *Initalisation du Thème* :

Au début du jeu, le joueur va choisir le thème, et toute la création des éléments en découlera automatiquement :

```
ThemeFactory theme;
if (choixJoueur == 1) {
    theme = new ThemeMedievalFactory();
} else {
    theme = new ThemeFuturisteFactory();
}

PNJFactory pnjFactory = theme.creerPNJFactory();
ObjetFactory objetFactory = theme.creerObjetFactory();
```

Ainsi, lors de la génération d'une salle, tous les éléments qu'elle contient seront cohérent avec le thème :

```
// exemple de génération de 1 à 4 ennemis
for (int i = 0; i < nbEnnemis; i++) {
    Personnage ennemi = pnjFactory.creerPNJAleatoire();
    salle.ajouterEnnemi(ennemi);
}

// exemple de génération de 0 à 2 objets
for (int i = 0; i < nbObjets; i++) {
    Objet objet = objetFactory.creerObjetAleatoire();
    salle.ajouterObjet(objet);
}
```

Et le même principe est appliqué pour la création du boss.

### *Avantages*

- Cohérence : on ne se retrouvera pas avec un chevalier errant qui utilise un sabre laser.
- Extensibilité : Ajouter un thème ne nécessite qu'une nouvelle classe factory.
- Isolation : Le code principal ne connaît pas les thèmes spécifiques, seulement l'interface.
- Élimination des conditionnelles a répétition : pas de ```if (theme == ...)``` nécessaire.

## 3. Strategy

### *problème initial*

Chaque classe de personnage va attaquer différemment avec une formule de calcul de dégats qui lui est propre.

Sans patterne stratégie, la méthode ```attaquer()``` contiendrait énormément de conditions basées sur le type du personnage,
ce qui va donner un code difficile à lire, maintenir et étendre.

### *Solution*

Le pattern Strategy encapsule chaque algorithme d'attaque dans sa propre classe indépendante. Chaque personnage possède
une stratégue d'attaque qui peut être utilisée de manière polymorphe.

### *Structure*

Interface principale :

```
interface StrategyAttaque {
    int calculerDegats(Personnage attaquant, Personnage defenseur);
    String getNomAttaque();
}
```

Exemples de quelques stratégies Concrètes :

- AttaqueBarbareStrategy
- AttaqueSorcierStrategy
- AttaqueChevalierStrategy

etc...

### *Intégration*

La classe abstraite Personnage (qui englobe toutes les entités pouvant exister dans le RPG) contient
une référence à sa stratégie d'attaque et délègue le calcul des dégats à celle-ci :

``` 
public abstract class Personnage {
    protected StrategyAttaque strategyAttaque;
    
    public void attaquer(Personnage cible) {
        int degats = strategyAttaque.calculerDegats(this, cible);
        cible.subirDegats(degats);
        
        System.out.println(nom + " utilise " + strategyAttaque.getNomAttaque() 
                         + " et inflige " + degats + " dégâts à " + cible.getNom());
    }
}
```

Et chaque sous-classe définiera sa stratégie Spécifique dans son constructeur, exemple du barbare :

```
public class Barbare extends Personnage {
    public Barbare(String nom) {
        super(nom, 150, 20, 10, 15, 5);
        this.strategyAttaque = new AttaqueBarbareStrategy();
    }
}
```

### *Application*

Lors d'un combat, ce pattern très utile permet que chaque personnage utiliser automatiquement sa stratégie de combat
sans conditions :

```
// Tour du joueur
hero.attaquer(chevalier);

// Tour des ennemis
for (Personnage ennemi : ennemis) {
    ennemi.attaquer(hero);
}
```

### *Avantages*

- Code propre : pas de switch case ou de if basé sur le type de chaque personnage.
- Extensibilité : Ajouter une nouvelle attaque revient a créer une nouvelle classe Strategy.
- Pas de duplication de code : Plusieurs types de PNJ peuvent partager la même stratégie
- Flexibilité : si nécessaire, on peut changer l'attaque d'un personnage dynamiquement (exemple : équipement spécial).


## Conclusion

Ces quelques designs patterns vont grandement améliorer la lisibilité et l'extensibilité du code tout en respectant
le principe Ouvert/Fermé, l'encapsulation, et la distribution des Responsabilités.