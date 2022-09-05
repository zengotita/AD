import java.io.*;

public class LibroConCopias implements Serializable {

    private String codigo;
    private String titulo;
    private String autor;
    private int numCopias;
    private int numPrestados;
    private int disponibles;

    public LibroConCopias() {
    }

    public LibroConCopias(String c, String t, String a, int nC, int nP) {
        codigo = c;
        titulo = t;
        autor = a;
        numCopias = nC;
        numPrestados = nP;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public int getNumPrestados() {
        return numPrestados;
    }

    public void setCodigo(String c) {
        codigo = c;
    }

    public void setTitulo(String t) {
        titulo = t;
    }

    public void setAutor(String a) {
        autor = a;
    }

    public void setNumCopias(int nC) {
        numCopias = nC;
    }

    public void setNumPrestados(int nP) {
        numPrestados = nP;
    }

    public int ejemplaresDisponibles() {
        disponibles = numCopias - numPrestados;
        return (disponibles);
    }

    public void leerLibro() {
        System.out.print("Introduce el codigo ISBN del libro: ");
        codigo = Utilidades.leerCadena();
        System.out.print("Introduce el titulo: ");
        titulo = Utilidades.leerCadena();
        System.out.print("Introduce el autor: ");
        autor = Utilidades.leerCadena();
        System.out.print("Introduce el numero de ejemplares del libro: ");
        numCopias = Utilidades.leerEntero();
    }

    public void mostrar() {
        System.out.println();
        System.out.println(" Codigo ISBN: " + codigo);
        System.out.println(" Titulo: " + titulo);
        System.out.println(" Autor:" + autor);
        System.out.println(" Nº de ejemplares:" + numCopias);
        System.out.println(" Nº de prestados:" + numPrestados);
    }
}
