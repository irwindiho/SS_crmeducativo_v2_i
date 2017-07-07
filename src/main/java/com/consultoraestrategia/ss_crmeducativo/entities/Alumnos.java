package com.consultoraestrategia.ss_crmeducativo.entities;

import java.util.List;

/**
 * Created by kelvi on 24/02/2017.
 */

public class Alumnos {
    private int id;
    private String nombres;
    private String imagen;


    private List<EvaluacionCapacidad> evaLuacionCapacidadesList;
    private List<Competencia> competenciaList;


    public List<Competencia> getCompetenciaList() {
        return competenciaList;
    }

    public void setCompetenciaList(List<Competencia> competenciaList) {
        this.competenciaList = competenciaList;
    }


    public Alumnos() {
    }

    public Alumnos(int id, String nombres, String imagen, List<EvaluacionCapacidad> evaLuacionCapacidadesList, List<Competencia> competenciaList) {
        this.id = id;
        this.nombres = nombres;
        this.imagen = imagen;
        this.evaLuacionCapacidadesList = evaLuacionCapacidadesList;
        this.competenciaList = competenciaList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<EvaluacionCapacidad> getEvaLuacionCapacidadesList() {
        return evaLuacionCapacidadesList;
    }

    public void setEvaLuacionCapacidadesList(List<EvaluacionCapacidad> evaLuacionCapacidadesList) {
        this.evaLuacionCapacidadesList = evaLuacionCapacidadesList;
    }

    @Override
    public String toString() {
        return id + "-" + nombres;
    }
}
