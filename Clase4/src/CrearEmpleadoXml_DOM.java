import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearEmpleadoXml_DOM {
    public static void main(String argv[]) throws IOException{
        File fichero = new File("./Clase4/ficheros/AleatorioEmple.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        int  id, dep, posicion=0; //para situarnos al principio del fichero
        Double salario;
        char apellido[] = new char[10], aux;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0"); // asignamos la version de nuestro XML

            for(;;) {
                file.seek(posicion); //nos posicionamos
                id=file.readInt(); // obtengo id de empleado
                for (int i = 0; i < apellido.length; i++) {
                    aux = file.readChar();//recorro uno a uno los caracteres del apellido
                    apellido[i] = aux;    //los voy guardando en el array
                }
                String apellidoS= new String(apellido);//convierto a String el array
                dep=file.readInt();//obtengo dep
                salario=file.readDouble();  //obtengo salario

                if(id>0) { //id validos a partir de 1
                    Element raiz = document.createElement("empleado"); //nodo empleado
                    document.getDocumentElement().appendChild(raiz);
                    CrearElemento("id",Integer.toString(id), raiz, document); //añadir ID
                    CrearElemento("apellido",apellidoS.trim(), raiz, document); //Apellido
                    CrearElemento("dep",Integer.toString(dep), raiz, document); //añadir DEP
                    CrearElemento("salario",Double.toString(salario), raiz, document); //SAL
                }
                posicion= posicion + 36; // me posiciono para el sig empleado
                if (file.getFilePointer() == file.length())   break;

            }//del for que recorre el fichero

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("./Clase4/ficheros/Empleados.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console= new StreamResult(System.out);
            transformer.transform(source, console);


        }catch(Exception e){System.err.println("Error: "+e);}
        file.close();  //cerrar fichero
    }//de main

    //Inserción de los datos del empleado
    static void  CrearElemento(String datoEmple, String valor,
                               Element raiz, Document document){
        Element elem = document.createElement(datoEmple); //creamos hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
}//de la clase

