import java.io.*;

public class EscribirFichData {
    public static void main (String[] args) throws IOException {
        //1.- Declarar fichero
        File fichero = new File (".\\ficheros\\FichData.dat");
        //2.- Crear el flujo de salida
        FileOutputStream fileout = new FileOutputStream(fichero);
        //3.- Inicializar clase para escribir datos primitivos: DataOutputStream
        DataOutputStream dataOS = new DataOutputStream(fileout);

        //4.- Creamos cadena y edades que escribiremos en el fichero "FichTexto.dat"
        String nombres[] = {"Ana", "Luis", "Alicia", "Pedro", "Manuel", "María", "Sara", "Andrés", "Silvia"}    ;
        int edades[] = {15, 16, 17, 16, 14, 15, 17, 18, 14};

        //5.- Escribiendo nombres y edades con DataOutputStream
        for (int i = 0; i<edades.length; i++) {
            dataOS.writeUTF(nombres[i]); //5.1.- Escribe el nombre con el método writeUTF --> String
            dataOS.writeInt(edades[i]); //5.2.- Escribe la edad con el método writeInt--> Int
        }
        //6.- Cerramos flujo de salida
        dataOS.close(); //hay que cerrarlo
    }
}