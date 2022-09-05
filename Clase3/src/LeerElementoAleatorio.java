import java.io.*;

public class LeerElementoAleatorio {
    public static void main(String[] args) throws IOException {

        File fichero = new File(".\\ficheros\\AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int id_empleado = 5; //Ejemplo de un identificador
        //El id coincide con la posición del empleado, pero no siempre
        //tiene que ser así. Si añadimos otro empleado con otro id
        //y buscamos una posición concreta, mostraremos el id y no coincidirá

        //Variables a declarar: datos del empleado
        int id, departamento, posicion;
        double salario;
        char apellido[] = new char[10];

        posicion = (id_empleado - 1)*36; //Porque cada empleado ocupa 36 bytes

        if (posicion >= file.length()){ //Si nos pasamos de largo, es que no existe el empleado
            System.out.println("NO EXISTE EL EMPLEADO");
        }
        else{ //Sí que existe o puede existir
            file.seek(posicion); //Nos posicionamos
            //Primero está el ID
            id = file.readInt();

            //Después se encuentra el apellido:
            //Recorremos uno a uno los caracteres del apellido
            for(int i = 0; i<apellido.length; i++){ //En este caso será de 10 el bucle
                //Leemos carácter a carácter. No usamos readUTF por tema de codificación
                apellido[i] = file.readChar(); //Se van guardando en el array apellido
            }
            //Ya cuando lo tengamos, lo convertimos en String
            String apellidos = new String(apellido);

            //Departamento
            departamento = file.readInt();

            //Salario
            salario = file.readDouble();

            //Sacamos los resultados por pantalla
            System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",
                    id, apellidos.trim(), departamento, salario);
        }
        file.close(); //Cerramos fichero
    }
}
