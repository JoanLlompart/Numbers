import java.util.Scanner;
public class NumbersCat {
    public static void main(String[] args) {
        //Els números de 0 al 19 tenen noms únics. Aquests són: zero, un, dos, tres, quatre,
        //cinc, sis, set, vuit, nou, deu, onze, dotze, tretze, catorze, quinze, setze, disset, divuit i
        //dinou.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix un nombre per pasar a escrit en catala: ");
        int n = scanner.nextInt();
        //say(n);
        System.out.print(say(n));
    }
    public static String say(long n) {
        //La funció “say” acceptarà un paràmetre de tipus “long” i tornarà un String amb les paraules
        //en català corresponents al número que li hem passat.

        String[] desena = {"", "deu", "vint", "trenta", "quaranta", "cinquanta", "seixanta", "setanta", "vuitanta", "noranta"};//desenas
        String[] unicNums = {"zero", "un", "dos", "tres", "quatre",
                "cinc", "sis", "set", "vuit", "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit",
                "dinou"};
        String result="";
        boolean positiu = true;
        if (0 > n) {
            n = -n; //feim que el numero sigui positiu. li llevam el menys(-) (Funcio per nombres menors).
            positiu = false;
        }
        int dec = (int) (n / 10);//agafa la primera decena.
        int uni = ((int) n % 10); //guarda el residu es a dir la resta de numeros.

        if (n <= 19) {
            result =menorQueVint(n,unicNums);
        }
        if (n >= 20 && n < 100) {
            if (uni == 0) {

                return capitalLetter(desena[dec]); //Num fora unitats
            }
            //decena(n, desena); //Crida a la funcio del 20 al 99 (Crear funcio apart)
            if (n < 30) { //el minim ja no fa falta el especifiquem ja que esta fet en el primer if
                result = vintena(desena,dec,unicNums,uni);
                long resultVint  = Long.parseLong(vintena(desena,dec,unicNums,uni));
                // return capitalLetter(desena[dec]) + "-i-" + unicNums[uni].toLowerCase();
            } else { //De 30 a 99
                result = menysDe90(desena,dec,unicNums,uni);
                //return capitalLetter(desena[dec]) + "-" + unicNums[uni].toLowerCase();
            }
        }
        //Numeros del 100 al 999.(Crear funcio apart)
        if (n > 99 && n<1000) {
            result =menysDeMil(n,desena,dec,unicNums,uni);

            /*
            if (uni==0) {
                return capitalLetter(centenas[cente]);
            }
            if (n > 100 && n < 200){
                return capitalLetter(centenas[cente]) + " " + unicNums[restaCent].toLowerCase(); //Funciona fins a 109. A partir de alla falla.
            }
             */
        }
        if (positiu == false) {
            result ="Menys " + result.toLowerCase();
        }
        return result;
    }

    private static String menysDeMil(long n, String[] desena, int dec, String[] unicNums, int uni) {
        int cente = (int) (n / 100);//agafa la primera centena.
        int restaCent = ((int) n % 100); //guarda el residu es a dir la resta de numeros.
        int descenaRestaCent = ( restaCent / 10); //guarda el residu de restaCent i retorna una unidad.
        String[] centenas = {"", "cent","dos-cents","tres-cents","quatre-cents","cinc-cents","sis-cents","set,cents","vuit-cents","nou-cents"};
        String resultCent = "";

        if (restaCent==0) {
            resultCent = capitalLetter(centenas[cente]); //falta el doscents
        }else if (n > 99 && n < 1000) {
            if (n > 100 && n < 120) {
                resultCent = capitalLetter(centenas[cente]) + " " + unicNums[restaCent].toLowerCase(); //Funciona fins a 109. A partir de alla falla.
            }
            if (n > 119 && n < 130) {
                resultCent = capitalLetter(centenas[cente]) + " " + vintena(desena,descenaRestaCent,unicNums,uni).toLowerCase(); // els nombres que tenguin resta cent entre la vintena entrara a la funcio
                // i li hem pasat els parametres que necesita per retornar la vintena.
            }
            if (n >=130 && n < 200) {
                resultCent = capitalLetter(centenas[cente]) + " " +menysDe90(desena,descenaRestaCent,unicNums,uni).toLowerCase(); //Funciona fins a 109. A partir de alla falla.
            }
            if (n >= 200 && n <1000) { //Valors majors o iguals a 200 fins a 999.
                if (restaCent == 0) { //Si la centena es sense decena entra i mostra la centena nomes.
                    resultCent = capitalLetter(centenas[cente]);
                }
                if (restaCent < 20) //Agafam la decena Restacent
                    resultCent = capitalLetter(centenas[cente]) + " " + unicNums[restaCent].toLowerCase();
                else if (restaCent < 30) { //Si es menys de 30 la decena cridam i feim us de la funcio vintena i li pasam tots els parametres que necesita.
                    resultCent = capitalLetter(centenas[cente]) + " " + vintena(desena,descenaRestaCent,unicNums,uni).toLowerCase();
                } else {
                    resultCent = capitalLetter(centenas[cente]) + " " + menysDe90(desena,descenaRestaCent,unicNums,uni).toLowerCase();
                }
            }

        }
        return resultCent;
    }

    private static String menysDe90(String[] desena, int dec, String[] unicNums, int uni) {
        return capitalLetter(desena[dec]) + "-" + unicNums[uni].toLowerCase();
    }

    private static String vintena(String[] desena,int dec,String[] unicNums,int uni) { //Escriu els nombres de 20 a 29
        return capitalLetter(desena[dec]) + "-i-" + unicNums[uni].toLowerCase();
    }

    private static String menorQueVint(long n,String[] unicNums) { //Menor
        return capitalLetter(unicNums[(int) n]);
    }

    private static String capitalLetter(String mayuscula) {
        String primerLletra = mayuscula.substring(0, 1);
        String primerMayuscula = primerLletra.toUpperCase();
        String noPrimeraLletra = mayuscula.substring(1, mayuscula.length());
        return primerMayuscula + noPrimeraLletra;
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

