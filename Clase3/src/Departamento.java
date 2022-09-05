
import java.io.Serializable;

public class Departamento implements Serializable {

    private String nombre;
    private String localidad;
    private int numdep;

    public Departamento(String nombre, int dep, String loc) {
        this.nombre = nombre;
        this.numdep = dep;
        this.localidad = loc;
    }

    public Departamento() {
        this.nombre = null;
        this.localidad = null;
        this.numdep = 0;
    }


    //Nombre del departamento
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Localidad del departamento
    public String getLoc() {
        return localidad;
    }

    public void setLoc(String loc) {
        this.localidad = loc;
    }

    //Número de departamento
    public int getDep() {
        return numdep;
    }

    public void setDep(int dep) {
        this.numdep = dep;
    }


}

