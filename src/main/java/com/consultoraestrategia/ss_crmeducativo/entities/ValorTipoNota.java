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
public class ValorTipoNota extends BaseModel {

    @Unique
    @PrimaryKey
    private int valorTipoNotalId;
    @Column
    private int tipoNotaId;
    @Column
    private String titulo;
    @Column
    private String alias;
    @Column
    private double limiteInferior;
    @Column
    private double limiteSuperior;
    @Column
    private double valorNumerico;
    @Column
    private String icono;

    public ValorTipoNota() {
    }


    public ValorTipoNota(int valorTipoNotalId, int tipoNotaId, String titulo, String alias, double limiteInferior, double limiteSuperior, double valorNumerico, String icono) {
        this.valorTipoNotalId = valorTipoNotalId;
        this.tipoNotaId = tipoNotaId;
        this.titulo = titulo;
        this.alias = alias;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.valorNumerico = valorNumerico;
        this.icono = icono;
    }

    public int getValorTipoNotalId() {
        return valorTipoNotalId;
    }

    public void setValorTipoNotalId(int valorTipoNotalId) {
        this.valorTipoNotalId = valorTipoNotalId;
    }

    public int getTipoNotaId() {
        return tipoNotaId;
    }

    public void setTipoNotaId(int tipoNotaId) {
        this.tipoNotaId = tipoNotaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(double limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public double getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(double limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public double getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(double valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
