import java.io.*;
public class EscribirFichTexto {
    public static void main(String[] args) throws IOException {

        //1.- Declarar fichero
        File fichero = new File(".\\ficheros\\FichTexto.txt");
        //2.- Crear el flujo de salida
        FileWriter fic = new FileWriter(fichero);
        //3.- Creamos cadena que escribiremos en el fichero "FichTexto.txt"
        String cadena ="Esto es una prueba con FileWriter";
        //4.- En este caso iremos escribiendo carácter a carácter
        char[] cad = cadena.toCharArray();//convierte un String en array de caracteres
        //5.- Ya con cada caracter guardado en el array, vamos de uno en uno escribiéndolos
        for(int i=0; i<cad.length; i++){

            fic.write(cad[i]);  //se va escribiendo un carácter
        }

        fic.append('*'); //añadir al final un * --> así comprobamos que funciona append (no es necesario)
        //6.- Cerramos flujo de salida
        fic.close();    //
    }
}