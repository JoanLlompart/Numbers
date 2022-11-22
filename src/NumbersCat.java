import java.util.Locale;
import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class NumbersCat {
    public static void main(String[] args) {
        //Els números de 0 al 19 tenen noms únics. Aquests són: zero, un, dos, tres, quatre,
        //cinc, sis, set, vuit, nou, deu, onze, dotze, tretze, catorze, quinze, setze, disset, divuit i
        //dinou.
        int n =0;
       /* String[] numsUnics = {"zero", "un", "dos", "tres", "quatre",
                "cinc", "sis", "set", "vuit", "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit",
                "dinou"};
        */


        say(n);

    }

    /* private static void menor20(int n) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix un nombre per pasar a escrit en catala: " );
        n = scanner.nextInt();



        if (0>n) {
            System.out.println("Num negatiu encara no esta preparat");
            n=-n;
            System.out.println("Menys " + numsUnics(n));

        }else if (n<20) {
            numsUnics(n);
        }else {
            System.out.println("Num mes gran que 19");

        }
    }

        */

    public static String say(long n) {
        //La funció “say” acceptarà un paràmetre de tipus “long” i tornarà un String amb les paraules
        //en català corresponents al número que li hem passat.

       /* Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix un nombre per pasar a escrit en catala: " );
        n = scanner.nextInt();


        */
        String[] unicNums = {"zero", "un", "dos", "tres", "quatre",
                "cinc", "sis", "set", "vuit", "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit",
                "dinou"};

        for (int i = 0; i < unicNums.length; i++) {
            unicNums[i] = capitalLetter(unicNums[i]);

        }

        if (0>n) {
            System.out.println("Num negatiu encara no esta preparat");
            n=-n;
            return "Menys " + unicNums[(int) n].toLowerCase();

        }else if (n<20) {
            return capitalLetter(unicNums[(int) n]);
        }else {
            System.out.println("Num mes gran que 19");
        }

        return say(n);
    }

    private static String capitalLetter(String mayuscula) {
        String primerLletra = mayuscula.substring(0,1);

        String primerMayuscula = primerLletra.toUpperCase();

        String noPrimeraLletra = mayuscula.substring(1,mayuscula.length());

        String inici = primerMayuscula + noPrimeraLletra;
        return inici;
    }

    /*private static String numsUnics(long n) {
        String[] unicNums = {"zero", "un", "dos", "tres", "quatre",
                "cinc", "sis", "set", "vuit", "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit",
                "dinou"};



        //System.out.println(unicNums[(int)n]);//Els Arrays nomes accepten int i li pasam un long per pasar a int hem de fer un cast [(int)n]
        return unicNums[(int)n];
    }

     */
    public static long words(String s) {// La funció “words” fa l’operació inversa: transforma un String en un número de tipus long.
        return 0;
    }
    public static String oper(String s) { //La funció “oper” acceptarà un String on hi ha números representats amb paraules que
                                          //operen amb altres números. Tornarà un String on hi ha el número (amb paraules) que surt
                                          //en haver realitzat les operacions.
        return "";
    }





}
