public class Calcul {
    private String[] args;
    private String signe;

    // Creation d'un singleton pour éviter la création de nouveaux d'objets.
    public Calcul(String[] args) {
        this.args = args;
    }

    // Checker si 2 éléments sont les mêmes hors egalité structurelle
    @Override
    public boolean equals(Object o) {
        boolean resultat = true;
        if (this == o)
            resultat = true;
        if (o == null)
            resultat = false;
        return resultat;
    }

    // Convertir les valeurs string en double
    public double conversionStringtoDouble(String chiffreAConvertir) {
        double somme = 0.0;
        double position = 1;
        for (int i = chiffreAConvertir.length() - 1; i >= 0; i--) {
            double nombre = chiffreAConvertir.charAt(i) - '0';
            somme += nombre * position;
            position = position * 10;

        }
        return somme;
    }

    public void conversionStringtoOperator(String operateur) {
        String signe = " ";
        if (operateur.equals("-"))
            signe = "-";

    }

    /*
     * On ne prends pas en compte que le signe est collé car les
     * calculatrices
     * stockent les caractères un par un
     */

    public void calculatrice() {
        double resultatNegatif = 0.0;
        double resultatPositif = 0.0;

        // Check si args[0] contient un signe negatif et pas un chiffre
        if (args[0].equals("-")) {
            if (args.length <= 4) {
                // On veut récuperer le signe QU'UNE SEULE FOIS

                for (int i = 0; i <= 0; i++) {
                    resultatNegatif = -conversionStringtoDouble(args[1]) + (i + 1)
                            + conversionStringtoDouble(args[i + 3]);
                }
            } else {
                for (int i = 0; i <= 0; i++) {
                    resultatNegatif = -conversionStringtoDouble(args[1]);
                }
                // On continue à looper sur le reste de la liste
                for (int i = 1; i < args.length - 2; i++) {
                    resultatNegatif += (i + 1) + conversionStringtoDouble(args[i + 2]);
                }
            }

        }
        System.out.println(resultatNegatif);
    }
}