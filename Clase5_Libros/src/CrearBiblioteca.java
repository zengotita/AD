

import java.io.*;

public class CrearBiblioteca {

    public static void main(String[] args) throws Exception {
        FileOutputStream foBiblioteca = new FileOutputStream("Libros.DAT");
        ObjectOutputStream ooBiblioteca = new ObjectOutputStream(foBiblioteca);

        do {
            System.out.print("Introduce el Isbn del libro: ");
            String cod = Utilidades.leerCadena();
            System.out.print("Introduce el titulo: ");
            String tit = Utilidades.leerCadena();
            System.out.print("Introduce el autor: ");
            String aut = Utilidades.leerCadena();
            Libro l = new Libro(cod, tit, aut, false);
            ooBiblioteca.writeObject(l);
        } while (HayMasLibros());

        ooBiblioteca.writeObject(null);
        ooBiblioteca.close();
    }

    public static boolean HayMasLibros() {
        System.out.println("¿Desea introducir otro libro(S/N)?");
        char respuesta = Utilidades.leerCaracter();
        while (respuesta != 'S' && respuesta != 's'
                && respuesta != 'N' && respuesta != 'n')
        {
            System.out.println(
                    "El caracter introducido no es valido,vuelve a introducirlo(S / N)");
            respuesta = Utilidades.leerCaracter();
        }
        return (respuesta == 'S' || respuesta == 's');
    }
}
