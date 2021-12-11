import java.util.Arrays;

public class CalculTest {
    public static void main(String[] args) {

        // Conversion d'une array à un string
        String arbre = Arrays.toString(args);

        // Création d'un nouveau objet
        Calcul calcul = new Calcul();

        // Creation de l'arbre POSTIXE
        calcul.creerArbre(arbre);

        // Checkez avec l'utilisateur si c'est bien l'expression qu'il cherchait au
        // début
        System.out.print("Votre resultat sous forme infixe est-il le bon ? : ");
        calcul.infixe();

        // Resultat du calcul
        System.out.println("\n\nResultat de l'expression postfixe : " + calcul.evalueArbre());

        // Suppression de l'arbre pour libérer la mémoire
        calcul.clear();

    }
}