import java.io.*;

class Automovil implements Serializable {

    private String marca;
    private int potencia;
    private int precio;

    public Automovil() {
    }

    public Automovil(String marca, int potencia, int precio) {
        this.marca = marca;
        this.potencia = potencia;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getprecio() {
        return precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void mostrar() {
        System.out.println();
        System.out.println(" Marca: " + marca);
        System.out.println(" Potencia: " + potencia);
        System.out.println(" Precio:" + precio);
    }
}