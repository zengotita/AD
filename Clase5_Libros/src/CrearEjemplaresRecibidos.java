import java.io.*;

public class CrearEjemplaresRecibidos {

    public static void main(String[] args) throws Exception {
        FileOutputStream foEjemplares = new FileOutputStream("EjemplaresRecibidos.DAT");
        ObjectOutputStream ooEjemplares = new ObjectOutputStream(foEjemplares);
        int ejemplares = 0;
        do {
            System.out.print("Introduce el Isbn del libro: ");
            String codigo = Utilidades.leerCadena();
            do {
                System.out.print("Introduce el numero de ejemplares recibidos: ");
               ejemplares = Utilidades.leerEntero();
            } while (ejemplares <= 0);

            Ejemplar ejemplaresLibro = new Ejemplar(codigo, ejemplares);
            ooEjemplares.writeObject(ejemplaresLibro);
        } while (HayMasLibros());

        ooEjemplares.writeObject(null);
        ooEjemplares.close();
    }

    public static boolean HayMasLibros() {
        System.out.println("¿Desea introducir copias de otro libro(S/N)?");
        char respuesta = Utilidades.leerCaracter();

        while (respuesta != 'S' && respuesta != 's'
                && respuesta != 'N' && respuesta != 'n') {
            System.out.println(
                    "El caracter introducido no es valido, vuelve a introducirlo(S / N)");
            respuesta = Utilidades.leerCaracter();
        }
        return (respuesta == 'S' || respuesta == 's');
    }
}
