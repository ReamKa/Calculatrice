import java.util.Scanner;

public class CalculTest {
    public static void main(String[] args) {

        // Conversion de l'ecriture infixe à prefixe
        System.out.println("Entrez votre calcul INFIXE hihi");
        Scanner scan = new Scanner(System.in);
        String expInfixe = scan.next();
        String expPrefixe = InfixAPrefix.infixAPrefix(expInfixe);

        // // Création d'un nouveau objet
        Calcul calcul = new Calcul();

        // // Creation de l'arbre POSTIXE
        calcul.creerArbre(expPrefixe);

        // // Resultat du calcul
        System.out.println("\n\nResultat de l'expression : " +
                calcul.evalueArbre());

        System.out.println("Comment remedier a la faille des arbres binaires?");

        // Suppression de l'arbre pour libérer la mémoire
        calcul.clear();

        // Fermeture du scan
        scan.close();
    }
}