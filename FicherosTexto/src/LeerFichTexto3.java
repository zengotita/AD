import java.io.*;

public class LeerFichTexto3 {
    public static void main(String[] args) {
        try {
            //Directorio Windows
            //BufferedReader fichero = new File("C:\\Users\\Hezitzaile\\Desktop\\prueba2.txt");
            //Directorio OSX
            File fichero = new File("//Users//jokin//Documents//Egibide//AD//Prueba2.txt");
            FileReader fic = new FileReader(fichero); //crear el flujo de entrada
            BufferedReader fb = new BufferedReader(fic);

            String linea;

            while ((linea = fb.readLine()) != null) {
                System.out.println(linea);
            }

            fb.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException io) {
            System.out.println("Error de E/S");
        }
    }
}