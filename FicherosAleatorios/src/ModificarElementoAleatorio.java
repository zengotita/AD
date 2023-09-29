import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ModificarElementoAleatorio {
    public static void main(String[] args) throws IOException {

        File fichero = new File(".//ficheros//AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int id_empleado = 5; //Ejemplo de un identificador

        //Variables a declarar: datos del empleado
        int id, departamento, posicion;
        double salario;
        char apellido[] = new char[10];

        posicion = (id_empleado - 1)*36; //Porque cada empleado ocupa 36 bytes

        if (posicion >= file.length()){ //Si nos pasamos de largo, es que no existe el empleado
            System.out.println("NO EXISTE EL EMPLEADO");
        }
        else{ //Sí que existe o puede existir

            file.seek(posicion+4+20);
            //En este ejemplo se cambia el número del departamento
            file.writeInt(11);

        }
        file.close(); //Cerramos fichero
    }
}
