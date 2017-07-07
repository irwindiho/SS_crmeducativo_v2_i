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
public class Periodo extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    int periodoId;
    @Column
    private String nombre;
    @Column
    private boolean activo;
    @Column
    private int estadoId;

    public Periodo() {
    }

    public Periodo(int periodoId, String nombre, boolean activo, int estadoId) {
        this.periodoId = periodoId;
        this.nombre = nombre;
        this.activo = activo;
        this.estadoId = estadoId;
    }

    public long getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(int periodoId) {
        this.periodoId = periodoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }
}
