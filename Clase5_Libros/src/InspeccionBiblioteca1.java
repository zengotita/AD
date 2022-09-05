import java.io.*;

public class InspeccionBiblioteca1 {

    public static void main(String[] args) throws Exception {
        FileInputStream fiBiblioteca = new FileInputStream("Libros.DAT");
        ObjectInputStream oiBiblioteca = new ObjectInputStream(fiBiblioteca);
        Libro l = (Libro) oiBiblioteca.readObject();
        while (l != null) {
            l.mostrar();
            l = (Libro) oiBiblioteca.readObject();
        }
        oiBiblioteca.close();
    }
}
