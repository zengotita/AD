import java.io.*;

public class CrearFicheroConcesionario {

    public static void main(String[] args) throws Exception {
        FileOutputStream foAutomoviles = new FileOutputStream(".\\ficheros\\Deposito.DAT");
        ObjectOutputStream ooAutomoviles = new ObjectOutputStream(foAutomoviles);
        do {
            System.out.print("Introduce la marca del coche: ");
            String marca = Utilidades.leerCadena();
            System.out.print("Introduce la potencia del coche: ");
            int potencia = Utilidades.leerEntero();
            System.out.print("Introduce su precio: ");
            int precio = Utilidades.leerEntero();
            Automovil coche = new Automovil(marca, potencia, precio);
            ooAutomoviles.writeObject(coche);
        } while (HayMasCoches());

        ooAutomoviles.writeObject(null);
        ooAutomoviles.close();
    }

    public static boolean HayMasCoches()
    {
        System.out.println("¿Desea introducir otro coche(S/N)?");
        char respuesta = Utilidades.leerCaracter();

        while (respuesta != 'S' && respuesta != 's' &&
                respuesta != 'N' && respuesta != 'n')
        {
            System.out.println("El caracter introducido no es valido,"
                    + "           vuelve a introducirlo(S / N)");
            respuesta = Utilidades.leerCaracter();
        }
        return (respuesta == 'S' || respuesta == 's');
    }
}
