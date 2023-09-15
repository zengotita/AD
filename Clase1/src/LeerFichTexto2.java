import java.io.*;

public class LeerFichTexto2   {
    public static void main(String[] args) throws IOException {
        //Directorio Windows
        //File fichero = new File("C:\\Users\\Hezitzaile\\Desktop\\prueba2.txt");
        //Directorio OSX
        File fichero = new File("Clase1/src/Prueba.txt");

        //declarar fichero
        FileReader fic = new FileReader(fichero); //crear el flujo de entrada

        char b[] = new char[10];
        while ((fic.read(b)) != -1){
        System.out.println(b);
        }

        fic.close(); //cerrar fichero
    }

}
	