package com.company;

import java.io.*;
public class LeerNombres {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream fon = new ObjectInputStream(new FileInputStream("Nombres.dat"));
        String nombre = (String) fon.readObject();
        try {
            while (nombre != null){

                System.out.println(nombre);
                nombre =(String) fon.readObject();

            }
        } catch (EOFException e) {		}
        fon.close();
    }

}
