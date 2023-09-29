import java.io.*;

public class LeerFichTexto2   {
    public static void main(String[] args) throws IOException {
        //Directorio Windows
        //File fichero = new File("C:\\Users\\Hezitzaile\\Desktop\\prueba2.txt");
        //Directorio OSX
        File fichero = new File("//Users//jokin//Documents//Egibide//AD//Prueba2.txt");

        //declarar fichero
        FileReader fic = new FileReader(fichero); //crear el flujo de entrada

        int i;

        char b[] = new char[5];
        while ((i = fic.read(b)) != -1){
        System.out.println(b);
        }

        fic.close(); //cerrar fichero
    }

}
	