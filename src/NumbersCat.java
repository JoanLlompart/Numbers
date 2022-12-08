import java.util.Scanner;
public class NumbersCat {
    public static void main(String[] args) {
        //Els números de 0 al 19 tenen noms únics. Aquests són: zero, un, dos, tres, quatre,
        //cinc, sis, set, vuit, nou, deu, onze, dotze, tretze, catorze, quinze, setze, disset, divuit i
        //dinou.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix un nombre per pasar a escrit en catala: ");
        long n = scanner.nextInt();
        System.out.print(say(n));
    }
    public static String say(long n) {
        //La funció “say” acceptarà un paràmetre de tipus “long” i tornarà un String amb les paraules
        //en català corresponents al número que li hem passat.

        String[] desena = {"", "deu", "vint", "trenta", "quaranta", "cinquanta", "seixanta", "setanta", "vuitanta", "noranta"};//desenas
        String[] unicNums = {"zero", "un", "dos", "tres", "quatre",
                "cinc", "sis", "set", "vuit", "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit",
                "dinou"};
        String result = "";
        boolean positiu = true;
        if (0 > n) {
            n = -n; //feim que el numero sigui positiu. li llevam el menys(-) (Funcio per nombres menors).
            positiu = false;
        }
        //Variables de unitats
        int milio = (int) (n / 1000000); // milio
        int restaMilio = (int) (n % 1000000); // restaMilio
        int milena = (restaMilio / 1000);//agafa la primera centena.
        int restaMil = (restaMilio % 1000); //guarda el residu es a dir la resta de numeros.
        int cente = (restaMil / 100);//agafa la primera centena.
        int restaCent = (restaMil % 100); //guarda el residu es a dir la resta de numeros.
        int dec = (restaCent / 10);//agafa la primera decena.
        int uni = (restaCent % 10); //guarda el residu es a dir la resta de numeros.
        int uniMil = milena % 10; //per a la milena no giri els nombres residu de decMil
        int decMil = milena / 10; // EX: 21000 --> 2 decMil i 1 uniMil.

        if (n >= 0 && n < 100) {
            result = finsA100(n, unicNums, uni, desena, dec);
        }
        //Numeros del 100 al 999.
        if (n > 99 && n < 1000) { //Funcio menys de mil
            result = menysDeMil(n, desena, dec, unicNums, uni, restaCent, cente);
        }

        //Menys de 1 milio.
        if (n > 999 && n < 1000000) {
            result = menysDeMilio(n, desena, dec, unicNums, uni, restaCent, cente, restaMil, milena, decMil, uniMil);
        }

        if (positiu == false) {
            result = "Menys " + result.toLowerCase();
        }
        return result;
    }

    private static String finsA100(long n, String[] unicNums, int uni, String[] desena, int dec) {
        String resultFins100 = "";
        if (n < 20) {
            resultFins100 = menorQueVint(n, unicNums);
        }
        if (n > 19 && n < 100) {
            if (uni == 0) {
                return capitalLetter(desena[dec]); //Num fora unitats
            }
            if (n < 30) { //el minim ja no fa falta el especifiquem ja que esta fet en el primer if
                resultFins100 = vintena(desena, dec, unicNums, uni);
            } else { //De 30 a 99
                resultFins100 = menysDe100(desena, dec, unicNums, uni);
            }
        }
        return resultFins100;
    }
    private static String menysDeMilio(long n, String[] desena, int dec, String[] unicNums, int uni, int restaCent, int cente, int restaMil, int milena, int decMil, int uniMil) {
        String miler = "mil";
        String resultMenysDeMilio = "";

        if (restaMil == 0) {
            resultMenysDeMilio = capitalLetter(miler);
        } else if (n > 1000 && n < 2000) {
            if (restaMil < 20) { // de 1001 a 1019.
                resultMenysDeMilio = capitalLetter(miler) + " " + unicNums[restaMil].toLowerCase(); //de 1001 a 1019.
            } else if (restaMil > 19 && restaMil < 30) { // 1020 a 1029
                resultMenysDeMilio = capitalLetter(miler) + " " + vintena(desena, dec, unicNums, uni).toLowerCase();
            } else if (restaMil > 29 && restaMil < 100) { //majors de 1029 i maxim 1099.
                resultMenysDeMilio = capitalLetter(miler) + " " + menysDe100(desena, dec, unicNums, uni).toLowerCase();
            } else if (restaMil > 99 && restaMil < 1000) { // de 1099 a 1999
                resultMenysDeMilio = capitalLetter(miler) + " " + menysDeMil(restaMil, desena, dec, unicNums, uni, restaCent, cente).toLowerCase();
            }
        }
        if (milena > 1 && milena < 20) {
            //fer milenas
            if (restaMil == 0) { //antes restamil
                resultMenysDeMilio = capitalLetter(unicNums[milena]) + " " + miler;
            } else if (restaMil < 100) { //Si el restaMil no es zero, de 1001 a 19999
                resultMenysDeMilio = capitalLetter(unicNums[milena]) + " " + miler + " " + finsA100(restaMil, unicNums, uni, desena, dec).toLowerCase();
            } else if (restaMil > 99 && restaMil < 1000) { // de 1099 a 1999
                resultMenysDeMilio = capitalLetter(unicNums[milena]) + " " + miler + " " + menysDeMil(restaMil, desena, dec, unicNums, uni, restaCent, cente).toLowerCase();
            }
        } else if (milena > 19 && milena < 100) { //prova 1000
            if (restaMil == 0) {
                resultMenysDeMilio = capitalLetter(finsA100(milena, unicNums, uniMil, desena, decMil)) + " " + miler;
            } else if (restaMil < 100) { //Noranta-nou mil nou-cents noranta
                resultMenysDeMilio = capitalLetter(finsA100(milena, unicNums, uniMil, desena, decMil)) + " " + miler + " " + finsA100(restaMil, unicNums, uni, desena, dec).toLowerCase();
            } else if (restaMil < 1000) {
                resultMenysDeMilio = capitalLetter(finsA100(milena, unicNums, uniMil, desena, decMil)) + " " + miler + " " + menysDeMil(restaMil, desena, dec, unicNums, uni, restaCent, cente).toLowerCase();
            }
        } else if (milena > 99 && milena < 1000) {
            if (restaMil == 0) { //milena mes  gran a 100 i sense centenes.
                resultMenysDeMilio = capitalLetter(menysDeMil(milena, desena, decMil, unicNums, uniMil, restaCent, cente)) + " " + miler;
            } else if (restaMil < 100) {
                resultMenysDeMilio = capitalLetter(menysDeMil(milena, desena, decMil, unicNums, uniMil, restaCent, cente)) + " " + miler + " " + finsA100(restaMil, unicNums, uni, desena, dec).toLowerCase();
            } else if (restaMil < 1000) {
                resultMenysDeMilio = capitalLetter(menysDeMil(milena, desena, decMil, unicNums, uniMil, restaCent, cente)) + " " + miler + " " + menysDeMil(restaMil, desena, dec, unicNums, uni, restaCent, cente).toLowerCase();
            }
        }

        return resultMenysDeMilio;
    }

    private static String menysDeMil(long n, String[] desena, int dec, String[] unicNums, int uni, int restaCent, int cente) {
        String[] centenas = {"", "cent", "dos-cents", "tres-cents", "quatre-cents", "cinc-cents", "sis-cents", "set-cents", "vuit-cents", "nou-cents"};
        String resultCent = "";
        if (restaCent == 0) {
            resultCent = capitalLetter(centenas[cente]); //falta el doscents
        } else if (n > 99 && n < 1000) {
            if (uni == 0) { //Les decenas sense unitats.Ex : 20,30,40,50,etc
                resultCent = capitalLetter(centenas[cente]) + " " + desena[dec];
            }
            if (n > 100 && n < 120) {
                resultCent = capitalLetter(centenas[cente]) + " " + unicNums[restaCent].toLowerCase(); //Funciona fins a 109. A partir de alla falla.
            }
            if (n > 119 && n < 130) {
                resultCent = capitalLetter(centenas[cente]) + " " + vintena(desena, dec, unicNums, uni).toLowerCase(); // els nombres que tenguin resta cent entre la vintena entrara a la funcio
                // i li hem pasat els parametres que necesita per retornar la vintena.
            }
            if (n > 130 && n < 200) {
                resultCent = capitalLetter(centenas[cente]) + " " + menysDe100(desena, dec, unicNums, uni).toLowerCase(); //Funciona fins a 109. A partir de alla falla.
            }
            if (n > 199 && n < 1000) { //Valors majors o iguals a 200 fins a 999.
                if (restaCent < 20) //Agafam la decena Restacent.
                    resultCent = capitalLetter(centenas[cente]) + " " + unicNums[restaCent].toLowerCase();
                else if (restaCent < 30) { //Si es menys de 30 la decena cridam i feim us de la funcio vintena i li pasam tots els parametres que necesita.
                    resultCent = capitalLetter(centenas[cente]) + " " + vintena(desena, dec, unicNums, uni).toLowerCase();
                } else { //els nums de 30 o mes decenas
                    resultCent = capitalLetter(centenas[cente]) + " " + menysDe100(desena, dec, unicNums, uni).toLowerCase();
                }
            }
        }
        return resultCent;
    }

    private static String menysDe100(String[] desena, int dec, String[] unicNums, int uni) { //de 30 fins a 99
        if (uni == 0) { //Perque no torni un zero a les decenes si unitat es 0 escriu nomes la decena.
            return capitalLetter(desena[dec]);
        } else { //Si te unitats escriu la decena - unitat
            return capitalLetter(desena[dec]) + "-" + unicNums[uni].toLowerCase();
        }
    }

    private static String vintena(String[] desena, int dec, String[] unicNums, int uni) { //Escriu els nombres de 20 a 29.
        if (uni == 0) {
            return capitalLetter(desena[dec]);
        } else {
            return capitalLetter(desena[dec]) + "-i-" + unicNums[uni].toLowerCase();
        }
    }

    private static String menorQueVint(long n, String[] unicNums) { //Menor
        return capitalLetter(unicNums[(int) n]);
    }

    private static String capitalLetter(String mayuscula) {
        String primerLletra = mayuscula.substring(0, 1);
        String primerMayuscula = primerLletra.toUpperCase();
        String noPrimeraLletra = mayuscula.substring(1, mayuscula.length());
        return primerMayuscula + noPrimeraLletra;
    }

    public static long words(String s) {// La funció “words” fa l’operació inversa: transforma un String en un número de tipus long.
        s = s.toLowerCase();
        String[] ar = s.split(" "); //separa per caracters

        long res = 0;
        boolean positiu = true;

        if (ar[0].equals("menys")) { //es negatiu si el primer caracter es menys.
            positiu = false;
            s = s.substring(6); //si es negatiu elimina els 6 primer caracters que es el que ocupa el menys
        }
        res = unitatsEscrit(s, res);


        if (positiu == false) {
            res = -res; //Si es negatiu pasam el positiu a negatiu.
        }
        return res;
    }

    private static long unitatsEscrit(String s, long res) {
        switch (s) {
            case "un" -> res = 1;
            case "dos" -> res = 2;
            case "tres" -> res = 3;
            case "quate" -> res = 4;
            case "cinc" -> res = 5;
            case "sis" -> res = 6;
            case "vuit" -> res = 8;
            case "nou" -> res = 9;
            case "deu" -> res = 10;
            case "onze" -> res = 11;
            case "dotze" -> res = 12;
            case "tretze" -> res = 13;
            case "catorze" -> res = 14;
            case "quinze" -> res = 15;
            case "setze" -> res = 16;
            case "disset" -> res = 17;
            case "divuit" -> res = 18;
            case "dinou" -> res = 19;
        }
        return res;
    }

    public static String oper(String s) { //La funció “oper” acceptarà un String on hi ha números representats amb paraules que
        //operen amb altres números. Tornarà un String on hi ha el número (amb paraules) que surt
        //en haver realitzat les operacions.
        return "";
    }
}