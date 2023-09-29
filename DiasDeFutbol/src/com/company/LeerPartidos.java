package com.company;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerPartidos {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream fon = new ObjectInputStream(new FileInputStream("Partidos.dat"));
        Partido partido = (Partido) fon.readObject();
        try {
            while (partido != null){

                partido.mostrar();
                partido =(Partido) fon.readObject();

            }
        } catch (EOFException e) {		}
        fon.close();

    }

}
