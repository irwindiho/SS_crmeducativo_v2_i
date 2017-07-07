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
public class CargaCursos extends BaseModel {

    @Column
    @PrimaryKey
    private int cargaCursoId;
    @Column
    private int planCursoId;
    @Column
    private int empleadoId;
    @Column
    private int cargaAcademicaId;

    public CargaCursos() {
    }

    public CargaCursos(int cargaCursoId, int planCursoId, int empleadoId, int cargaAcademicaId) {
        this.cargaCursoId = cargaCursoId;
        this.planCursoId = planCursoId;
        this.empleadoId = empleadoId;
        this.cargaAcademicaId = cargaAcademicaId;
    }

    public int getCargaCursoId() {
        return cargaCursoId;
    }

    public void setCargaCursoId(int cargaCursoId) {
        this.cargaCursoId = cargaCursoId;
    }

    public int getPlanCursoId() {
        return planCursoId;
    }

    public void setPlanCursoId(int planCursoId) {
        this.planCursoId = planCursoId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public int getCargaAcademicaId() {
        return cargaAcademicaId;
    }

    public void setCargaAcademicaId(int cargaAcademicaId) {
        this.cargaAcademicaId = cargaAcademicaId;
    }

    @Override
    public String toString() {
        return "CargaCursos{" +
                "cargaCursoId=" + cargaCursoId +
                ", planCursoId=" + planCursoId +
                ", empleadoId=" + empleadoId +
                ", cargaAcademicaId=" + cargaAcademicaId +
                '}';
    }
}
