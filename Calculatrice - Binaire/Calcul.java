public class Calcul {

    // Variables locales
    private static TasNoeud racine;

    // Constructeur de la classe Calcul
    public Calcul() {
        racine = null;
    }

    // Methode pour nettoyer l'arbre entre 2 calculs
    public void clear() {
        racine = null;
    }

    // Si l'arbre est vide à sa racine : ajouter un noeud
    // Sinon, mettre la nouvelle donnée à la racine
    private void push(Noeud ptr) {
        if (racine == null)
            racine = new TasNoeud(ptr);
        else {
            TasNoeud nptr = new TasNoeud(ptr);
            nptr.next = racine;
            racine = nptr;
        }
    }

    // Suppression d'un noeud ()
    private Noeud pop() {
        // Je ne peux pas verifier si la racine est vide car vous ne me permettez pas
        // d'utiliser de libraire
        // Donc pas accès aux exceptions ):
        Noeud ptr = racine.noeud;
        racine = racine.next;
        return ptr;
    }

    /// Récuperation de la racine d'un noeud
    private Noeud recuperationRacine() {
        return racine.noeud;
    }

    // Insertions des opérateurs sans utilisation des exceptions ?
    private void insertionOperateur(char valeur) {
        try {
            // On ajoute le chiffre directement à la feuille
            if (chiffreOuPas(valeur)) {
                Noeud nptr = new Noeud(valeur);
                push(nptr);
            } else if (operateurOuPas(valeur)) {
                Noeud nptr = new Noeud(valeur);
                nptr.gauche = pop();
                nptr.droite = pop();
                push(nptr);
            }
        } catch (Exception e) {
            System.out.println("Non, c'est une mauvaise expression");
        }
    }

    // check si c'est un chiffre
    private boolean chiffreOuPas(char ch) {
        return ch >= '0' && ch <= '9';
    }

    // check si c'est un operateur
    private boolean operateurOuPas(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // conversion d'un char à un chiffre (contrairement au parseString)
    private int conversionChar(char ch) {
        return ch - '0';
    }

    //
    public void creerArbre(String expression) {
        for (int i = expression.length() - 1; i >= 0; i--)
            insertionOperateur(expression.charAt(i));
    }

    // checker la racine de mon arbre
    public double evalueArbre() {
        return evalueArbre(recuperationRacine());
    }

    // Différente signature donc pas de problème. Là où toute la magie
    // opère
    public double evalueArbre(Noeud ptr) {

        if (ptr.gauche == null && ptr.droite == null)
            return conversionChar(ptr.donnee);
        else {
            double resultat = 0.0;
            double gauche = evalueArbre(ptr.gauche);
            double droite = evalueArbre(ptr.droite);
            char operator = ptr.donnee;

            switch (operator) {
                case '+':
                    resultat = gauche + droite;
                    break;
                case '-':
                    resultat = gauche - droite;
                    break;
                case '*':
                    resultat = gauche * droite;
                    break;
                case '/':
                    resultat = gauche / droite;
                    break;
                default:
                    resultat = gauche + droite;
                    break;
            }
            return resultat;
        }
    }

    public void infixe() {
        inOrder(recuperationRacine());
    }

    // Dnas l'ordre traversale, du coup de la gauche puis la racine
    // et ensuite la droite.
    private void inOrder(Noeud ptr) {
        if (ptr != null) {
            inOrder(ptr.gauche);
            System.out.print(ptr.donnee);
            inOrder(ptr.droite);
        }
    }
}