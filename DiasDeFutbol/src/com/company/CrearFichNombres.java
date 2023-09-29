package com.company;

import java.io.*;
public class CrearFichNombres {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream fon = new ObjectOutputStream(new FileOutputStream("Nombres.dat"));

        String nombres[] = {"Real Sociedad","Athletic","Osasuna","Alavés","Celta","Barcelona","Madrid","Valencia","Cádiz","Eibar","Getafe","Granada","Valladolid","Levante","Villarreal","Huesca","Elche","Athletico","Betis","Sevilla"};
        int i = 0;
        while(i < nombres.length){
            fon.writeObject(nombres[i]);
            i++;
        }
        //fon.writeObject(null);
        fon.close();

        ObjectInputStream fin = new ObjectInputStream(new FileInputStream("Nombres.dat"));
        String nombre = null;
        try{
            while (true){
                nombre = (String) fin.readObject();
                System.out.println(nombre);
            }
        }catch(EOFException e){}
        fin.close();
    }

}
