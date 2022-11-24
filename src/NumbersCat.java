import java.util.Scanner;
public class NumbersCat {
    private static long n;

    public static void main(String[] args) {
        //Els números de 0 al 19 tenen noms únics. Aquests són: zero, un, dos, tres, quatre,
        //cinc, sis, set, vuit, nou, deu, onze, dotze, tretze, catorze, quinze, setze, disset, divuit i
        //dinou.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix un nombre per pasar a escrit en catala: " );
       int n = scanner.nextInt();



        //int n =0;
        //say(n);
        System.out.print(say(n));

    }
    public static String say(long n) {
        //La funció “say” acceptarà un paràmetre de tipus “long” i tornarà un String amb les paraules
        //en català corresponents al número que li hem passat.

        String[] desena = {"","deu","vint","trenta","quaranta","cinquanta","seixanta","setanta","vuitanta","noranta"};//desenas
        String[] centenas = {"","cent"};
        int dec = (int) (n/10);//agafa la primera decena.
        int uni =((int)n%10); //guarda el residu es a dir la resta de numeros.
/*
        for (int i = 0; i < unicNums.length; i++) {
            unicNums[i] = capitalLetter(unicNums[i]);
        } //Per posar les lletres amb mayuscula.

 */


        String[] unicNums = {"zero", "un", "dos", "tres", "quatre",
                "cinc", "sis", "set", "vuit", "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit",
                "dinou"};
        if (0>n) {
            n=-n; //feim que el numero sigui positiu. li llevam el menys(-)
            return "Menys " + unicNums[(int) n].toLowerCase();

        }
        if (n <= 19){
            return capitalLetter(unicNums[(int) n]);
        }
        if (n >= 20 && n <100) {
            if (uni==0){
               return capitalLetter(desena[dec]);
           }
            //decena(n, desena); //Crida a la funcio del 20 al 99
            if (n <30) { //el minim ja no fa falta el especifiquem ja que esta fet en el primer if
                //int dec = (int) (n/10);//agafa la primera decena.
                //int uni =((int)n%10); //guarda el residu es a dir la resta de numeros.
                return capitalLetter(desena[dec])  + "-i-" + unicNums[uni].toLowerCase();
            }else { //De 30 a 99
                return capitalLetter(desena[dec]) + "-" + unicNums[uni].toLowerCase();
            }
        }
        return say(n);
    }
    private static String capitalLetter(String mayuscula) {
        String primerLletra = mayuscula.substring(0,1);
        String primerMayuscula = primerLletra.toUpperCase();
        String noPrimeraLletra = mayuscula.substring(1,mayuscula.length());
        return primerMayuscula + noPrimeraLletra;
    }

    /*private static String numsUnics(long n) {
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
