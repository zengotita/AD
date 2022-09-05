import java.io.*;

public class CrearDir {
    public static void main(String[] args) throws InterruptedException {
        File d = new File("C:\\Users\\Hezitzaile\\Desktop\\NUEVODIR"); //directorio que creo a partir del actual
        File f1 = new File(d,"FICHERO1.TXT");
        File f2 = new File(d,"FICHERO2.TXT");

        d.mkdir();//CREAR DIRECTORIO

        try {
            if (f1.createNewFile())
                System.out.println("FICHERO1 creado correctamente...");
            else
                System.out.println("No se ha podido crear FICHERO1...");
            if (f2.createNewFile())
                System.out.println("FICHERO2 creado correctamente...");
            else
                System.out.println("No se ha podido crear FICHERO2...");
        } catch (IOException ioe) {ioe.printStackTrace();}

        f1.renameTo(new File(d,"FICHERO1NUEVO.TXT"));//renombro FICHERO1
        Thread.sleep(5000);
        if(f1.delete()) //borro FICHERO1
            System.out.println("Fichero 1 borrado...");
        else
            System.out.println("No se ha podido borrar el Fichero 1...");
        Thread.sleep(5000);
        if(f2.delete())
            System.out.println("Fichero 2 borrado...");
        else
            System.out.println("No se ha podido borrar el Fichero 2...");
        Thread.sleep(5000);
        if(d.delete()) //borrar DIRECTORIO
            System.out.println("Directorio NUEVODIR borrado...");
        else
            System.out.println("No se ha podido borrar el directorio NUEVODIR...");
        Thread.sleep(5000);
        try {
            File f3 = new File("C:\\Users\\Hezitzaile\\Desktop\\NUEVODIR/FICHERO3.TXT");
            f3.createNewFile();
        } catch (IOException ioe) {ioe.printStackTrace();}
    }
}
