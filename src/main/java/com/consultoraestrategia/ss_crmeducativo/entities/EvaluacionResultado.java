package com.consultoraestrategia.ss_crmeducativo.entities;

import com.consultoraestrategia.ss_crmeducativo.lib.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 23/06/2017.
 */
@Table(database = AppDatabase.class)
public class EvaluacionResultado extends BaseModel {

    @Unique
    @PrimaryKey
    private int evaluacionResultadoId;
    @Column
    private int calendarioPeriodoId;
    @Column
    private int planCursoId;
    @Column
    private int competenciaId;
    @Column
    private int alumnoId;
    @Column
    private int docenteId;
    @Column
    private double nota;
    @Column
    private String escala;
    @Column
    private int rubroEvalResultadoId;
    @Column
    private int usuarioCreadorId;
    @Column
    private String fechaCreacion;
    @Column
    private int usuarioAccionId;
    @Column
    private String fechaAccion;

    public EvaluacionResultado() {
    }

    public EvaluacionResultado(int evaluacionResultadoId, int calendarioPeriodoId, int planCursoId, int competenciaId, int alumnoId, int docenteId, double nota, String escala, int rubroEvalResultadoId, int usuarioCreadorId, String fechaCreacion, int usuarioAccionId, String fechaAccion) {
        this.evaluacionResultadoId = evaluacionResultadoId;
        this.calendarioPeriodoId = calendarioPeriodoId;
        this.planCursoId = planCursoId;
        this.competenciaId = competenciaId;
        this.alumnoId = alumnoId;
        this.docenteId = docenteId;
        this.nota = nota;
        this.escala = escala;
        this.rubroEvalResultadoId = rubroEvalResultadoId;
        this.usuarioCreadorId = usuarioCreadorId;
        this.fechaCreacion = fechaCreacion;
        this.usuarioAccionId = usuarioAccionId;
        this.fechaAccion = fechaAccion;
    }

    public int getEvaluacionResultadoId() {
        return evaluacionResultadoId;
    }

    public void setEvaluacionResultadoId(int evaluacionResultadoId) {
        this.evaluacionResultadoId = evaluacionResultadoId;
    }

    public int getCalendarioPeriodoId() {
        return calendarioPeriodoId;
    }

    public void setCalendarioPeriodoId(int calendarioPeriodoId) {
        this.calendarioPeriodoId = calendarioPeriodoId;
    }

    public int getPlanCursoId() {
        return planCursoId;
    }

    public void setPlanCursoId(int planCursoId) {
        this.planCursoId = planCursoId;
    }

    public int getCompetenciaId() {
        return competenciaId;
    }

    public void setCompetenciaId(int competenciaId) {
        this.competenciaId = competenciaId;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public int getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(int docenteId) {
        this.docenteId = docenteId;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public int getRubroEvalResultadoId() {
        return rubroEvalResultadoId;
    }

    public void setRubroEvalResultadoId(int rubroEvalResultadoId) {
        this.rubroEvalResultadoId = rubroEvalResultadoId;
    }

    public int getUsuarioCreadorId() {
        return usuarioCreadorId;
    }

    public void setUsuarioCreadorId(int usuarioCreadorId) {
        this.usuarioCreadorId = usuarioCreadorId;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getUsuarioAccionId() {
        return usuarioAccionId;
    }

    public void setUsuarioAccionId(int usuarioAccionId) {
        this.usuarioAccionId = usuarioAccionId;
    }

    public String getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(String fechaAccion) {
        this.fechaAccion = fechaAccion;
    }
}
