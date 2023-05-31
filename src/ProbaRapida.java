import java.util.Arrays;
import java.util.Scanner;

public class ProbaRapida {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix un nombre per pasar a escrit en catala: ");
        String s = scanner.nextLine();
        System.out.println(words(s));

    }
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
        resultat = capitalitzar(resultat);
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

    private static String capitalitzar(String numero) {
        char majuscula = numero.toUpperCase().charAt(0);
        String restaNum = numero.substring(1);
        numero = majuscula + restaNum;
        return numero;
    }

    private static String menor20(long n) {
        if (n < 10) return unitats(n);
        if (n == 10) return "deu";
        if (n == 11) return "onze";
        if (n == 12) return "dotze";
        if (n == 13) return "tretze";
        if (n == 14) return "catorze";
        if (n == 15) return "quinze";
        if (n == 16) return "setze";
        if (n == 17) return "disset";
        if (n == 18) return "divuit";
        if (n == 19) return "dinou";
        return null;
    }

    public static long words(String s) {

        s = s.toLowerCase();
        String[] arNumeros = s.split(" ");
        System.out.println(Arrays.toString(arNumeros));
        boolean positiu = true;
        if (arNumeros[0].equals("menys")) {
            positiu = false;
        }
        boolean bolMil=false;
        boolean bolMilio= false;
        boolean bolBilio= false;
        boolean bolTrilio= false;
        boolean numMil = false;
        boolean numMilio = false;
        boolean numMilMilio = false;
        boolean numBilio = false;
        long numeros = 0;
        //  long numeroTemporal = 0;
        for (int cela = arNumeros.length-1; cela >= 0; cela--) {
            numeros += escriuNumeros(arNumeros[cela], bolMil,bolMilio,bolBilio,bolTrilio,numMil,numMilMilio,numMilio,numBilio);
            if(numeros>=1000 && numeros < 1_000_000){
                if (bolMil==true){
                    numMil=true;
                }
                bolMil=true;
            }
            if(numeros>=1_000_000 && numeros < 1_000_000_000){
                if (bolMilio==true){
                    numMilio=true;
                }
                bolMil=false;
                bolMilio=true;
            }
            if(numeros>=1_000_000_000 && numeros < 1_000_000_000_000L){
                if (bolMilio==true){
                    numMilio=true;
                }
                bolMil=true;
                bolMilio=true;
            }
        }
//        for (int cela = 0; cela < arNumeros.length ; cela++) {
//            numeroTemporal += escriuNumeros(arNumeros[cela]);

//            if (numeroTemporal==1_000){
//                if(numeros == 0){
//                    numeros = 1;
//                }
//                numeroTemporal= numeros*1000;
//                numeros=0;
//            }
//            if (numeroTemporal==1_000_000){
//                if(numeros == 0){
//                    numeros = 1;
//                }
//                numeroTemporal= numeros*1_000_000;
//            numeros=0;
//            }
//            numeros += numeroTemporal;
//            numeroTemporal = 0;
//        }

        if (positiu == false) numeros = -numeros;
        return numeros;
    }

    private static long escriuNumeros(String sNum,boolean bolMil, boolean bolMilio, boolean bolBilio, boolean bolTrilio, boolean numMil, boolean numMilio, boolean numMilMilio, boolean numBilio) {
        long numeros = 0;
        if (sNum.equals("zero")) {
            numeros = 0;
        }
        if (sNum.equals("mil")) {
            return 1000;
        }
        else if(sNum.equals("milió")|| sNum.equals("milions")){
            return 1_000_000;
        }
        else if(sNum.equals("bilió")|| sNum.equals("bilions")){
            return 1_000_000_000_000L;
        }
        else if(sNum.equals("trilió")|| sNum.equals("trilions")){
            return 1_000_000_000_000_000_000L;
        }
        if (bolMil==false && bolMilio==false && bolBilio==false && bolTrilio==false){ // numeros menors de mil.
            return triaNumeros(sNum);
        }
        if (bolMil==true && bolMilio==false && bolBilio==false && bolTrilio==false){ // fins 999_999.
            if (numMil == true) {
                return triaNumeros(sNum) * 1000;
            }
            return triaNumeros(sNum) * 1000 -1000;
        }
        if (bolMil==false && bolMilio==true && bolBilio==false && bolTrilio==false){ //  més de 1_000_000
            if (numMilio == true) {
                return triaNumeros(sNum) * 1_000_000;
            }
            return triaNumeros(sNum) * 1_000_000 -1_000_000;
        }
        if (bolMil==true && bolMilio==true && bolBilio==false && bolTrilio==false){
            if (numMilMilio == true) {
                return triaNumeros(sNum) * 1_000_000_000;
            }
            return triaNumeros(sNum) * 1_000_000_000 -1_000_000_000;
        }





        return numeros;
    }

    private static long triaNumeros(String sNum) {
        if (sNum.equals("un") || sNum.equals("dos") || sNum.equals("tres") || sNum.equals("quatre") || sNum.equals("cinc") || sNum.equals("sis") || sNum.equals("set") || sNum.equals("vuit") || sNum.equals("nou")) {
            return unitat(sNum);
        } else if (sNum.equals("deu") || sNum.equals("onze") || sNum.equals("dotze") || sNum.equals("tretze") || sNum.equals("catorze") || sNum.equals("quinze") || sNum.equals("setze") || sNum.equals("disset") || sNum.equals("divuit") || sNum.equals("dinou")) {
            return menors20(sNum);
        } else if (sNum.equals("vint") || sNum.equals("trenta") || sNum.equals("quaranta") || sNum.equals("cinquanta") || sNum.equals("seixanta") || sNum.equals("setanta") || sNum.equals("vuitanta") || sNum.equals("noranta")) {
            return desena(sNum);
        } else if (sNum.contains("-i-")) {
            String[] separaVints = sNum.split("-i-");
            //   System.out.println(Arrays.toString(separaVints));
            return 20 + unitat(separaVints[separaVints.length - 1]);
        } else if (sNum.contains("-") && !sNum.contains("cents")) {
            String[] separaDesena = sNum.split("-");
            // System.out.println(Arrays.toString(separaDesena));
            return desena(separaDesena[separaDesena.length - 2]) + unitat(separaDesena[separaDesena.length - 1]);
        } else if (sNum.equals("cent")) {
            return 100;
        } else if (sNum.contains("cents")) {
            String[] separaCentena = sNum.split("-");
            // System.out.println(Arrays.toString(separaCentena));
            return unitat(separaCentena[separaCentena.length - 2]) * 100;
        }
        return 0;
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

    private static long menors20(String s) {
        if (s.equals("deu")) {
            return 10;
        } else if (s.equals("onze")) {
            return 11;
        } else if (s.equals("dotze")) {
            return 12;
        } else if (s.equals("tretze")) {
            return 13;
        } else if (s.equals("catorze")) {
            return 14;
        } else if (s.equals("quinze")) {
            return 15;
        } else if (s.equals("setze")) {
            return 16;
        } else if (s.equals("disset")) {
            return 17;
        } else if (s.equals("divuit")) {
            return 18;
        } else if (s.equals("dinou")) {
            return 19;
        }
        return 0;
    }

    private static long unitat(String s) {
        long numeros = 0;

        if (s.equals("un")) {
            numeros = 1;
        } else if (s.equals("dos")) {
            numeros = 2;
        } else if (s.equals("tres")) {
            numeros = 3;
        } else if (s.equals("quatre")) {
            numeros = 4;
        } else if (s.equals("cinc")) {
            numeros = 5;
        } else if (s.equals("sis")) {
            numeros = 6;
        } else if (s.equals("set")) {
            numeros = 7;
        } else if (s.equals("vuit")) {
            numeros = 8;
        } else if (s.equals("nou")) {
            numeros = 9;
        }
        return numeros;
    }

    public static String oper(String s) {
        return "";
    }
}