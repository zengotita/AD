import java.io.*;

public class CreacionFicheroConCopias {

    public static void main(String[] args) throws Exception {
        FileInputStream fiLibros = new FileInputStream("Libros.DAT");
        ObjectInputStream oiLibros = new ObjectInputStream(fiLibros);
        FileInputStream fiEjemplares = new FileInputStream("CopiasRecibidas.DAT");
        ObjectInputStream oiEjemplares = new ObjectInputStream(fiEjemplares);
        FileOutputStream foDuplicados = new FileOutputStream("LibrosDuplicados.DAT");
        ObjectOutputStream ooDuplicados = new ObjectOutputStream(foDuplicados);
        Libro l = (Libro) oiLibros.readObject();
        Ejemplar e = (Ejemplar) oiEjemplares.readObject();

        while (l != null && e != null) {
            if (l.getCodigo().equals(e.getCodigo())) {
                String cod = l.getCodigo();
                String tit = l.getTitulo();
                String aut = l.getAutor();
                int numCop = 1 + e.getEjemplares();
                int numPrest = 0;
                if (l.getPrestado()) {
                    numPrest = 1;
                }
                LibroConCopias lC = new LibroConCopias(cod, tit, aut, numCop, numPrest);
                ooDuplicados.writeObject(lC);
                l = (Libro) oiLibros.readObject();
                e = (Ejemplar) oiEjemplares.readObject();
            } else
            {
                l = (Libro) oiLibros.readObject();
                e = (Ejemplar) oiEjemplares.readObject();
            }

            oiLibros.close();
            oiEjemplares.close();
            ooDuplicados.close();

        }
    }
}