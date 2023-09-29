import java.io.*;
import com.thoughtworks.xstream.XStream;


public class EscribirPersonas {
    public static void main(String[] args)  throws IOException ,   ClassNotFoundException {
        //Objeto file
        File fichero = new File("./Clase4/ficheros/FichPersona.dat");
        //Crea el flujo de entrada
        FileInputStream filein = new FileInputStream(fichero);
        //Conecta el flujo de bytes al flujo de datos
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        System.out.println("Comienza el proceso de creación del fichero a XML ...");

        //Creamos un objeto Lista de Personas (usamos ListaPersonas.java)
        ListaPersonas listaper = new ListaPersonas();

        try {
            while (true) { //lectura del fichero
                Persona persona= (Persona) dataIS.readObject(); //leer una Persona con readObject
                listaper.add(persona); //añadimos persona a la lista
            }
        }catch (EOFException eo) {}
        dataIS.close();  //cerrar stream de entrada

        //SEGUNDA PARTE --> ESCRIBIR FICHERO XTREAM
        //Teniendo la lista de personas, los cargaremos montando el fichero XML
        try {
            XStream xstream = new XStream();
            //Cambiamos de nombre a las etiquetas XML de los objetos que usamos
            //xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
            //xstream.alias("DatosPersona", Persona.class);
            //Quitamos etiqueta lista (atributo de la clase ListaPersonas)
            //xstream.addImplicitCollection(ListaPersonas.class, "lista");
            //Insertamos los objetos en el XML
            xstream.toXML(listaper, new FileOutputStream("./Clase4/ficheros/Personas.xml"));
            System.out.println("Creado fichero XML....");
        }catch (Exception e)
        {e.printStackTrace();}
    } // fin main
} //fin EscribirPersonas