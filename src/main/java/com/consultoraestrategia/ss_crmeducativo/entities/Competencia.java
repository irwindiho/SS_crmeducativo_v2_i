package com.consultoraestrategia.ss_crmeducativo.entities;

import com.consultoraestrategia.ss_crmeducativo.lib.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 23/03/2017.
 */

@Table(database = AppDatabase.class)
public class Competencia extends BaseModel {

    @PrimaryKey
    private int competenciaId;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private int superCompetenciaId;
    @Column
    private int tipoId;


    public Competencia() {

    }

    public Competencia(int competenciaId, String nombre, String descripcion, int superCompetenciaId, int tipoId) {
        this.competenciaId = competenciaId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.superCompetenciaId = superCompetenciaId;
        this.tipoId = tipoId;
    }

    public int getCompetenciaId() {
        return competenciaId;
    }

    public void setCompetenciaId(int competenciaId) {
        this.competenciaId = competenciaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSuperCompetenciaId() {
        return superCompetenciaId;
    }

    public void setSuperCompetenciaId(int superCompetenciaId) {
        this.superCompetenciaId = superCompetenciaId;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    @Override
    public String toString() {
        return "Competencia{" +
                "competenciaId=" + competenciaId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", superCompetenciaId=" + superCompetenciaId +
                ", tipoId=" + tipoId +
                '}';
    }
}
