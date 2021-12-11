import java.util.Scanner;

public class Calcul {
    public static void main(String[] args) {
        // Variables locales
        double premierChiffre, deuxiemeChiffre;
        double resultat = 0.0;
        String stop = "";

        // Appel du scanner
        Scanner scan = new Scanner(System.in);

        while (!stop.equals("n")) {
            System.out.println("Entrez votre premier chiffre:");
            premierChiffre = scan.nextDouble();
            System.out.println("Entrez votre deuxieme chiffre:");
            deuxiemeChiffre = scan.nextDouble();
            System.out.println("Entrez +,-,* ou / pour la partie de votre expression");
            String reponse = scan.next();

            switch (reponse) {
                case "-":
                    resultat += (premierChiffre - deuxiemeChiffre);
                    break;
                case "+":
                    resultat += (premierChiffre + deuxiemeChiffre);
                    break;
                case "/":
                    if (premierChiffre == 0 || deuxiemeChiffre == 0) {
                        System.out.println("Pas de division avec 0!");
                        break;
                    } else {
                        resultat += (premierChiffre / deuxiemeChiffre);
                    }
                case "*":
                    resultat += (premierChiffre * deuxiemeChiffre);
                default:
                    System.out.println("Ce n'est pas un operateur!");
                    return;
            }
            System.out.println("Y a t-il une continuite à votre expression ? n pour arrêter");
            stop = scan.next();
        }
        System.out.println("Votre expression vaut :" + resultat);
    }
}
