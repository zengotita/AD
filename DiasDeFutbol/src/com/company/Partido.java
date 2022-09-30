package com.company;

import java.io.*;

@SuppressWarnings("serial")

public class Partido implements Serializable
{
    private int equipo1;	// código equipo 1
    private int equipo2;	// código equipo 2
    private int goles1;		// goles equipo 1
    private int goles2;		// goles equipo 2

    public Partido(){
        this.equipo1 = 0;
        this.equipo2 = 0;
        this.goles1 = 0;
        this.goles2 = 0;
    }

    public Partido(int e1, int e2, int g1, int g2){
        this.equipo1 = e1;
        this.equipo2 = e2;
        this.goles1 = g1;
        this.goles2 = g2;
    }

    public int getEquipo1(){
        return this.equipo1;
    }

    public int getEquipo2(){
        return this.equipo2;
    }

    public int getGoles1(){
        return this.goles1;
    }

    public int getGoles2(){
        return this.goles2;
    }

    public void setEquipo1(int e1){
        this.equipo1 = e1;
    }

    public void setEquipo2(int e2){
        this.equipo2 = e2;
    }

    public void setGoles1(int g1){
        this.goles1 = g1;
    }

    public void setGoles2(int g2){
        this.goles2 = g2;
    }

    public void mostrar(){
        System.out.println("Equipo 1: "+this.equipo1);
        System.out.println("Goles equipo 1: "+this.goles1);
        System.out.println("Equipo 2: "+this.equipo2);
        System.out.println("Goles equipo 2: "+this.goles2);
    }

}
