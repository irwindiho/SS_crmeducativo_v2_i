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
public class RubroEvaluacionProceso extends BaseModel {



    @Unique
    @PrimaryKey
     int rubroEvalProcesoId;
    @Column
     String titulo;
    @Column
     String subtitulo;
    @Column
     String colorFondo;
    @Column
     boolean mColorFondo;
    @Column
     String valorDefecto;
    @Column
     int competenciaId;
    @Column
     int calendarioPeriodoId;
    @Column
    private String anchoColumna;
    @Column
     boolean ocultarColumna;
    @Column
     int tipoFormulaId;
    @Column
     int silaboEventoId;
    @Column
     int tipoRedondeoId;
    @Column
     int valorRedondeoId;
    @Column
     int usuarioCreacionId;
    @Column
     String fechaCreacion;
    @Column
     int usuarioAccionId;
    @Column
     String fechaAccion;
    @Column
     int estadoId;

    public RubroEvaluacionProceso() {
    }

    public RubroEvaluacionProceso(int rubroEvalProcesoId, String titulo, String subtitulo, String colorFondo, boolean mColorFondo, String valorDefecto, int competenciaId, int calendarioPeriodoId, String anchoColumna, boolean ocultarColumna, int tipoFormulaId, int silaboEventoId, int tipoRedondeoId, int valorRedondeoId, int usuarioCreacionId, String fechaCreacion, int usuarioAccionId, String fechaAccion, int estadoId) {
        this.rubroEvalProcesoId = rubroEvalProcesoId;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.colorFondo = colorFondo;
        this.mColorFondo = mColorFondo;
        this.valorDefecto = valorDefecto;
        this.competenciaId = competenciaId;
        this.calendarioPeriodoId = calendarioPeriodoId;
        this.anchoColumna = anchoColumna;
        this.ocultarColumna = ocultarColumna;
        this.tipoFormulaId = tipoFormulaId;
        this.silaboEventoId = silaboEventoId;
        this.tipoRedondeoId = tipoRedondeoId;
        this.valorRedondeoId = valorRedondeoId;
        this.usuarioCreacionId = usuarioCreacionId;
        this.fechaCreacion = fechaCreacion;
        this.usuarioAccionId = usuarioAccionId;
        this.fechaAccion = fechaAccion;
        this.estadoId = estadoId;
    }

    public int getRubroEvalProcesoId() {
        return rubroEvalProcesoId;
    }

    public void setRubroEvalProcesoId(int rubroEvalProcesoId) {
        this.rubroEvalProcesoId = rubroEvalProcesoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }

    public boolean ismColorFondo() {
        return mColorFondo;
    }

    public void setmColorFondo(boolean mColorFondo) {
        this.mColorFondo = mColorFondo;
    }

    public String getValorDefecto() {
        return valorDefecto;
    }

    public void setValorDefecto(String valorDefecto) {
        this.valorDefecto = valorDefecto;
    }

    public int getCompetenciaId() {
        return competenciaId;
    }

    public void setCompetenciaId(int competenciaId) {
        this.competenciaId = competenciaId;
    }

    public int getCalendarioPeriodoId() {
        return calendarioPeriodoId;
    }

    public void setCalendarioPeriodoId(int calendarioPeriodoId) {
        this.calendarioPeriodoId = calendarioPeriodoId;
    }

    public String getAnchoColumna() {
        return anchoColumna;
    }

    public void setAnchoColumna(String anchoColumna) {
        this.anchoColumna = anchoColumna;
    }

    public boolean isOcultarColumna() {
        return ocultarColumna;
    }

    public void setOcultarColumna(boolean ocultarColumna) {
        this.ocultarColumna = ocultarColumna;
    }

    public int getTipoFormulaId() {
        return tipoFormulaId;
    }

    public void setTipoFormulaId(int tipoFormulaId) {
        this.tipoFormulaId = tipoFormulaId;
    }

    public int getSilaboEventoId() {
        return silaboEventoId;
    }

    public void setSilaboEventoId(int silaboEventoId) {
        this.silaboEventoId = silaboEventoId;
    }

    public int getTipoRedondeoId() {
        return tipoRedondeoId;
    }

    public void setTipoRedondeoId(int tipoRedondeoId) {
        this.tipoRedondeoId = tipoRedondeoId;
    }

    public int getValorRedondeoId() {
        return valorRedondeoId;
    }

    public void setValorRedondeoId(int valorRedondeoId) {
        this.valorRedondeoId = valorRedondeoId;
    }

    public int getUsuarioCreacionId() {
        return usuarioCreacionId;
    }

    public void setUsuarioCreacionId(int usuarioCreacionId) {
        this.usuarioCreacionId = usuarioCreacionId;
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

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }
}
