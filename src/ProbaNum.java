import java.util.Scanner;

public class ProbaNum {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int num, dec, uni;
        String[] unidades = {"cero" , "uno" ,"dos" , "tres" , "cuatro" , "cinco" , "seis" , "siete" , "ocho" , "nueve" };
        String[] decenas = { "diez" , "veinte" , "treinta" , "cuarenta" , "cincuenta" , "sesenta" , "setenta"
                , "ochenta" , "noventa" };
        System.out.println("Ingresa un numero del 1 al 99");
        num = leer.nextInt();
        dec = num / 10;
        uni = num % 10;
        System.out.println((num/10)+"and"+num%10);
        System.out.println("El numero " + num + " es " + decenas[dec-1] + " y " + unidades[uni]);

        if (num >= 11 && num <= 15) {
            switch (num) {
                case 11:
                    System.out.println("once");
                    break;
                case 12:
                    System.out.println("doce");
                    break;
                case 13:
                    System.out.println("trece");
                    break;
                case 14:
                    System.out.println("catorce");
                    break;
            }
            if (uni == 0) {
                switch (num) {
                    case 10:
                        System.out.println("diez");
                        break;
                    case 20:
                        System.out.println("veinte");
                        break;
                    case 30:
                        System.out.println("treinta");
                        break;
                    case 40:
                        System.out.println("cuarenta");
                        break;
                    case 50:
                        System.out.println("cincuenta");
                        break;
                    case 60:
                        System.out.println("sesenta");
                        break;
                    case 70:
                        System.out.println("setenta");
                        break;
                    case 80:
                        System.out.println("ochenta");
                        break;
                    case 90:
                        System.out.println("noventa");
                        break;
                }
            }

        }
    }
}