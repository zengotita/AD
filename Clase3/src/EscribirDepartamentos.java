import java.io.*;

public class EscribirDepartamentos {
    public static void main(String[] args) throws IOException {
        //Objeto File
        File fichero = new File(".\\ficheros\\Departamentos.dat");
        //Flujo de salida
        FileOutputStream fileout = new FileOutputStream(fichero);
        //Conecta el flujo de bytes al flujo de datos
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

        //Nombres
        String departamentos[] = {"Compras", "Ventas", "Finanzas", "Producción", "Almacén"};
        //Localidades
        String localidades[] = {"Vitoria", "Bilbao", "Donostia", "Agurain", "Iruña"};
        //Número de departamento
        int numerodept[] = {1, 2, 3, 4, 5};

        for (int i = 0; i < numerodept.length; i++) {
            Departamento departamento = new Departamento(departamentos[i], numerodept[i], localidades[i]);
            dataOS.writeObject(departamento);
        }
        dataOS.close();
    }
}
