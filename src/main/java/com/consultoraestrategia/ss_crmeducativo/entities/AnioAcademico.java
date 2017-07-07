package com.consultoraestrategia.ss_crmeducativo.entities;


import com.consultoraestrategia.ss_crmeducativo.lib.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 23/03/2017.
 */

@Table(database = AppDatabase.class)
public class AnioAcademico extends BaseModel {

    @Unique
    @PrimaryKey
     int idAnioAcademico;

    @Column
     String nombre;
    @Column
    private String fechaInicio;
    @Column
    private String fechaFin;
    @Column
    private String denomiacion;
    @Column
    private String georeferenciaId;
    @Column
    private String organigramaId;
    @Column
    private int estadoId;


    public AnioAcademico() {
    }


    public AnioAcademico(int idAnioAcademico, String nombre, String fechaInicio, String fechaFin, String denomiacion, String georeferenciaId, String organigramaId, int estadoId) {
        this.idAnioAcademico = idAnioAcademico;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.denomiacion = denomiacion;
        this.georeferenciaId = georeferenciaId;
        this.organigramaId = organigramaId;
        this.estadoId = estadoId;
    }

    public int getIdAnioAcademico() {
        return idAnioAcademico;
    }

    public void setIdAnioAcademico(int idAnioAcademico) {
        this.idAnioAcademico = idAnioAcademico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDenomiacion() {
        return denomiacion;
    }

    public void setDenomiacion(String denomiacion) {
        this.denomiacion = denomiacion;
    }

    public String getGeoreferenciaId() {
        return georeferenciaId;
    }

    public void setGeoreferenciaId(String georeferenciaId) {
        this.georeferenciaId = georeferenciaId;
    }

    public String getOrganigramaId() {
        return organigramaId;
    }

    public void setOrganigramaId(String organigramaId) {
        this.organigramaId = organigramaId;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }
}
