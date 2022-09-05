import java.io.*;

public class Ejemplar implements Serializable {

    private String codigo;
    private int ejemplares;

    public Ejemplar() {
    }

    public Ejemplar(String c, int e) {
        codigo = c;
        ejemplares = e;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setCodigo(String c) {
        codigo = c;
    }

    public void setEjemplares(int e) {
        ejemplares = e;
    }

    public void mostrar() {
        System.out.println();
        System.out.println(" Codigo ISBN: " + codigo);
        System.out.println(" Nยบ de ejemplares: " + ejemplares);
    }
}
