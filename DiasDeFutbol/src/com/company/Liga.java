package com.company;

import java.io.*;

public class Liga {

    public static void main(String[] args) throws Exception
    {
        int [][] aEquipos = new int [20][3];
        iniciar(aEquipos); //Iniciamos el array con los datos a 0
        procesarPartidos(aEquipos);
        generarEstadistica(aEquipos);
        equipoGanador(aEquipos);
        //aXML();
    }

    public static void iniciar(int[][] aEquipos)
    {
        for (int i=0; i<aEquipos.length ;i++)
            for (int j=0; j<aEquipos[i].length ;j++)
                aEquipos[i][j] = 0;
    }

    //Ejercicio 1
    public static void procesarPartidos(int[][]aEquipos) throws IOException, ClassNotFoundException {
        //Gestión del fichero para poder leer los objetos guardados en él
        FileInputStream fiPartidos = new FileInputStream("Partidos.dat");
        ObjectInputStream oiPartidos = new ObjectInputStream(fiPartidos);

        //Partido p = (Partido) oiPartidos.readObject(); //Objeto Partido, primero que se obtiene
        //while (p != null)
        try {
            while (true)
            //Lectura del partido, según los goles, aEquipo se actualizará de un modo u otro
            {
                Partido p = (Partido) oiPartidos.readObject();
                //p = (Partido) oiPartidos.readObject();
                if (p.getGoles1() == p.getGoles2()) {
                    aEquipos[p.getEquipo1() - 1][0] += 1;
                    aEquipos[p.getEquipo2() - 1][0] += 1;
                } else if (p.getGoles1() > p.getGoles2())
                    aEquipos[p.getEquipo1() - 1][0] += 3; //No hace falta actualizar el otro, ya que se han iniciado a 0
                else
                    aEquipos[p.getEquipo2() - 1][0] += 3;
                aEquipos[p.getEquipo1() - 1][1] += p.getGoles1();
                aEquipos[p.getEquipo1() - 1][2] += p.getGoles2();
                aEquipos[p.getEquipo2() - 1][1] += p.getGoles2();
                aEquipos[p.getEquipo2() - 1][2] += p.getGoles1();
                //p = (Partido) oiPartidos.readObject(); //Siguiente partido
            }
        }
        catch(EOFException eo){
            System.out.println("Fin de lectura");
        }
        oiPartidos.close();
        fiPartidos.close(); //No sería necesario, aunque no está de más
    }

    //Ejercicio 2
    public static void generarEstadistica(int[][]aEquipos) throws IOException, ClassNotFoundException {

        //Abrir flujo de entrada de datos para leer fichero Nombres.dat
        FileInputStream fiNombres = new FileInputStream("Nombres.dat");
        ObjectInputStream oiNombres = new ObjectInputStream(fiNombres);

        //Abrir flujo de salida de datos para Escribir fichero Equipos.dat
        FileOutputStream foEquipos = new FileOutputStream("Equipos.dat");
        ObjectOutputStream ooEquipos = new ObjectOutputStream(foEquipos);

        for (int i=0; i<aEquipos.length ;i++) //Recorremos el array con los datos
        {
            //Leemos el objeto Equipo de "Nombres". Hacemos casting
            String nomEquipo = (String)oiNombres.readObject();
            //Creamos un equipo con los datos del array y del nombre que hemos leído.
            Equipo e = new Equipo(i+1, nomEquipo, aEquipos[i][0], aEquipos[i][1], aEquipos[i][2]);
            //Escribimos el objeto en el fichero destino
            ooEquipos.writeObject(e);
        }
        //Escribimos "null" al final del fichero
        ooEquipos.writeObject(null);
        //Cerramos todos
        ooEquipos.close();
        foEquipos.close();
        oiNombres.close();
        fiNombres.close();

    }

    //Ejercicio 3
    public static void equipoGanador(int[][]aEquipos) throws IOException, ClassNotFoundException {

        //Abrir flujo de entrada para leer los equipos
        FileInputStream foEquipos = new FileInputStream("Equipos.dat");
        ObjectInputStream ooEquipos = new ObjectInputStream(foEquipos);


        Equipo e = (Equipo) ooEquipos.readObject();
        String ganador = "";//e.getNombre();
        int puntosganador = 0;//e.getPuntos();
        int golaverage = 0;//e.getGolesFavor() - e.getGolesContra();


        while (e != null){
                if (e.getPuntos() > puntosganador){
                    puntosganador = e.getPuntos();
                    golaverage = e.getGolesFavor() - e.getGolesContra();
                    ganador = e.getNombre();

                }

                else if (e.getPuntos()==puntosganador){
                    if ((e.getGolesFavor() - e.getGolesContra()) > golaverage){
                        puntosganador = e.getPuntos();
                        golaverage = e.getGolesFavor() - e.getGolesContra();
                        ganador = e.getNombre();
                    }
                    //no hay más elses porque si no se cumple, se mantiene el que estaba
                }

                e = (Equipo) ooEquipos.readObject();
            }

        ooEquipos.close();
        System.out.println("Equipo ganador: " + ganador);
        System.out.println("Puntos: " + puntosganador);

    }
}
