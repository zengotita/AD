import java.io.*;
public class LeerFichData {
    public static void main(String[] args) throws IOException {

        //1
        File fichero = new File(".\\ficheros\\FichData.dat"); //Fichero escrito con EscribirFichData.java
        FileInputStream filein = new FileInputStream(fichero);
        DataInputStream dataIS = new DataInputStream(filein);

        String n; //Variable que guardará un nombre (string)
        int e; //Variable que guardará un número, correspondiente a la edad (int)

        try {
            while (true) { //Vamos a hacer un bucle infinito. Saldrá con la excepción.
                n = dataIS.readUTF(); //recupera el nombre
                e = dataIS.readInt(); //recupera la edad
                System.out.println("Nombre: " + n + ", edad: " + e);
            }
        }catch (EOFException eo) {}

        //La solución de Ainara de utilizar el método available es también correcta
        /*try {
            while (dataIS.available() > 0 ){
                n = dataIS.readUTF(); //recupera el nombre
                e = dataIS.readInt(); //recupera la edad
                System.out.println("Nombre: " + n + ", edad: " + e);
            }
        }catch (EOFException eo){}
        */
        dataIS.close();  //cerrar stream
    }
}
