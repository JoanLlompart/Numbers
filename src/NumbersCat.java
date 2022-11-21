import java.util.Scanner;

public class NumbersCat {
    public static void main(String[] args) {
        //Els números de 0 al 19 tenen noms únics. Aquests són: zero, un, dos, tres, quatre,
        //cinc, sis, set, vuit, nou, deu, onze, dotze, tretze, catorze, quinze, setze, disset, divuit i
        //dinou.

        int n = 0;


       /* String[] numsUnics = {"zero", "un", "dos", "tres", "quatre",
                "cinc", "sis", "set", "vuit", "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit",
                "dinou"};

        */

        demanarNum(n);

    }

     private static void demanarNum(int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix un nombre per pasar a escrit en catala: " );
        n = scanner.nextInt();

        if (0>n) {
            System.out.println("Num negatiu encara no esta preparat");
            System.out.println("menos " + numsUnics(n));

        }else if (n<20) {
            numsUnics(n);
        }else {
            System.out.println("Num mes gran que 19");
        }
    }

     private static String numsUnics(int n) {
        String[] unicNums = {"zero", "un", "dos", "tres", "quatre",
                "cinc", "sis", "set", "vuit", "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit",
                "dinou"};
        System.out.println(unicNums[n]);
         return null;
     }


    public static String say(long n) {
        //La funció “say” acceptarà un paràmetre de tipus “long” i tornarà un String amb les paraules
        //en català corresponents al número que li hem passat.
        ;


        return "";
    }


    public static long words(String s) {// La funció “words” fa l’operació inversa: transforma un String en un número de tipus long.
        return 0;
    }

    public static String oper(String s) { //La funció “oper” acceptarà un String on hi ha números representats amb paraules que
                                          //operen amb altres números. Tornarà un String on hi ha el número (amb paraules) que surt
                                          //en haver realitzat les operacions.
        return "";
    }



}
