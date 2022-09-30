package com.company;

import java.io.*;
import java.util.Random;

public class CrearFichPartidos {

    public static void main(String[] args) throws Exception {
        File fp = new File("Partidos.dat");
        FileOutputStream fos = new FileOutputStream(fp);
        ObjectOutputStream fop = new ObjectOutputStream(fos);

        Random rnd = new Random();

        int i;
        int j;
        for (i = 1;i<21;i++){
            for (j = 1;j<21;j++){
                if(i != j){
                    //int equipo1 = i;
                    //int equipo2 = j;
                    //int goles1 = rnd.nextInt(8);
                    //int goles2 = rnd.nextInt(8);
                    Partido p = new Partido(i, j, rnd.nextInt(8), rnd.nextInt(8));
                    fop.writeObject(p);
                }
            }
        }
        //fop.writeObject(null);
        fop.close();
        fos.close();

        ObjectInputStream fip = new ObjectInputStream(new FileInputStream(fp));
        Partido pa = (Partido) fip.readObject();
        try {
            while (pa != null) {
                pa.mostrar();
                pa = (Partido) fip.readObject();
            }
        }catch(EOFException e){}
        fip.close();

    }

}

