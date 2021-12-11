public class Noeud {
    char donnee;
    Noeud gauche, droite;

    // Structure de données d'un noeud
    public Noeud(char donnee) {
        this.donnee = donnee;
        this.gauche = null;
        this.droite = null;
    }
}