import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class NumbersCat {
    public static void main(String[] args) {
        //Els números de 0 al 19 tenen noms únics. Aquests són: zero, un, dos, tres, quatre,
        //cinc, sis, set, vuit, nou, deu, onze, dotze, tretze, catorze, quinze, setze, disset, divuit i
        //dinou.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix un nombre per pasar a escrit en catala: ");
        long n = scanner.nextInt();
        System.out.print(say(n));




/*
        System.out.println("Introdueix un nombre per pasar a escrit en catala: ");
        String s = scanner.nextLine();
        System.out.println(words(s));

 */

    }
    public static String say(long n) {

        boolean positiu = true;
        if (0 > n) {
            //feim que el numero sigui positiu. li llevam el menys(-) (Funcio per nombres menors).
            n = -n;
            positiu = false;
        }

        String resultat = escriuLletres(n);
        if (!positiu) {
            //si no es positiu, afegim un "Menys"
            resultat = "Menys " + resultat;
        }
        resultat = capitalLetter(resultat);
        return resultat;
    }

    // Funció per convertir un nombre en lletres
    private static String escriuLletres(long n) {

        if (n == 0) {
            // Cas especial per zero
            return "Zero";
        } else if (n < 10) {
            // Si el nombre és menor que 10, convertim en unitats
            return unitats(n);
        } else if (n < 20) {
            // Si el nombre és menor que 20, utilitzem una llista predefinida per a nombres de 10 a 19
            return menorQueVint(n);
        } else if (n < 30) {
            // Si el nombre és menor que 30, convertim en desenes a lletres
            return desenesALletres(n);
        } else if (n <= 99) {
            // Si el nombre és menor o igual a 99, convertim en desenes a lletres
            return desenesALletres(n);
        } else if (n <= 999) {
            // Si el nombre és menor o igual a 999, convertim en centenes
            return centenes(n);
        } else if (n <= 9999) {
            // Si el nombre és menor o igual a 9999, convertim en milers
            return milers(n);
        } else if (n <= 999999) {
            // Si el nombre és menor o igual a 999999, convertim en milers
            return milers(n);
        } else if (n <= 999_999_999_999L) {
            // Si el nombre és menor o igual a 999999999999, convertim en milions
            return milions(n);
        } else if (n <= 999_999_999_999_999_999L) {
            // Si el nombre és menor o igual a 999999999999999999, convertim en bilions
            return bilionsSay(n);
        } else {
            // Per a nombres més grans, convertim en trilions que es els nombres mes grans que accepta el programa
            return trilions(n);
        }
    }

    // Funció per convertir nombres fins a un trilió
    private static String trilions(long n) {
        // Si el nombre és menor que un trilió, convertim en bilions
        if (n < 999_999_999_999_999_999L) return bilionsSay(n);
        // Cas especial per 1 trilió
        if (n == 1_000_000_000_000_000_000L) {
            return "un trilió";
        } else if (n > 1_000_000_000_000_000_000L && n <= 1_999_999_999_999_999_999L) {
            //Major de un trilio i menor que 2 trilions.
            // Convertim la part trilió i la part bilions restants
            return "un trilió " + bilionsSay(n % 1_000_000_000_000_000_000L);

        } else if (n % 1_000_000_000_000_000_000L == 0) {
            // Convertim la part trilió, afegim "trilions", la part bilions restants i la part milions restants
            return bilionsSay(n / 1_000_000_000_000_000_000L) + " trilions" + bilionsSay(n % 1_000_000_000_000_000_000L) + milions(n % 100_000_000_000_000L);

        } else if (n >= 2_000_000_000_000_000_000L) {
            return bilionsSay(n / 1_000_000_000_000_000_000L) + " trilions " + bilionsSay(n % 1_000_000_000_000_000_000L) + milions(n % 10_000_000_000_000L);
            // Convertim la part trilió, afegim "trilions", la part bilions restants i la part milions restants
        }
        return "";
    }
    private static String bilionsSay(long n) {
        if (n < 999_999_999_999L) {
            // Si el nombre és menor a 999999999999, convertim en milions
            return milions(n);
        } else if (n == 1_000_000_000_000L) {
            // Cas especial per a 1000000000000
            return "un bilió";
        } else if (n >= 1_000_000_000_000L && n <= 1_999_999_999_999L) {
            // Convertim la part del bilió i cridem a la funció milions per a la resta
            return "un bilió " + milions(n % 1_000_000_000_000L);
        } else if (n % 1_000_000_000_000L == 0) {
            // Convertim la part del bilió, cridem a la funció milions per a la resta i cridem a la funció milers per a la part en milers
            return milions(n / 1_000_000_000_000L) + " bilions" +
                    milions(n % 1_000_000_000_000L) + milers(n % 100_000_000);

        } else if (n >= 2_000_000_000_000L && n <= 999_999_999_999_999_999L) {
            // Convertim la part del bilió, cridem a la funció milions per a la resta i
            // cridem a la funció milers per a la part en milers
            return milions(n / 1_000_000_000_000L) + " bilions " + milions(n % 1_000_000_000_000L) +
                    milers(n % 10_000_000L);
        }
        return "";
    }
    private static String milions(long n) {
        if (n < 999999) {
            // Si el nombre és menor a 999999, convertim en milers
            return milers(n);
        } else if (n == 1_000_000) {
            // Cas especial per a 1000000
            return "un milió";
        } else if (n >= 1_000_000 && n <= 1_999_999L) {
            // Convertim la part del milió i cridem a la funció milers per a la resta
            return "un milió " + milers(n % 1_000_000);
        } else if (n % 1_000_000 == 0) {
            // Convertim la part del milió, cridem a la funció milers per a la resta i
            // cridem a la funció centenes per a la part en centenes
            return milers(n / 1_000_000) + " milions" + milers(n % 1_000_000) + centenes(n % 10_000_000);
        } else if (n >= 2_000_000 && n <= 999_999_999_999L) {
            // Convertim la part del milió, cridem a la funció milers per a la resta
            // i cridem a la funció centenes per a la part en centenes
            return milers(n / 1_000_000) + " milions " + milers(n % 1_000_000) + centenes(n % 10_000_000);
        }
        return "";
    }


    // Funció per convertir nombres fins a milers
    private static String milers(long n) {
        // Si el nombre és menor que 100, convertim en desenes a lletres
        if (n < 100) return desenesALletres(n);
        // Si el nombre és menor que 1000, convertim en centenes pasant "n" a la funció centenes
        if (n < 1000) return centenes(n);
        // Cas especial per 1000, ja que si es mes de mil se
        if (n == 1000) {
            return "mil";
        } else if (n <= 1999) {
            //Menor o igual a 1999
            // Convertim la part mil i la part centenes restants
            return "mil " + centenes(n % 1000);
        } else if (n <= 9999) {
            //Menor o igual a 9 999
            if (n % 1000 == 0) {
                // Convertim la part mil, afegim "mil", la part centenes restants
                return unitats(n / 1000) + " mil" + centenes(n % 1000);
            } else {
                // Convertim la part mil, afegim "mil", la part centenes restants
                return unitats(n / 1000) + " mil " + centenes(n % 1000);
            }
        } else if (n < 99_999) {
            // Convertim la part desenes a lletres, afegim "mil", la part centenes restants
            return desenesALletres(n / 1000) + " mil " + centenes(n % 1000);
        } else if (n > 99_999 && n <= 99_9999) {
            if (n % 10_000 == 0 || n % 1000 == 0) {
                // Convertim la part centenes, afegim "mil", la part centenes restants
                return centenes(n / 1000) + " mil" + centenes(n % 1000);
            } else {
                // Convertim la part centenes, afegim "mil", la part centenes restants
                return centenes(n / 1000) + " mil " + centenes(n % 1000);
            }
        }
        return "";
    }

    private static String centenes(long n) {
        if (n < 10) return unitats(n);
        if (n < 100) return desenesALletres(n);
        if (n == 100) return "cent";
        if (n < 200) {
            return "cent " + desenesALletres(n % 100);
        }
        if (n < 1000) {
            if (n % 100 == 0) {
                return unitats(n / 100) + "-cents" + desenesALletres(n % 100);
            } else return unitats(n / 100) + "-cents " + desenesALletres(n % 100);
        }
        //si hi ha un error i no coincideix amb cap opcio torna un String buit
        return "";
    }

    private static String unitats(long n) {

        //cast a (int) perque funcioni amb el switch
        switch ((int) n) {
            //pasa el int n a String de el numero escrit amb catala.
            //cada case fa un return de na unitat a la que correspon
            case 1:
                return "un";
            case 2:
                return "dos";
            case 3:
                return "tres";
            case 4:
                return "quatre";
            case 5:
                return "cinc";
            case 6:
                return "sis";
            case 7:
                return "set";
            case 8:
                return "vuit";
            case 9:
                return "nou";
            default:
                //si hi ha un error i no coincideix amb cap opcio torna un String buit
                return "";
        }

    }

    private static String desenesALletres(long n) {
        //Menor a 10 envia a funcio de unitats
        if (n < 10) return unitats(n);
        if (n < 20) {
            //Si es mes petit que 20 el pasam a la funcio menor20().
            return menorQueVint(n);
        }
        //si es el nombre 20 nomes torna "vint" sense pasar per una funcio
        if (n == 20) return "vint";

        //Nombres que estan a la vintena,excepte el vint
        if (n < 30) {
            return "vint" + "-i-" + unitats(n % 10);
        }
        //Nombres que estan a la trentena
        if (n < 40) {
            if (n == 30) {
                //si es 30
                return "trenta";
            }
            //si no es just trenta escrivim trenta un guio i la unitat
            return "trenta" + "-" + unitats(n % 10);
        }
        //Nombres que estan a la quarantena
        if (n < 50) {
            //cas de 40
            if (n == 40) return "quaranta";
            //si no es just quaranta escrivim quaranta un guio i la unitat
            return "quaranta" + "-" + unitats(n % 10);
        }
        //Nombres que estan a la cinquantena
        if (n < 60) {
            //cas de 50
            if (n == 50) return "cinquanta";
            //si no es just cinquanta escrivim cinquantena un guio i la unitat
            return "cinquanta" + "-" + unitats(n % 10);
        }

        //Nombres que estan a la seixantena
        if (n < 70) {
            if (n == 60) return "seixanta";
            //si no es just seixanta escrivim seixantena un guio i la unitat
            return "seixanta" + "-" + unitats(n % 10);
        }
        //Nombres que estan a la setantena
        if (n < 80) {
            //cas de 70
            if (n == 70) return "setanta";
            //si no es just setanta escrivim setanta un guio i la unitat
            return "setanta" + "-" + unitats(n % 10);
        }
        //Nombres que estan a la vuitantena
        if (n < 90) {
            if (n == 80) return "vuitanta";
            //si no es just vuitanta escrivim vuitanta un guio i la unitat
            return "vuitanta" + "-" + unitats(n % 10);
        }
        //Nombres que estan a la norantena
        if (n < 100) {
            if (n == 90) return "noranta";
            //si no es just noranta escrivim noranta un guio i la unitat
            return "noranta" + "-" + unitats(n % 10);
        }
        //En cas de que no es doni cap cas retorna un String buit.
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

    private static String menorQueVint(long n) {
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
        //En cas de que no es doni cap cas retorna un String buit.
        return "";
    }


    public static long words(String s) {
        // La funció “words” fa l’operació inversa: transforma un String en un número de tipus long.
        s = s.toLowerCase();
        //separa per caracters
        String[] ar = s.split(" ");
        long res = 0;

        boolean positiu = true;
        boolean milBoolean = false;
        boolean milioBoolean = false;
        boolean milionsBool = false;
        boolean bilioBool = false;
        boolean boolBilions = false;
        boolean booltrilió =false;
        boolean trilionsBool = false;
        //es negatiu si el primer caracter es menys.
        if (ar[0].equals("menys")) {
            positiu = false;
            //si es negatiu elimina els 6 primer caracters que es el que ocupa el menys
            s = s.substring(6);
        }
        if (s.contains("mil") || s.contains("milió") || s.contains("milions") || s.contains("bilió") ||
                s.contains("bilions") ||s.contains("trilió") || s.contains("trilions")) {

            for (int i = ar.length-1; i >=0 ; i--) {
                s = ar[i];
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
                    //guarda el resultat de antes de arribar a mil, de dreta a esquerra
                    long resTemp = res;
                    //per poder multiplicar per mil el següent nombre
                    res = 0;
                    res = identificarWords(s, res);
                    //pasam la cantidad que ocupa el miler a long es a dir el resultat de el nombre
                    // escrit despres de la paraula mil * 1000.
                    res *= 1000;
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
            //Si es negatiu pasam el positiu a negatiu.
            res = -res;
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
        } else if (s.equals("vint") || s.equals("trenta") || s.equals("quaranta") || s.equals("cinquanta") ||
                s.equals("seixanta") || s.equals("setanta") || s.equals("vuitanta") || s.equals("noranta")) {
            res = desena(s);
        } else if (s.contains("-") && !s.contains("cents")) {
            //valors menors de 100
            String[] separaMenorCent = s.split("-");
            // agafa la desena i la unitat
            res =desena(separaMenorCent[separaMenorCent.length - 2]) +
                    unitatsEscrit(separaMenorCent[separaMenorCent.length - 1], res);

        } else if (s.contains("cents")) {
            String[] centsSepara = s.split("-");
            //Variable temporal per guardar la centena
            long resTemp =0;
            resTemp = unitatsEscrit(centsSepara[centsSepara.length - 2], resTemp);
            //la unitat de la centena se multiplica per cent per convertirse en centena.
            resTemp *=100;
            //se suma el resTemp amb el resultat general i la suma es el nou res
            res += resTemp;

        } else {
            //guarda el resultat de antes de arribar a mil, de dreta a esquerra
            long resTemp = res;
            //per poder multiplicar per mil el següent nombre
            res = 0;
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

        s = s.toLowerCase();
        //separa per caracters
        String[] ar = s.split(" ");

        boolean numDespresDeOperador = false;

        long valor1 = 0;
        long valor2 = 0;
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
            if (s.equals("menys") || s.equals("més") || s.equals("dividit") || s.equals("per")) {
                // si es un operador amb el proxim nombre se ha de operar
                numDespresDeOperador = true;
                oper = s;
                continue;
            } else {
                //si es un nombre que NO va despres de el operador
                if (!numDespresDeOperador) {
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
                //asigna a valor2 el valor de String numStr2
                valor2 = words(numStr2);
                //asigna a valor1 el valor de String numStr1
                valor1 = words(numStr1);
            }
            //si es un numero mes que va despres de un operador se realitza la operacio
            if (numDespresDeOperador) {
                result = operacio(valor1,valor2, oper);
                //tornam a false el boolea de el numDespresDeOperador
                numDespresDeOperador=false;
                //break;
            }
        }

        return say(result);
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