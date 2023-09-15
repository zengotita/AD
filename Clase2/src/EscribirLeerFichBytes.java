import java.io.*;

public class EscribirLeerFichBytes {
    public static void main(String[] args) throws IOException {
        //1. Clase file
        File fichero = new File("Clase2/src/FichBytes.dat");
        //2. Creamos flujo de salida hacia el fichero
        FileOutputStream fileout = new FileOutputStream(fichero);
        //3. Crea flujo de entrada
        FileInputStream filein = new FileInputStream(fichero);
        int i;
        //4. Escribir los datos del fichero con fileout (FileOutputStream)
        for (i=1; i<100; i++) {
            fileout.write(i); //4.1 Escribimos datos en el flujo de salida
        }
        fileout.close(); //4.2 Cerramos flujo/stream de salida (filein)

        //5. visualizar los datos del fichero con filein (FileInputStream)
        while ((i = filein.read()) != -1) { //5.1 Leemos datos del flujo de entrada
            System.out.println(i);
        }
        filein.close(); //5.2 Cerramos flujo/stream de entrada (fileout)
    }
}