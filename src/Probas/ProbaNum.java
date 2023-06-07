package Probas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProbaNum {
        /*public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introdueix un nombre per pasar a escrit en català: ");
            String s = scanner.nextLine();
            System.out.println(words(s));
        }

         */


    public static String say(long n) {
        boolean negatiu = false;

        if (n < 0) {
            negatiu = true;
            n = -n;
        }

        String resultat = escriuLletres(n);
        if (negatiu) { //negatiu = true
            resultat = "Menys " + resultat;
        }
        resultat = capitalLetter(resultat);
        return resultat;
    }

    private static String escriuLletres(long n) {
        if (n == 0) return "Zero";
        if (n < 10) {
            return unitats(n);
        } else if (n < 20) {
            return menor20(n);
        } else if (n < 30) {
            return desenes(n);
        } else if (n <= 99) {
            return desenes(n);
        } else if (n <= 999) {
            return centenes(n);
        } else if (n <= 9999) {
            return milers(n);
        } else if (n <= 999999) {
            return milers(n);
        } else if (n <= 999_999_999_999L) {
            return milions(n);
        } else if (n <= 999_999_999_999_999_999L) {
            return bilions(n);
        } else {
            return trilions(n);
        }
    }

    private static String trilions(long n) {
        if (n < 999_999_999_999_999_999L) return bilions(n);
        if (n == 1_000_000_000_000_000_000L) return "un trilió";
        else if (n >= 1_000_000_000_000_000_000L && n <= 1_999_999_999_999_999_999L) {
            return "un trilió " + bilions(n % 1_000_000_000_000_000_000L);
        } else if (n % 1_000_000_000_000_000_000L == 0) {
            return bilions(n / 1_000_000_000_000_000_000L) + " trilions" + bilions(n % 1_000_000_000_000_000_000L) + milions(n % 100_000_000_000_000L);
        } else if (n >= 2_000_000_000_000_000_000L) {
            return bilions(n / 1_000_000_000_000_000_000L) + " trilions " + bilions(n % 1_000_000_000_000_000_000L) + milions(n % 10_000_000_000_000L);
        }
        return "";
    }

    private static String bilions(long n) {
        if (n < 999_999_999_999L) return milions(n);
        if (n == 1_000_000_000_000L) return "un bilió";
        else if (n >= 1_000_000_000_000L && n <= 1_999_999_999_999L) {
            return "un bilió " + milions(n % 1_000_000_000_000L);
        } else if (n % 1_000_000_000_000L == 0) {
            return milions(n / 1_000_000_000_000L) + " bilions" + milions(n % 1_000_000_000_000L) + milers(n % 100_000_000);
        } else if (n >= 2_000_000_000_000L && n <= 999_999_999_999_999_999L) {
            return milions(n / 1_000_000_000_000L) + " bilions " + milions(n % 1_000_000_000_000L) + milers(n % 10_000_000L);
        }
        return "";
    }

    private static String milions(long n) {
        if (n < 999999) return milers(n);
        if (n == 1_000_000) return "un milió";
        else if (n >= 1_000_000 && n <= 1_999_999L) {
            return "un milió " + milers(n % 1_000_000);
        } else if (n % 1_000_000 == 0) {
            return milers(n / 1_000_000) + " milions" + milers(n % 1_000_000) + centenes(n % 10_000_000);
        } else if (n >= 2_000_000 && n <= 999_999_999_999L) {
            return milers(n / 1_000_000) + " milions " + milers(n % 1_000_000) + centenes(n % 10_000_000);
        }
        return "";
    }

    private static String milers(long n) {
        if (n < 100) return desenes(n);
        if (n < 1000) return centenes(n);
        if (n == 1000) return "mil";
        else if (n <= 1999) {
            return "mil " + centenes(n % 1000);
        } else if (n <= 9999) {
            if (n % 1000 == 0) {
                return unitats(n / 1000) + " mil" + centenes(n % 1000);
            } else return unitats(n / 1000) + " mil " + centenes(n % 1000);
        } else if (n < 99999) {
            return desenes(n / 1000) + " mil " + centenes(n % 1000);
        } else if (n > 99999 && n <= 999999) {
            if (n % 10000 == 0) {
                return centenes(n / 1000) + " mil" + centenes(n % 1000);
            } else if (n % 1000 == 0) {
                return centenes(n / 1000) + " mil" + centenes(n % 1000);
            } else {
                return centenes(n / 1000) + " mil " + centenes(n % 1000);
            }
        }
        return "";
    }

    private static String centenes(long n) {
        if (n < 10) return unitats(n);
        if (n < 100) return desenes(n);
        if (n == 100) return "cent";
        if (n < 200) {
            return "cent " + desenes(n % 100);
        }
        if (n < 1000) {
            if (n % 100 == 0) {
                return unitats(n / 100) + "-cents" + desenes(n % 100);
            } else return unitats(n / 100) + "-cents " + desenes(n % 100);
        }

        return "";
    }

    private static String unitats(long n) {
        if (n == 1) return "un";
        if (n == 2) return "dos";
        if (n == 3) return "tres";
        if (n == 4) return "quatre";
        if (n == 5) return "cinc";
        if (n == 6) return "sis";
        if (n == 7) return "set";
        if (n == 8) return "vuit";
        if (n == 9) return "nou";
        return "";
    }

    private static String desenes(long n) {
        if (n < 10) return unitats(n);
        if (n < 20) {
            return menor20(n);
        }
        if (n == 20) return "vint";
        if (n < 30) {
            return "vint" + "-i-" + unitats(n % 10);
        }
        if (n < 40) {
            if (n == 30) return "trenta";
            return "trenta" + "-" + unitats(n % 10);
        }
        if (n < 50) {
            if (n == 40) return "quaranta";
            return "quaranta" + "-" + unitats(n % 10);
        }
        if (n < 60) {
            if (n == 50) return "cinquanta";
            return "cinquanta" + "-" + unitats(n % 10);
        }
        if (n < 70) {
            if (n == 60) return "seixanta";
            return "seixanta" + "-" + unitats(n % 10);
        }
        if (n < 80) {
            if (n == 70) return "setanta";
            return "setanta" + "-" + unitats(n % 10);
        }
        if (n < 90) {
            if (n == 80) return "vuitanta";
            return "vuitanta" + "-" + unitats(n % 10);
        }
        if (n < 100) {
            if (n == 90) return "noranta";
            return "noranta" + "-" + unitats(n % 10);
        }
        return "";
    }


    private static String capitalLetter(String mayuscula) {
        //String que guarda la primera lletra per pasarla a majuscula
        String primerLletra = mayuscula.substring(0, 1);
        //pasa la lletra a majuscula i la guarda a primerMayuscula
        String primerMayuscula = primerLletra.toUpperCase();
        //Treu la primera lletra i en el return de abaix afageix en el seu lloc la lletra amb mayuscula
        String noPrimeraLletra = mayuscula.substring(1, mayuscula.length());
        return primerMayuscula + noPrimeraLletra;
    }

    private static String menor20(long n) {
        // Si n es menor a deu es una unitat per tant pasa a la funcio de unitats.
        if (n < 10) return unitats(n);

        //cast a (int) perque funcioni amb el switch
        switch ((int) n) {
            //pasa el int n a String de el numero escrit amb catala.
            case 10:
                return "deu";
            case 11:
                return "onze";
            case 12:
                return "dotze";
            case 13:
                return "tretze";
            case 14:
                return "catorze";
            case 15:
                return "quinze";
            case 16:
                return "setze";
            case 17:
                return "disset";
            case 18:
                return "divuit";
            case 19:
                return "dinou";
            default:
                break;
        }
        return null;
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
        boolean booltrilió = false;
        boolean trilionsBool = false;
        boolean stringNull = false;
        if (ar[0].equals("menys")) { //es negatiu si el primer caracter es menys.
            positiu = false;
            s = s.substring(6); //si es negatiu elimina els 6 primer caracters que es el que ocupa el menys
        }
        if (s.contains("mil") || s.contains("milió") || s.contains("milions") || s.contains("bilió") ||
                s.contains("bilions") || s.contains("trilió") || s.contains("trilions")) {

            for (int i = ar.length - 1; i >= 0; i--) {
                s = ar[i];
                // res = identificarWords(s, res);
                if (s.equals("")) {
                    stringNull=true;
                    s = ar[i+1];
                }
                if (s.equals("mil")) {
                    milBoolean = true;
                    if (i == 0 && milionsBool == false) {
                        //si es la darrera posicio, es mil.
                        res += 1000;
                    } else if (i == 0 && milionsBool == true) {
                        //casos especials, que com mil milions , el darrer valor desde dreta cap esquerra <--
                        // milioBool esta activat.
                        if (res < 1_000) {
                            //si el resultat actual es mes petit que mil
                            //afegim mil
                            res += 1_000;
                        }
                        //multiplicam el resultat actual per mil
                        res *= 1_000_000;
                    }
                    continue;
                } else if (s.equals("milió")) {
                    milioBoolean = true;
                    //res =1_000_000;
                    continue;
                } else if (s.equals("milions")) {
                    //activa el boolea de els milions
                    milionsBool = true;
                    //Desactiva el boolean de els milers
                    milBoolean = false;
                    continue;
                } else if (s.equals("bilió")) {
                    milionsBool = false;
                    milBoolean = false;
                    //activa el boolea de el bilió
                    bilioBool = true;
                    continue;

                } else if (s.equals("bilions")) {
                    //activa el boolea de el bilions
                    boolBilions = true;
                    //posam a false els milions i milers
                    milionsBool = false;
                    milBoolean = false;
                    continue;
                } else if (s.equals("trilió")) {
                    // Desactiva els booleans de els mil,milions
                    milionsBool = false;
                    milBoolean = false;
                    bilioBool = false;
                    //activa el boolea de el trilió
                    booltrilió = true;
                    continue;
                } else if (s.equals("trilions")) {
                    // Desactiva els booleans de els mil,milions

                    milionsBool = false;
                    milBoolean = false;
                    bilioBool = false;
                    boolBilions = false;
                    //activa el boolea d'el trilions
                    trilionsBool = true;
                    continue;
                }


                if (milBoolean == true) {
                    long resTemp = res; //guarda el resultat de antes de arribar a mil, de dreta a esquerra
                    res = 0; //per poder multiplicar per mil el següent nombre
                    res = identificarWords(s, res);
                    res *= 1000; //pasam la cantidad que ocupa el miler a long es a dir el resultat de el nombre
                    // escrit despres de la paraula mil * 1000.
                    if (milionsBool == true) {
                        res *= 1_000_000;
                    } else if (boolBilions) {
                        //per si son mil x bilions.
                        res *= 1_000_000_000_000L;
                    }
                    res += resTemp;
                    // milBoolean= false;
                } else if (milioBoolean == true) {
                    milBoolean = false;
                    long resTemp = res;
                    res = 0;
                    res = identificarWords(s, res);
                    res *= 1_000_000;
                    res += resTemp;
                } else if (milionsBool) {
                    System.out.println("ha entrat.");
                    milBoolean = false;
                    long resTemp = res;
                    res = 0;
                    res = identificarWords(s, res);
                    res *= 1_000_000;
                    res += resTemp;
                } else if (bilioBool) {
                    milionsBool = false;
                    long resTemp = res;
                    res = 0;
                    res = identificarWords(s, res);
                    //multiplica per un bilió
                    res *= 1_000_000_000_000L;
                    res += resTemp;

                } else if (boolBilions) {
                    milionsBool = false;
                    long resTemp = res;
                    res = 0;
                    res = identificarWords(s, res);
                    //multiplica per un bilió
                    res *= 1_000_000_000_000L;
                    res += resTemp;
                } else if (booltrilió) {
                    boolBilions = false;
                    long resTemp = res;
                    res = 0;
                    res = identificarWords(s, res);
                    //multiplica per un bilió
                    res *= 1_000_000_000_000_000_000L;
                    res += resTemp;
                } else if (trilionsBool) {
                    boolBilions = false;
                    long resTemp = res;
                    res = 0;
                    res = identificarWords(s, res);
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
            case "un", "dos", "tres", "quantre", "cinc", "sis", "set", "vuit", "nou":
                res = unitatsEscrit(s, res);
                break;
            case "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit", "dinou":
                res = unitatsEscrit(s, res);
                break;
            case "vint", "trenta", "quaranta", "cinquanta", "seixanta", "setanta", "vuitanta", "noranta":
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
            res = desena(separaMenorCent[separaMenorCent.length - 2]) + unitatsEscrit(separaMenorCent[separaMenorCent.length - 1], res);
        } else if (s.contains("cents")) {
            String[] centsSepara = s.split("-");
            //Variable temporal per guardar la centena
            long resTemp = 0;
            resTemp = unitatsEscrit(centsSepara[centsSepara.length - 2], resTemp);//TODO: ALERTA ANTES ESTABA AMB += (POSIBLE FALLO FUTUR HEM DE CONTROLAR)
            //la unitat de la centena se multiplica per cent per convertirse en centena.
            resTemp *= 100;
            //se suma el resTemp amb el resultat general i la suma es el nou res
            res += resTemp;
        } else {
            //res += identificarWords(s, res);
            return res;
        }

        return res;
    }

    private static long unitatsEscrit(String s, long res) {

        switch (s) {
            case "zero" -> res += 0;
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

    private static long operacio(long valor1, long valor2, String oper) {
        long resultat = 0;
        switch (oper) {
            case "menys":
                resultat = valor1 - valor2;
                break;

            case "més":
                resultat = valor1+valor2;
                break;
            case "dividit":
                resultat = valor1/valor2;

                break;

            case "per":
                resultat = valor1*valor2;
                break;
            default:
                break;
        }
        return resultat;
    }
}


