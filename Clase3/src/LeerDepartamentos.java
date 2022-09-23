import java.io.*;

public class LeerDepartamentos {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Objeto File
        File fichero = new File(".//ficheros//Departamentos.dat");
        //Flujo de entrada
        FileInputStream filein = new FileInputStream(fichero);
        //Conecta el flujo de bytes al flujo de datos
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        try {
            while (true) {
                //Leemos una persona, pero debemos hacer casting en readObject
                Departamento departamento = (Departamento) dataIS.readObject();
                //No podemos utilizar println de esta manera, así que utilizamos %n para saltos de línea
                // %s --> String
                // %d --> Int
                System.out.printf("Nombre dept.: %s, Número dept.: %d, Localidad: %s %n", departamento.getNombre(), departamento.getDep(), departamento.getLoc());
            }
        } catch (EOFException eo) {
            System.out.println("Fin de lectura");
        }
        System.out.println("=======================================================");
        dataIS.close(); //Cerramos el flujo de entrada
    }
}