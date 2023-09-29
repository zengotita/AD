import java.io.*;

public class EscribirCadenaFichTexto {
    public static void main(String[] args) throws IOException {

        //1. Declarar fichero
        File fichero = new File("//Users//jokin//Documents//Egibide//AD//FichTextoCadenas.txt");
        //2. Crear el flujo de salida
        FileWriter fic = new FileWriter(fichero);
        //3. Creamos cadena que escribiremos en el fichero "FichTexto.txt"
        String prov[]={"gipuzkoa","bizkaia","araba"};
        //4. Ya con cada caracter guardado en el array, vamos de uno en uno escribiéndolos
        for(int i=0; i<prov.length; i++){
            fic.write(prov[i]);  //se va escribiendo un elemento
            fic.write(" ");
        }

        fic.append('*'); //añado al final un * --> así comprobamos que funciona append
        //5. Cerramos flujo de salida
        fic.close();    //
    }
}

