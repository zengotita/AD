import java.io.*;

public class VerDir {
    public static void main(String[] args) {
        System.out.println("Archivos en el directorio actual:");
        File f = new File("C:\\Users\\Hezitzaile\\Desktop");
        //System.out.printf(String.valueOf(f.isDirectory()));
        String[] archivos = f.list();
        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i]);
        }
    }
}
