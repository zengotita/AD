import java.io.*;

public class LeerFichTexto3 {
    public static void main(String[] args) {
        try {
            //Directorio Windows
            //BufferedReader fichero = new File("C:\\Users\\Hezitzaile\\Desktop\\prueba2.txt");
            //Directorio OSX
            BufferedReader fichero = new BufferedReader(new FileReader("//Users//jokin//Documents//Egibide//AD//Prueba2.txt"));

            String linea;

            while ((linea = fichero.readLine()) != null) {
                System.out.println(linea);
            }

            fichero.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException io) {
            System.out.println("Error de E/S");
        }
    }
}