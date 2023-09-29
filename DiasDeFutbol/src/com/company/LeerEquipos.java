package com.company;

import java.io.*;
public class LeerEquipos {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream fe = new ObjectInputStream(new FileInputStream("Equipos.dat"));

        Equipo e = (Equipo) fe.readObject();
        while (e != null){
            //e.mostrar();
            System.out.println(e.getNombre());
            System.out.println(e.getPuntos());
            e = (Equipo) fe.readObject();
        }
        fe.close();
    }
}
