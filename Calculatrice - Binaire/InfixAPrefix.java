import java.util.Stack;

public class InfixAPrefix {

    public static int operateurPriorite(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static String infixAPrefix(String infix) {
        String prefix = "";
        Stack<Character> operateurs = new Stack<>();

        // On inverse la chaine infixe
        for (int i = infix.length() - 1; i >= 0; --i) {
            char ch = infix.charAt(i);

            /*
             * Si le stack n'est pas vide
             * Soit l'operateur est superieur à l'opérateur sur le top du stack, et là
             * on le push
             *
             * Soit il est inferieur et là,
             * on fait sortir un opérateur du stack et l'ajouter au résultat jusqu'à ce
             * que le stack
             * soit vide ou que la priorité des éléments supérieurs soit supérieur, et là on
             * push
             * l'opérateur
             * 
             */
            if (operateurPriorite(ch) > 0) {
                while (operateurs.isEmpty() == false && operateurPriorite(operateurs.peek()) > operateurPriorite(ch)) {
                    prefix += operateurs.pop();
                    // System.out.println("je suis dans le if" + prefix);

                }
                // Si le stack est vide, push l'operateur
                operateurs.push(ch);
                // Si le caractère est '(', alors pop jusqu'à ')' et ajoutez-les au resultat et
                // pop '('
            } else if (ch == '(') {
                char x = operateurs.pop();
                while (x != ')') {
                    prefix += x;
                    x = operateurs.pop();
                    // System.out.println("je suis dans le premier else if" + prefix);

                }
                // si le caractere st ")", push
            } else if (ch == ')') {
                operateurs.push(ch);
                // System.out.println("je suis dans le deuxieme else if" + prefix);

                // Dans le cas où se sont des operandes
            } else {
                prefix += ch;
                // System.out.println("je suis dans le else" + prefix);

            }
        }
        // une fois l'expression terminée, supprimez tous les opérateurs de la pile et
        // ajoutez-les au résultat
        while (!operateurs.isEmpty()) {
            prefix += operateurs.pop();
        }

        String inverserPrefixe = "";
        for (int i = prefix.length() - 1; i >= 0; i--) {
            inverserPrefixe += prefix.charAt(i);
        }
        return inverserPrefixe;
    }
}