package Probas;

import java.util.Scanner;

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
            if (negatiu) {
                resultat = "Menys " + resultat;
            }
            resultat = capitalitzar(resultat);
            return resultat;
        }

        private static String escriuLletres(long n) {
            if (n == 0) return "Zero";
            if (n < 20) return menor20(n);
            if (n < 100) return desenes(n);
            if (n < 1000) return centenes(n);
            if (n < 1_000_000) return milers(n, 1000, "mil");
            if (n < 1_000_000_000) return milers(n, 1_000_000, "milió");
            if (n < 1_000_000_000_000L) return milers(n, 1_000_000_000, "bilió");
            if (n < 1_000_000_000_000_000_000L) return milers(n, 1_000_000_000_000L, "trilió");
            return "";
        }

        private static String milers(long n, long divisor, String unit) {
            long quotient = n / divisor;
            long remainder = n % divisor;

            if (quotient == 1) {
                return unit + " " + escriuLletres(remainder);
            } else {
                String resultat = escriuLletres(quotient) + " " + unit;
                if (remainder != 0) {
                    resultat += " " + escriuLletres(remainder);
                }
                return resultat;
            }
        }

        private static String menor20(long n) {
            if (n == 1) return "Un";
            if (n == 2) return "Dos";
            if (n == 3) return "Tres";
            if (n == 4) return "Quatre";
            if (n == 5) return "Cinc";
            if (n == 6) return "Sis";
            if (n == 7) return "Set";
            if (n == 8) return "Vuit";
            if (n == 9) return "Nou";
            if (n == 10) return "Deu";
            if (n == 11) return "Onze";
            if (n == 12) return "Dotze";
            if (n == 13) return "Tretze";
            if (n == 14) return "Catorze";
            if (n == 15) return "Quinze";
            if (n == 16) return "Setze";
            if (n == 17) return "Dessete";
            if (n == 18) return "Divuite";
            if (n == 19) return "Dinou";
            return "";
        }

        private static String desenes(long n) {
            long desena = n / 10;
            long resta = n % 10;

            String resultat = "";

            if (desena == 2) resultat = "Vint";
            else if (desena == 3) resultat = "Trenta";
            else if (desena == 4) resultat = "Quaranta";
            else if (desena == 5) resultat = "Cinquanta";
            else if (desena == 6) resultat = "Seixanta";
            else if (desena == 7) resultat = "Setanta";
            else if (desena == 8) resultat = "Vuitanta";
            else if (desena == 9) resultat = "Noranta";

            if (resta > 0) {
                resultat += "-" + menor20(resta);
            }

            return resultat;
        }

        private static String centenes(long n) {
            long centena = n / 100;
            long resta = n % 100;

            String resultat = "";

            if (centena == 1) resultat = "Cent";
            else if (centena == 2) resultat = "Dos-cents";
            else if (centena == 3) resultat = "Tres-cents";
            else if (centena == 4) resultat = "Quatre-cents";
            else if (centena == 5) resultat = "Cinc-cents";
            else if (centena == 6) resultat = "Sis-cents";
            else if (centena == 7) resultat = "Set-cents";
            else if (centena == 8) resultat = "Vuit-cents";
            else if (centena == 9) resultat = "Nou-cents";

            if (resta > 0) {
                resultat += " " + escriuLletres(resta);
            }

            return resultat;
        }

        private static String capitalitzar(String s) {
            if (s.isEmpty()) return s;
            return Character.toUpperCase(s.charAt(0)) + s.substring(1);
        }

        public static String words(String s) {
            String[] arNumeros = s.split(" ");
            long suma = 0;

            for (String num : arNumeros) {
                if (Character.isDigit(num.charAt(0))) {
                    suma += Long.parseLong(num);
                }
            }

            return say(suma);
        }


    public static String oper(String s) {
        return "";
    }
}


