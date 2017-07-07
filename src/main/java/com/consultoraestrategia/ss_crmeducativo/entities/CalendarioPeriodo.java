package com.consultoraestrategia.ss_crmeducativo.entities;

import com.consultoraestrategia.ss_crmeducativo.lib.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 03/05/2017.
 */
@Table(database = AppDatabase.class)
public class CalendarioPeriodo extends BaseModel {

    @PrimaryKey
    private int calendarioPeriodoId;
    @Column
    private String fechaInicio;
    @Column
    private String fechaFin;
    @Column
    private int calendarioAcademicoId;
    @Column
    private int tipoId;
    @Column
    private int estadoId;
    @Column
    private int diazPlazo;

    public CalendarioPeriodo() {
    }

    public CalendarioPeriodo(int calendarioPeriodoId, String fechaInicio, String fechaFin, int calendarioAcademicoId, int tipoId, int estadoId, int diazPlazo) {
        this.calendarioPeriodoId = calendarioPeriodoId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.calendarioAcademicoId = calendarioAcademicoId;
        this.tipoId = tipoId;
        this.estadoId = estadoId;
        this.diazPlazo = diazPlazo;
    }

    public int getCalendarioPeriodoId() {
        return calendarioPeriodoId;
    }

    public void setCalendarioPeriodoId(int calendarioPeriodoId) {
        this.calendarioPeriodoId = calendarioPeriodoId;
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

    public int getCalendarioAcademicoId() {
        return calendarioAcademicoId;
    }

    public void setCalendarioAcademicoId(int calendarioAcademicoId) {
        this.calendarioAcademicoId = calendarioAcademicoId;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public int getDiazPlazo() {
        return diazPlazo;
    }

    public void setDiazPlazo(int diazPlazo) {
        this.diazPlazo = diazPlazo;
    }
}
