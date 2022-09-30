//En los ejercicios anteriores se ha visto que se guardan los datos primitivos en un fichero
/*Si tenemos un objeto, como por ejemplo, un empleado, que contiene muchos atributos (nomnre, dirección, salario, departamento...)
y queremos guardarlo en un fichero, tendríamos que guardar cada uno de los atributos por separado...lo cual es un poco costoso
si tenemos muchos objetos.

En este tipo de casos aprovechamos que Java deja guardar objetos en ficheros binarios.
--> El objeto tiene que implementar la interfaz Serializable
        --> Dispone de métodos para guardar y leer objetos en binario
                --> Object readObject() -> para leer un objeto del ObjectInputStream (IOException, ClassNotFoundException)
                --> void writeObject(Object obj) -> para escribir el objeto especificado en ObjectOutputStream (IOException)

 */

import java.io.Serializable;

/* Para leer y escribir objetos serializables a un stream, utilizaremos:
 * ObjectInputStream
 * ObjectOutputStream
 */
public class Persona implements Serializable {
    private String nombre;
    private int edad;

    //Constructores
    public Persona (String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public Persona (){  //constructor vacío
        this.nombre = null;
    }

    //métodos para guardar el nombre o devolverlo
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setEdad(int edad) {this.edad = edad;}

    public String getNombre(){return this.nombre;} //devuelve el nombre
    public int getEdad(){return this.edad;} //devuelve la edad
}
