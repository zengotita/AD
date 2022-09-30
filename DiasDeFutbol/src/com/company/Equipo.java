package com.company;

import java.io.*;
@SuppressWarnings("serial")
public class Equipo implements Serializable
{
    private int codigo;
    private String nombre;
    private int puntos;
    private int golesFavor;
    private int golesContra;

    public Equipo ()	{
        codigo = 0;
        nombre = " ";
        puntos = 0;
        golesFavor = 0;
        golesContra = 0;
    }
    public Equipo (int cod, String nom, int p, int gF, int gC)	{
        codigo = cod;
        nombre = nom;
        puntos = p;
        golesFavor = gF;
        golesContra = gC;
    }
    public int getCodigo()
    {
        return codigo;
    }
    public String getNombre()
    {
        return nombre;
    }
    public int getPuntos()
    {
        return puntos;
    }
    public int getGolesFavor()
    {
        return golesFavor;
    }
    public int getGolesContra()
    {
        return golesContra;
    }
    public void setCodigo(int cod)
    {
        codigo = cod;
    }
    public void setNombre(String nom)
    {
        nombre = nom;
    }
    public void setPuntos(int p)
    {
        puntos = p;
    }
    public void setGolesFavor(int gF)
    {
        golesFavor = gF;
    }
    public void setGolesContra(int gC)
    {
        golesContra = gC;
    }

    public void mostrar()
    {
        System.out.println( codigo +"  "+ nombre +"  "+ puntos +" puntos");
        System.out.println("Goles a Favor =" + golesFavor);
        System.out.println("Goles en Contra = " + golesContra);
    }
}
