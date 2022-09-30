package com.company;

import java.util.ArrayList;
import java.util.List;
public class ListaEquipos {

    private List<Equipo> lista = new ArrayList<Equipo>();

    public ListaEquipos(){
    }

    public void add(Equipo e) {
        lista.add(e);
    }

    public List<Equipo> getListaEquipos() {
        return lista;
    }
}
