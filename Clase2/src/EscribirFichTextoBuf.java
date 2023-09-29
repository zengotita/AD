import java.io.*;
public class EscribirFichTextoBuf {
    public static void main(String[] args) {
        try{
            BufferedWriter fichero = new BufferedWriter(new FileWriter("Clase2/src/FichTextoBuff.txt"));
            for (int i=1; i<110; i++){
                fichero.write("Fila numero: "+i); //escribe una línea
                fichero.newLine(); //escribe un salto de línea
            }
            fichero.close();
        }
        catch (FileNotFoundException fn ){
            System.out.println("No se encuentra el fichero");}
        catch (IOException io) {
            System.out.println("Error de E/S ");}
    }
}
