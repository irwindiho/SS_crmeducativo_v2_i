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
public class EvaluacionProceso extends BaseModel {

    @Unique
    @PrimaryKey
    private int evaluacionProcesoId;
    @Column
    private int evaluacionResultadoId;
    @Column
    private double nota;
    @Column
    private String escala;
    @Column
    private int rubroEvalProcesoId;
    @Column
    private int usuarioCreadorId;
    @Column
    private String fechaCreacion;
    @Column
    private int usuarioAccionId;
    @Column
    private String fechaAccion;

    public EvaluacionProceso(int evaluacionProcesoId, int evaluacionResultadoId, double nota, String escala, int rubroEvalProcesoId, int usuarioCreadorId, String fechaCreacion, int usuarioAccionId, String fechaAccion) {
        this.evaluacionProcesoId = evaluacionProcesoId;
        this.evaluacionResultadoId = evaluacionResultadoId;
        this.nota = nota;
        this.escala = escala;
        this.rubroEvalProcesoId = rubroEvalProcesoId;
        this.usuarioCreadorId = usuarioCreadorId;
        this.fechaCreacion = fechaCreacion;
        this.usuarioAccionId = usuarioAccionId;
        this.fechaAccion = fechaAccion;
    }

    public EvaluacionProceso() {
    }

    public int getEvaluacionProcesoId() {
        return evaluacionProcesoId;
    }

    public void setEvaluacionProcesoId(int evaluacionProcesoId) {
        this.evaluacionProcesoId = evaluacionProcesoId;
    }

    public int getEvaluacionResultadoId() {
        return evaluacionResultadoId;
    }

    public void setEvaluacionResultadoId(int evaluacionResultadoId) {
        this.evaluacionResultadoId = evaluacionResultadoId;
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

    public int getRubroEvalProcesoId() {
        return rubroEvalProcesoId;
    }

    public void setRubroEvalProcesoId(int rubroEvalProcesoId) {
        this.rubroEvalProcesoId = rubroEvalProcesoId;
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
