import java.io.*;

public class LeerFichTexto {
    public static void main(String[] args) throws IOException {
        //Directorio Windows
        //File fichero = new File("C:\\Users\\Hezitzaile\\Desktop\\prueba.txt");
        //Directorio OSX
        File fichero = new File("Clase1/src/Prueba.txt");
        //declarar fichero
        FileReader fic = new FileReader(fichero); //crear el flujo de entrada
        int i;
        while ((i = fic.read()) != -1) //se va leyendo un carácter
            System.out.println((char) i);
        fic.close(); //cerrar fichero
    }
}
