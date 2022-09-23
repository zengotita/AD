import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AddElementoAleatorio {
    public static void main(String[] args) throws IOException {

        //ESTE EJERCICIO SE PUEDE MEJORAR LEYENDO EL ULTIMO ID UTILIZADO Y SUMANDO 1

        File fichero = new File(".//ficheros//AleatorioEmple.dat");
        //Declaramos el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        //arrays con los datos
        //Apellidos
        String apellido[] = {"NUEVO"};

        //Departamentos
        int dep[] = {22};

        //Salarios
        Double salario[]={9999.0};

        StringBuffer buffer = null; //buffer para almacenar el apellido
        int n = apellido.length; //número de elementos del array

        //Nos situamos al final del fichero
        long f_final = file.length();
        file.seek(f_final);

        //Un id de ejemplo
        int i = 8;
        file.writeInt(i+1); //Para identificar al empleado, necesario empezar a partir del 1 (primer caso: 0+1=1)

        //Usamos StringBuffer por tema de codificación
        buffer = new StringBuffer(apellido[0]);
        buffer.setLength(10); //Dejamos 10 caracteres para el apellido

        file.writeChars(buffer.toString()); //Insertamos el apellido
        //file.writeUTF(apellido[i]); --> No estaría bien, no escribe el número de bytes que deseamos
        file.writeInt(dep[0]); //Insertamos el departamento
        file.writeDouble(salario[0]); //Insertamos salario
        //String s = String.format("Texto %d", 3);
        file.close();
    }
}
