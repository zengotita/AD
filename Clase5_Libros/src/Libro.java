import java.io.*;

public class Libro implements Serializable {

    private String codigo;
    private String titulo;
    private String autor;
    private boolean prestado;

    public Libro() {
    }

    public Libro(String c, String t, String a, boolean p) {
        codigo = c;
        titulo = t;
        autor = a;
        prestado = p;
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

    public boolean getPrestado() {
        return prestado;
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

    public void setPrestado(boolean p) {
        prestado = p;
    }

    public void mostrar() {
        System.out.println();
        System.out.println(" Codigo ISBN: " + codigo);
        System.out.println(" Titulo: " + titulo);
        System.out.println(" Autor:" + autor);
        if (prestado) {
            System.out.println(" Prestado: si");
        } else {
            System.out.println(" Prestado: no");
        }
    }

    public void leerLibro() {
        char respuesta;
        System.out.print("Introduce el codigo ISBN del libro: ");
        codigo = Utilidades.leerCadena();
        System.out.print("Introduce el titulo: ");
        titulo = Utilidades.leerCadena();
        System.out.print("Introduce el autor: ");
        autor = Utilidades.leerCadena();
        do {
            System.out.print("¿Esta el libro prestado? (S/N): ");
            respuesta = Utilidades.leerCaracter();
        } while (respuesta != 'S' && respuesta != 's' && respuesta != 'N' && respuesta != 'n');

        prestado = (respuesta == 'S' || respuesta == 's');
    }
}
