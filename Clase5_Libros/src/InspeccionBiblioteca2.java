import java.io.*;

public class InspeccionBiblioteca2 {

    public static void main(String[] args) throws Exception {
        FileInputStream fiBiblioteca = new FileInputStream("Libros.DAT");
        ObjectInputStream oiBiblioteca = new ObjectInputStream(fiBiblioteca);
        System.out.print("Introduce el autor a buscar: ");
        String autor = Utilidades.leerCadena();
        System.out.println();
        boolean existeElAutor = false;
        Libro l = (Libro) oiBiblioteca.readObject();
        while (l != null) {
            if (l.getAutor().equals(autor)) {
                l.mostrar();
                System.out.println();
                existeElAutor = true;
            }
            l = (Libro) oiBiblioteca.readObject();
        }
        oiBiblioteca.close();
        if (!existeElAutor) {
            System.out.println("El autor " + autor + " no tiene ningun libro "
                    + "en la biblioteca");
        }
    }
}
