package com.consultoraestrategia.ss_crmeducativo.entities;

import java.util.List;

/**
 * Created by irvinmarin on 16/06/2017.
 */

public class Calendario {
    String fecha;
    List<Evento> eventoList;

    public Calendario(String fecha, List<Evento> eventoList) {
        this.fecha = fecha;
        this.eventoList = eventoList;
    }

    public Calendario() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }
}
