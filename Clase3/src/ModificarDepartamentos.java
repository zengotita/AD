import java.io.*;

public class ModificarDepartamentos {

    public static void main(String[] args) throws IOException {
        Departamento dep;
        File fichero = new File(".//ficheros//Departamentos.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        // aqui estaran los nuevos datos
        File ficheroaux = new File(".//ficheros//DepartamentosAux.dat");
        FileOutputStream fileout = new FileOutputStream(ficheroaux);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
        // recuperar argumentos de main
        int numerodep = 5; // num. departamento
        String nombrenuevo = "I+D"; // nombre
        String locnueva = "Toledo"; // localidad
        //int depmodif = Integer.parseInt(numerodep);
        int departamentoexiste = 0;
        try {
            while (true) { // lectura del fichero
                dep = (Departamento) dataIS.readObject();
                if (dep.getDep() == numerodep) {
                    System.out.println("Datos ANTIGUOS DEL DEPARTAMENTO" + numerodep);
                    System.out.println("Nombre: " + dep.getNombre() + ", Localidad : " + dep.getLoc());
                    dep.setNombre(nombrenuevo);
                    dep.setLoc(locnueva);
                    departamentoexiste = 1;
                }
                Departamento dep2 = new Departamento(dep.getNombre(), dep.getDep(), dep.getLoc());
                dataOS.writeObject(dep2); // inserto en fichero auxiliar
            }
        } catch (Exception e) {
// Se produce EOFException al finalizar la lectura

            if (departamentoexiste > 0) {
                CrearNuevoDep();
                ListadoNuevo();
            } else {
                System.out.println("===================================");
                System.out.println("DEPARTAMENTO A MODIFICAR NO EXISTE");
                System.out.println("===================================");
            }
        }
    }

    public static void CrearNuevoDep() throws IOException {
        Departamento dep;
        // Leo auxiliar e inserto en Departamentos
        File fichero = new File(".//ficheros//DepartamentosAux.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        // aquí estarán los nuevos datos
        File ficheroaux = new File(".//ficheros//Departamentos.dat");
        FileOutputStream fileout = new FileOutputStream(ficheroaux);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
        try {
            while (true) { // lectura del fichero
                dep = (Departamento) dataIS.readObject();
                // Leo fichero auxiliar
                Departamento dep2 = new Departamento(dep.getNombre(), dep.getDep(), dep.getLoc());
                // inserto en nuevo fichero de Departamentos
                dataOS.writeObject(dep2);
            }
        } catch (Exception e) {
        }
        // Se produce EOFException al finalizar la lectura
        dataIS.close(); // cerrar stream de entrada
        dataOS.close(); // cerrar stream de SALIDA
    }// fin Crear Nuevo Dep

    public static void ListadoNuevo() throws IOException {
        Departamento dep;

        File fichero = new File(".//ficheros//Departamentos.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        try {
            while (true) {
                //Leemos una persona, pero debemos hacer casting en readObject
                Departamento departamento = (Departamento) dataIS.readObject();
                //No podemos utilizar println de esta manera, así que utilizamos %n para saltos de línea
                // %s --> String
                // %d --> Int
                System.out.printf("Nombre dept.: %s, Número dept.: %d, Localidad: %s %n", departamento.getNombre(), departamento.getDep(), departamento.getLoc());
            }
        } catch (EOFException | ClassNotFoundException eo) {
            System.out.println("Fin de lectura");
        }
        System.out.println("=======================================================");
        dataIS.close(); //Cerramos el flujo de entrada
    }
}