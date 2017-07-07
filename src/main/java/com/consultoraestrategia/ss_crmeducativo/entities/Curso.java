package com.consultoraestrategia.ss_crmeducativo.entities;

/**
 * Created by irvinmarin on 27/02/2017.
 */
public class Curso {
    private String nombreClase;
    private String periodo;
    private String nombreDocente;
    private int colorResource;


    public Curso() {
    }

    public Curso(String nombreClase, String periodo, String nombreDocente, int colorResource) {
        this.nombreClase = nombreClase;
        this.periodo = periodo;
        this.nombreDocente = nombreDocente;
        this.colorResource = colorResource;
    }

    public int getColorResource() {
        return colorResource;
    }

    public void setColorResource(int colorResource) {
        this.colorResource = colorResource;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }
}
