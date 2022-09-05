import java.io.IOException;
import java.util.Scanner;

public class Utilidades {

    public static String leerCadena() {
        Scanner in = new Scanner(System.in);
        String cadena = in.nextLine();
        return cadena;
    }

    public static int leerEntero() {
        Scanner in = new Scanner(System.in);
        int entero = in.nextInt();
        return entero;
    }

    public static char leerCaracter() {
        Scanner in = new Scanner(System.in);
        char caracter;
        caracter = in.next().charAt(0);
        return caracter;
    }
}
