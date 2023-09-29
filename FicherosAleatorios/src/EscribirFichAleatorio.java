import java.io.*;

public class EscribirFichAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File(".//ficheros//AleatorioEmple.dat");
        //Declaramos el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        //arrays con los datos
        //Apellidos
        String arrayApellido[] = {"SUAREZ", "LOPEZ", "ETXEBERRIA", "CASTILLO", "AGIRRE", "PEREZ", "ALVAREZ"};

        //Departamentos
        int dep[] = {10,20,10,10,30,30,20};

        //Salarios
        Double salario[]={1000.45, 2400.60, 3000.0, 1500.50, 2200.0, 1400.65,2000.0};

        StringBuffer buffer = null; //buffer para almacenar el apellido
        int n = arrayApellido.length; //número de elementos del array (por ej. elementos del apellido)

        for (int i = 0; i<n; i++){
            file.writeInt(i+1); //Para identificar al empleado, necesario empezar a partir del 1 (primer caso: 0+1=1)

            buffer = new StringBuffer(arrayApellido[i]);
            buffer.setLength(10); //Dejamos 10 caracteres para el apellido
            //buffer.toString se usa para decodificar el string
            file.writeChars(buffer.toString()); //Insertamos el apellido
            //file.writeUTF(arrayApellido[i]); //--> No estaría bien, no escribe el número de bytes que deseamos
            file.writeInt(dep[i]); //Insertamos el departamento
            file.writeDouble(salario[i]); //Insertamos salario

        }

        file.close();
    }
}

