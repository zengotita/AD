import java.io.*;

public class LeerFichTexto2   {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\Hezitzaile\\Desktop\\Prueba2.txt");

        //declarar fichero
        FileReader fic = new FileReader(fichero); //crear el flujo de entrada

        int i;

        char b[] = new char[20];
        while ((i = fic.read(b)) != -1){
        System.out.println(b);
        }

        fic.close(); //cerrar fichero
    }

}
	