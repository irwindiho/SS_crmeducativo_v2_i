package com.consultoraestrategia.ss_crmeducativo.entities;

import com.consultoraestrategia.ss_crmeducativo.lib.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 22/03/2017.
 */
@Table(database = AppDatabase.class)
public class CargaAcademica extends BaseModel {

    @Column
    @PrimaryKey
    private int cargaAcademicaId;
    @Column
    private int seccionId;
    @Column
    private int periodoId;
    @Column
    private int aulaId;
    @Column
    private int idAnioAcademico;

    public CargaAcademica() {
    }

    public CargaAcademica(int cargaAcademicaId, int seccionId, int periodoId, int aulaId, int idAnioAcademico) {
        this.cargaAcademicaId = cargaAcademicaId;
        this.seccionId = seccionId;
        this.periodoId = periodoId;
        this.aulaId = aulaId;
        this.idAnioAcademico = idAnioAcademico;
    }


    public int getCargaAcademicaId() {
        return cargaAcademicaId;
    }

    public void setCargaAcademicaId(int cargaAcademicaId) {
        this.cargaAcademicaId = cargaAcademicaId;
    }

    public int getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(int seccionId) {
        this.seccionId = seccionId;
    }

    public int getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(int periodoId) {
        this.periodoId = periodoId;
    }

    public int getAulaId() {
        return aulaId;
    }

    public void setAulaId(int aulaId) {
        this.aulaId = aulaId;
    }

    public int getIdAnioAcademico() {
        return idAnioAcademico;
    }

    public void setIdAnioAcademico(int idAnioAcademico) {
        this.idAnioAcademico = idAnioAcademico;
    }

    @Override
    public String toString() {
        return "CargaAcademica{" +
                "cargaAcademicaId=" + cargaAcademicaId +
                ", seccionId=" + seccionId +
                ", periodoId=" + periodoId +
                ", aulaId=" + aulaId +
                ", idAnioAcademico=" + idAnioAcademico +
                '}';
    }
}
