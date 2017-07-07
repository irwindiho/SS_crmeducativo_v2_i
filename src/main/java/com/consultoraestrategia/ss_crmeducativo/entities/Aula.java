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
public class Aula extends BaseModel {


    @PrimaryKey
    private int aulaId;
    @Column
    private String descripcion;
    @Column
    private String numero;
    @Column
    private int capacidadId;
    @Column
    private boolean estado;

    public Aula() {
    }


    public Aula(int aulaId, String descripcion, String numero, int capacidadId, boolean estado) {
        this.aulaId = aulaId;
        this.descripcion = descripcion;
        this.numero = numero;
        this.capacidadId = capacidadId;
        this.estado = estado;
    }

    public int getAulaId() {
        return aulaId;
    }

    public void setAulaId(int aulaId) {
        this.aulaId = aulaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacidadId() {
        return capacidadId;
    }

    public void setCapacidadId(int capacidadId) {
        this.capacidadId = capacidadId;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
