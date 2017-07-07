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
public class ColorCondicional extends BaseModel {

    @Unique
    @PrimaryKey
    private int colorCondicionalId;
    @Column
    private int desde;
    @Column
    private int hasta;
    @Column
    private boolean incluidoDesde;
    @Column
    private boolean incluidoHasta;
    @Column
    private String colorTexto;
    @Column
    private String colorFondo;
    @Column
    private int rubroEvalResultadoId;
    @Column
    private int rubroEvalProcesoId;

    public ColorCondicional() {
    }

    public ColorCondicional(int colorCondicionalId, int desde, int hasta, boolean incluidoDesde, boolean incluidoHasta, String colorTexto, String colorFondo, int rubroEvalResultadoId, int rubroEvalProcesoId) {
        this.colorCondicionalId = colorCondicionalId;
        this.desde = desde;
        this.hasta = hasta;
        this.incluidoDesde = incluidoDesde;
        this.incluidoHasta = incluidoHasta;
        this.colorTexto = colorTexto;
        this.colorFondo = colorFondo;
        this.rubroEvalResultadoId = rubroEvalResultadoId;
        this.rubroEvalProcesoId = rubroEvalProcesoId;
    }

    public int getRubroEvalResultadoId() {
        return rubroEvalResultadoId;
    }

    public void setRubroEvalResultadoId(int rubroEvalResultadoId) {
        this.rubroEvalResultadoId = rubroEvalResultadoId;
    }

    public int getRubroEvalProcesoId() {
        return rubroEvalProcesoId;
    }

    public void setRubroEvalProcesoId(int rubroEvalProcesoId) {
        this.rubroEvalProcesoId = rubroEvalProcesoId;
    }

    public int getColorCondicionalId() {
        return colorCondicionalId;
    }

    public void setColorCondicionalId(int colorCondicionalId) {
        this.colorCondicionalId = colorCondicionalId;
    }


    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    public boolean isIncluidoDesde() {
        return incluidoDesde;
    }

    public void setIncluidoDesde(boolean incluidoDesde) {
        this.incluidoDesde = incluidoDesde;
    }

    public boolean isIncluidoHasta() {
        return incluidoHasta;
    }

    public void setIncluidoHasta(boolean incluidoHasta) {
        this.incluidoHasta = incluidoHasta;
    }

    public String getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(String colorTexto) {
        this.colorTexto = colorTexto;
    }

    public String getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }
}
