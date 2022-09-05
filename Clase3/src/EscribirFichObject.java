import java.io.*;

public class EscribirFichObject {
    public static void main(String[] args) throws IOException {
        ///////// 1 \\\\\\\\\\
        //Objeto File
        File fichero = new File(".\\ficheros\\FichPersona.dat");
        //Flujo de salida
        FileOutputStream fileout = new FileOutputStream(fichero);
        //Conecta el flujo de bytes al flujo de datos
        ObjectOutputStream objectOS = new ObjectOutputStream(fileout);

        ///////// 2 \\\\\\\\\\
        String nombres[] = {"Ana", "Luis", "Alicia", "Pablo", "Manuel", "Silvia", "Sara", "Markel", "Nora"};
        int edades[] = {15, 16, 17, 16, 14, 15, 17, 18, 14};

        ///////// 3 \\\\\\\\\\
        //Recorremos cualquiera de los dos arrays, ya que tienen la misma longitud
        //Por cada iteración creamos un objeto de la clase Persona
        //Cada objeto de la clase Persona se guarda en el fichero con writeObject
        for (int i = 0; i < edades.length; i++) {
            Persona persona = new Persona(nombres[i], edades[i]);
            objectOS.writeObject(persona); //escribimos la persona en el fichero
        }
        ///////// 4 \\\\\\\\\\
        //Cerramos stream de salida --> el último
        objectOS.close();
    }
}