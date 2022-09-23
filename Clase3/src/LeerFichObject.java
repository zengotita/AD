import java.io.*;

public class LeerFichObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ///////// 1 \\\\\\\\\\
        //Objeto File
        File fichero = new File(".//ficheros//FichPersona.dat");
        //Flujo de entrada
        FileInputStream filein = new FileInputStream(fichero);
        //Conecta el flujo de bytes al flujo de datos
        ObjectInputStream objectIS = new ObjectInputStream(filein);

        ///////// 2 \\\\\\\\\\
        try {
            while (true) {
                //Leemos una persona, pero debemos hacer casting en readObject
                Persona persona = (Persona) objectIS.readObject();
                //No podemos utilizar println de esta manera, así que utilizamos %n para saltos de línea
                // %s --> String
                // %d --> Int
                //Podemos usar los getters para sacar por pantalla los atributos
                System.out.printf("Nombre: %s, Edad: %d %n", persona.getNombre(), persona.getEdad());
            }
        }
        //Con while(true) llegará un momento que "salga" con EOFException
        catch (EOFException eo) {
            System.out.println("Fin de lectura");
        }
        /////////*** 2 ***\\\\\\\\\\
        //Mismo paso pero con el método available
        //System.out.println(objectIS.available());
        /*try {
            while (objectIS.available() < 0) {

                Persona persona = (Persona) objectIS.readObject();
                System.out.printf("Nombre: %s, Edad: %d %n", persona.getNombre(), persona.getEdad());
            }
        }
        catch (EOFException eo) {
            System.out.println("Fin de lectura");
        }
*/
        ///////// 3 \\\\\\\\\\
        //Cerramos el flujo de entrada
        objectIS.close();
    }
}
