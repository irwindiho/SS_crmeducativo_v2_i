package com.consultoraestrategia.ss_crmeducativo.entities;

/**
 * Created by irvinmarin on 16/06/2017.
 */

public class Evento {
    private String horaInicio;
    private String horaFinal;
    private String nombre;
    private String fecha;
    private boolean alarma;

    public Evento(String horaInicio, String horaFinal, String nombre, String fecha, boolean alarma) {
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.nombre = nombre;
        this.fecha = fecha;
        this.alarma = alarma;
    }

    public Evento() {
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isAlarma() {
        return alarma;
    }

    public void setAlarma(boolean alarma) {
        this.alarma = alarma;
    }
}
