package com.consultoraestrategia.ss_crmeducativo.entities;

import com.consultoraestrategia.ss_crmeducativo.lib.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppDatabase.class)
public class PlanEstudios extends BaseModel {

    @PrimaryKey
    private int planEstudioId;
    @Column
    private int programaEduId;
    @Column
    private String nombrePlan;
    @Column
    private String alias;
    @Column
    private int estadoId;
    @Column
    private String nroResolucion;
    @Column
    private String fechaResolucion;

    public PlanEstudios() {
    }

    public PlanEstudios(int planEstudioId, int programaEduId, String nombrePlan, String alias, int estadoId, String nroResolucion, String fechaResolucion) {
        this.planEstudioId = planEstudioId;
        this.programaEduId = programaEduId;
        this.nombrePlan = nombrePlan;
        this.alias = alias;
        this.estadoId = estadoId;
        this.nroResolucion = nroResolucion;
        this.fechaResolucion = fechaResolucion;
    }

    public int getPlanEstudioId() {
        return planEstudioId;
    }

    public void setPlanEstudioId(int planEstudioId) {
        this.planEstudioId = planEstudioId;
    }

    public int getProgramaEduId() {
        return programaEduId;
    }

    public void setProgramaEduId(int programaEduId) {
        this.programaEduId = programaEduId;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getNroResolucion() {
        return nroResolucion;
    }

    public void setNroResolucion(String nroResolucion) {
        this.nroResolucion = nroResolucion;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }
}
