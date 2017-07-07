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
public class RubroEvaluacionResultado extends BaseModel {

    @Unique
    @PrimaryKey
     int rubroEvalResultadoId;
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
     String anchoColumna;
    @Column
     boolean ocultarColumna;
    @Column
     int tipoFormulaId;
    @Column
     int silaboBaseId;
    @Column
     int silaboEventoId;
    @Column
     int tipoRedondeoId;
    @Column
     int valorRedondeoId;
    @Column
     double peso;
    @Column
     int estadoId;

    public RubroEvaluacionResultado() {
    }

    public RubroEvaluacionResultado(int rubroEvalResultadoId, String titulo, String subtitulo, String colorFondo, boolean mColorFondo, String valorDefecto, int competenciaId, int calendarioPeriodoId, String anchoColumna, boolean ocultarColumna, int tipoFormulaId, int silaboBaseId, int silaboEventoId, int tipoRedondeoId, int valorRedondeoId, double peso, int estadoId) {
        this.rubroEvalResultadoId = rubroEvalResultadoId;
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
        this.silaboBaseId = silaboBaseId;
        this.silaboEventoId = silaboEventoId;
        this.tipoRedondeoId = tipoRedondeoId;
        this.valorRedondeoId = valorRedondeoId;
        this.peso = peso;
        this.estadoId = estadoId;
    }

    public int getRubroEvalResultadoId() {
        return rubroEvalResultadoId;
    }

    public void setRubroEvalResultadoId(int rubroEvalResultadoId) {
        this.rubroEvalResultadoId = rubroEvalResultadoId;
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

    public boolean isMColorFondo() {
        return mColorFondo;
    }

    public void setMColorFondo(boolean mColorFondo) {
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

    public int getSilaboBaseId() {
        return silaboBaseId;
    }

    public void setSilaboBaseId(int silaboBaseId) {
        this.silaboBaseId = silaboBaseId;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }
}
