package AnteriorVersio;

import java.util.Scanner;

public class NumExp {
    public static void main(String[] args) {
        //Els números de 0 al 19 tenen noms únics. Aquests són: zero, un, dos, tres, quatre,
        //cinc, sis, set, vuit, nou, deu, onze, dotze, tretze, catorze, quinze, setze, disset, divuit i
        //dinou.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix un nombre per pasar a escrit en catala: ");
        long n = scanner.nextInt();
        System.out.print(say(n));



        /*
        Scanner scanner= new Scanner(System.in);
        System.out.println("Escriu un nombre en catala per pasar a long ");
        String s=scanner.nextLine();
        System.out.println(words(s));

         */
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
            boolean milBoolean = false;
            boolean milioBoolean = false;
            boolean milionsBool = false;
            boolean bilioBool = false;
            boolean boolBilions = false;
            boolean booltrilió =false;
            boolean trilionsBool = false;

            if (ar[0].equals("menys")) { //es negatiu si el primer caracter es menys.
                positiu = false;
                s = s.substring(6); //si es negatiu elimina els 6 primer caracters que es el que ocupa el menys
            }
            if (s.contains("mil") || s.contains("milió") || s.contains("milions") || s.contains("bilió") ||
                    s.contains("bilions") ||s.contains("trilió") || s.contains("trilions")) {

                for (int i = ar.length-1; i >=0 ; i--) {
                    s = ar[i];
                    // res = identificarWords(s, res);
                    if (s.equals("mil")) {
                        milBoolean= true;
                        if (i==0 && milionsBool==false) {
                            //si es la darrera posicio, es mil.
                            res+=1000;
                        } else if (i==0 && milionsBool==true) {
                            //casos especials, que com mil milions , el darrer valor desde dreta cap esquerra <--
                            // milioBool esta activat.
                            if (res<1_000) {
                                //si el resultat actual es mes petit que mil
                                //afegim mil
                                res += 1_000;
                            }
                            //multiplicam el resultat actual per mil
                            res *=1_000_000;
                        }
                        continue;
                    } else if (s.equals("milió")) {
                        milioBoolean=true;
                        //res =1_000_000;
                        continue;
                    } else if (s.equals("milions")) {
                        //activa el boolea de els milions
                        milionsBool=true;
                        //Desactiva el boolean de els milers
                        milBoolean=false;
                        continue;
                    } else if (s.equals("bilió")) {
                        milionsBool= false;
                        milBoolean = false;
                        //activa el boolea de el bilió
                        bilioBool=true;
                        continue;

                    } else if (s.equals("bilions")) {
                        //activa el boolea de el bilions
                        boolBilions=true;
                        //posam a false els milions i milers
                        milionsBool= false;
                        milBoolean = false;
                        continue;
                    } else if (s.equals("trilió")) {
                        // Desactiva els booleans de els mil,milions
                        milionsBool= false;
                        milBoolean = false;
                        bilioBool=false;
                        //activa el boolea de el trilió
                        booltrilió=true;
                        continue;
                    } else if (s.equals("trilions")) {
                        // Desactiva els booleans de els mil,milions

                        milionsBool= false;
                        milBoolean = false;
                        bilioBool=false;
                        boolBilions = false;
                        //activa el boolea d'el trilions
                        trilionsBool=true;
                        continue;
                    }


                    if (milBoolean==true) {
                        long resTemp = res; //guarda el resultat de antes de arribar a mil, de dreta a esquerra
                        res = 0; //per poder multiplicar per mil el següent nombre
                        res = identificarWords(s, res);
                        res *= 1000; //pasam la cantidad que ocupa el miler a long es a dir el resultat de el nombre
                        // escrit despres de la paraula mil * 1000.
                        if (milionsBool==true) {
                            res *=1_000_000;
                        } else if (boolBilions) {
                            //per si son mil x bilions.
                            res *= 1_000_000_000_000L;
                        }
                        res += resTemp;
                        // milBoolean= false;
                    } else if (milioBoolean==true) {
                        milBoolean=false;
                        long resTemp = res;
                        res = 0;
                        res = identificarWords(s,res);
                        res *=1_000_000;
                        res += resTemp;
                    } else if (milionsBool) {
                        System.out.println("ha entrat.");
                        milBoolean=false;
                        long resTemp = res;
                        res = 0;
                        res = identificarWords(s,res);
                        res *= 1_000_000;
                        res += resTemp;
                    } else if (bilioBool) {
                        milionsBool=false;
                        long resTemp = res;
                        res = 0;
                        res = identificarWords(s,res);
                        //multiplica per un bilió
                        res *= 1_000_000_000_000L;
                        res += resTemp;

                    } else if (boolBilions) {
                        milionsBool =false;
                        long resTemp = res;
                        res = 0;
                        res = identificarWords(s,res);
                        //multiplica per un bilió
                        res *= 1_000_000_000_000L;
                        res += resTemp;
                    } else if (booltrilió) {
                        boolBilions= false;
                        long resTemp = res;
                        res = 0;
                        res = identificarWords(s,res);
                        //multiplica per un bilió
                        res *= 1_000_000_000_000_000_000L;
                        res += resTemp;
                    } else if (trilionsBool) {
                        boolBilions= false;
                        long resTemp = res;
                        res = 0;
                        res = identificarWords(s,res);
                        //multiplica per un bilió
                        res *= 1_000_000_000_000_000_000L;
                        res += resTemp;
                    } else {
                        res = identificarWords(s, res);
                    }
                }
            } else {
                for (int i = 0; i < ar.length; i++) {
                    s = ar[i];
                    res = identificarWords(s, res);
                }
            }

            if (positiu == false) {
                res = -res; //Si es negatiu pasam el positiu a negatiu.
            }

            return res;
        }

        private static long identificarWords(String s, long res) {
            switch (s) {
                case "un","dos","tres","quantre","cinc","sis","set","vuit","nou" :
                    res = unitatsEscrit(s,res);
                    break;
                case "deu","onze","dotze","tretze","catorze","quinze","setze","disset","divuit","dinou":
                    res = unitatsEscrit(s,res);
                    break;
                case "vint","trenta","quaranta","cinquanta","seixanta","setanta","vuitanta","noranta":
                    res += desena(s);
                    break;
                case "cent":
                    res += 100;
                    break;
                case "mil":
                    res += 1000;
                default:
                    // System.err.println("Falta implementar, el valor que falla es " + s);
                    break;
            }


            if (s.contains("-i-")) {
                //guardam el valor actual de res
                long resTemp =res;
                //el valor de res el posam a 20
                res = 20;
                // la unitat de la vintena
                String residuVint = s.substring(7);
                //pasam a long la unitat i li suma a res que es 20
                res = unitatsEscrit(residuVint, 20);
                //Amb el resultat que teniem antes li sumam el de la vintena.
                res +=resTemp;
            } else if (s.equals("vint") || s.equals("trenta") || s.equals("quaranta") || s.equals("cinquanta") || s.equals("seixanta") || s.equals("setanta") || s.equals("vuitanta") || s.equals("noranta")) {
                res = desena(s);
            } else if (s.contains("-") && !s.contains("cents")) {
                //valors menors de 100
                String[] separaMenorCent = s.split("-");
                // agafa la desena i la unitat
                res =desena(separaMenorCent[separaMenorCent.length - 2]) + unitatsEscrit(separaMenorCent[separaMenorCent.length - 1], res);
            } else if (s.contains("cents")) {
                String[] centsSepara = s.split("-");
                //Variable temporal per guardar la centena
                long resTemp =0;
                resTemp = unitatsEscrit(centsSepara[centsSepara.length - 2], resTemp);//TODO: ALERTA ANTES ESTABA AMB += (POSIBLE FALLO FUTUR HEM DE CONTROLAR)
                //la unitat de la centena se multiplica per cent per convertirse en centena.
                resTemp *=100;
                //se suma el resTemp amb el resultat general i la suma es el nou res
                res += resTemp;

            } else {
                //res += identificarWords(s, res);
                long resTemp = res; //guarda el resultat de antes de arribar a mil, de dreta a esquerra
                res = 0; //per poder multiplicar per mil el següent nombre
                res +=resTemp;

                return res;
            }

            return res;
        }

        private static long unitatsEscrit(String s, long res) {

            switch (s) {
                case "zero" -> res +=0;
                case "un" -> res += 1;
                case "dos" -> res += 2;
                case "tres" -> res += 3;
                case "quatre" -> res += 4;
                case "cinc" -> res += 5;
                case "sis" -> res += 6;
                case "set" -> res += 7;
                case "vuit" -> res += 8;
                case "nou" -> res += 9;
                case "deu" -> res += 10;
                case "onze" -> res += 11;
                case "dotze" -> res += 12;
                case "tretze" -> res += 13;
                case "catorze" -> res += 14;
                case "quinze" -> res += 15;
                case "setze" -> res += 16;
                case "disset" -> res += 17;
                case "divuit" -> res += 18;
                case "dinou" -> res += 19;
            }
            return res;
        }


        private static long desena(String s) {
            if (s.equals("vint")) {
                return 20;
            } else if (s.equals("trenta")) {
                return 30;
            } else if (s.equals("quaranta")) {
                return 40;
            } else if (s.equals("cinquanta")) {
                return 50;
            } else if (s.equals("seixanta")) {
                return 60;
            } else if (s.equals("setanta")) {
                return 70;
            } else if (s.equals("vuitanta")) {
                return 80;
            } else if (s.equals("noranta")) {
                return 90;
            }
            return 0;
        }
        public static String oper(String s) { //La funció “oper” acceptarà un String on hi ha números representats amb paraules que
            //operen amb altres números. Tornarà un String on hi ha el número (amb paraules) que surt
            //en haver realitzat les operacions.
            long numLong = 0;
            s = s.toLowerCase();

            //String [] separaOp = {"menys","més","dividit","per"};
            // String[] proba = s.split("menys |més|dividit|per");


            // String[] partes = s.split("(menys |més|dividit|per)");


            String[] ar = s.split(" "); //separa per caracters

            //String primerValor = "";
            boolean numDespresDeOperador = false;

            long valor1 = 0;
            long valor2 = 1;
            String oper = "";
            String numStr1 ="";
            String numStr2 = "";

            //boolean per determinar si ja hi ha els nombres
            boolean llestPerOperar = false;
            long result = 0;
            //guarda el darrer element en el array
            String darrerElementArray = ar[ar.length-1];
            for (int i = 0; i < ar.length; i++) {

                s = ar[i];
            /*oper = proba[i];
            while (oper == s) {
                s += ar[i+1];
                System.out.println();
            }

             */
                if (s.equals("menys") || s.equals("més") || s.equals("dividit") || s.equals("per")) {
                    // si es un operador amb el proxim nombre se ha de operar
                    numDespresDeOperador = true;
                    oper = s;
                    continue;
                } else {
                    if (!numDespresDeOperador) { //si es un nombre que NO va despres de el operador
                        System.out.println("ha entrat despres");
                        numStr1 = numStr1+ " " + s;
                    } else {
                        //si el valor  de numStr esta vuit
                        numStr2 =numStr2+ " "+ s;


                    }
                    if (s!=darrerElementArray) {
                        System.out.println("ultim " + s);
                        continue;
                    }
                    valor2 = words(numStr2);
                    valor1 = words(numStr1);

                }
                if (numDespresDeOperador) {

                    result = operacio(valor1,valor2, oper);
                    numDespresDeOperador=false;
                    //break;
                }
            }


            //result= words(s);
            String resultatFinal = say(result);
            return resultatFinal;
        }

        private static long operacio(long valor1,long valor2,String oper) {
            long resultat =0;
            switch (oper) {
                case "menys":
                    resultat= valor1 - valor2;
                    break;

                case "més":
                    resultat= valor1 + valor2;
                    break;
                case "dividit":
                    resultat= valor1/valor2;

                    break;

                case "per":
                    resultat= valor1 * valor2;

                    break;
                default:
                    break;
            }
            return resultat;
        }
}