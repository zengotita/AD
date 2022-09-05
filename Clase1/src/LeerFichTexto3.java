import java.io.*;

public class LeerFichTexto3 {
    public static void main(String[] args) {
        try {
            BufferedReader fichero = new BufferedReader(new FileReader("C:\\Users\\Hezitzaile\\Desktop\\Prueba2.txt"));

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