import java.io.*;

public class LeerFichAleatorio {
    public static void main (String[] args) throws IOException {

        File fichero = new File("./Clase3/ficheros/AleatorioEmple.dat");
        //Declaramos el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        //Declaración de variables en las que guardaremos las variables que sacaremos por pantalla
        int id, departamento, posicion;
        double salario;
        char apellido[] = new char[10];


        posicion = 0; //Nos situamos al principio para recorrer el fichero

        while(true) { // También podríamos poner un bucle infinito como --> for(;;){
            file.seek(posicion); //Nos posicionamos donde indique "posicion"
            id = file.readInt(); //Obtenemos el id del empleado, que es lo primero que está guardado

            //Recorremos uno a uno los caracteres del apellido
            for(int i = 0; i<apellido.length; i++){ //En este caso será de 10 el bucle
                apellido[i] = file.readChar(); //Se van guardando en el array apellido
            }

            //Se convierte a String el array
            String apellidos = new String(apellido);
            //String apellidos = file.readUTF();

            //Obtenemos el departamento
            departamento = file.readInt();

            //Salario;
            salario = file.readDouble();

            if(id>0) { //Eso es que devuelve un id
                System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",
                        id, apellidos.trim(), departamento, salario);
            }
            //Nos posicionamos para el siguiente empleando, teniendo en cuenta que cada uno ocupa 36 bytes
            posicion = posicion + 36;

            //Si se han recorrido todos los bytes, se sale del for con un break
            if(file.getFilePointer() == file.length()){
                break;
            }
        } //Final del bucle
        file.close(); //Cerramos fichero
    }

}
