import java.io.*;

public class SeleccionarCochesPorPrecioMedioYPotencia {

    public static void main(String[] args) throws Exception {
        Automovil[] almacen = new Automovil[100];
        double precioMedio = 0;
        int potenciaSeleccionada = 0;
        int i = 0;

        do {
            System.out.print("Introducir la potencia a seleccionar: ");
            potenciaSeleccionada = Utilidades.leerEntero();
        } while (potenciaSeleccionada <= 0);

        FileInputStream fiAutomoviles = new FileInputStream(".\\ficheros\\Deposito.DAT");

        ObjectInputStream oiAutomoviles = new ObjectInputStream(fiAutomoviles);

        Automovil coche = (Automovil) oiAutomoviles.readObject();

        while (coche != null) {
            if (coche.getPotencia() == potenciaSeleccionada) {
                almacen[i] = new Automovil(coche.getMarca(),
                        coche.getPotencia(),
                        coche.getPrecio());
                precioMedio = precioMedio + coche.getPrecio();
                i++;
            }
            coche = (Automovil) oiAutomoviles.readObject();
        }

        oiAutomoviles.close();

        precioMedio = precioMedio / i;
        for (int j = 0; j < i; j++) {
            if (almacen[j].getPrecio() <= precioMedio) {
                almacen[j].mostrar();
            }
        }
    }
}