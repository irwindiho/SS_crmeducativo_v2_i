package com.consultoraestrategia.ss_crmeducativo.entities;

import com.consultoraestrategia.ss_crmeducativo.lib.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 23/06/2017.
 */
@Table(database = AppDatabase.class)
public class TipoNota extends BaseModel {
    @PrimaryKey
    private int tipoNotaId;
    @Column
    private String nombre;
    @Column
    private int tipoId;
    @Column
    private String valorDefecto;
    @Column
    private int valorMaximo;
    @Column
    private int valorMinino;
    @Column
    private double longitudPaso;
    @Column
    private int usuarioCreadorId;
    @Column
    private String fechaCreacion;
    @Column
    private int usuarioAccionId;
    @Column
    private String fechaAccion;
    @Column
    private boolean intervalo;
    @Column
    private boolean estatico;
    @Column
    private int entidadId;
    @Column
    private int georeferenciaId;
    @Column
    private int organigramaId;

    public TipoNota() {
    }

    public TipoNota(int tipoNotaId, String nombre, int tipoId, String valorDefecto, int valorMaximo, int valorMinino, double longitudPaso, int usuarioCreadorId, String fechaCreacion, int usuarioAccionId, String fechaAccion, boolean intervalo, boolean estatico, int entidadId, int georeferenciaId, int organigramaId) {
        this.tipoNotaId = tipoNotaId;
        this.nombre = nombre;
        this.tipoId = tipoId;
        this.valorDefecto = valorDefecto;
        this.valorMaximo = valorMaximo;
        this.valorMinino = valorMinino;
        this.longitudPaso = longitudPaso;
        this.usuarioCreadorId = usuarioCreadorId;
        this.fechaCreacion = fechaCreacion;
        this.usuarioAccionId = usuarioAccionId;
        this.fechaAccion = fechaAccion;
        this.intervalo = intervalo;
        this.estatico = estatico;
        this.entidadId = entidadId;
        this.georeferenciaId = georeferenciaId;
        this.organigramaId = organigramaId;
    }

    public int getTipoNotaId() {
        return tipoNotaId;
    }

    public void setTipoNotaId(int tipoNotaId) {
        this.tipoNotaId = tipoNotaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public String getValorDefecto() {
        return valorDefecto;
    }

    public void setValorDefecto(String valorDefecto) {
        this.valorDefecto = valorDefecto;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public int getValorMinino() {
        return valorMinino;
    }

    public void setValorMinino(int valorMinino) {
        this.valorMinino = valorMinino;
    }

    public double getLongitudPaso() {
        return longitudPaso;
    }

    public void setLongitudPaso(double longitudPaso) {
        this.longitudPaso = longitudPaso;
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

    public boolean isIntervalo() {
        return intervalo;
    }

    public void setIntervalo(boolean intervalo) {
        this.intervalo = intervalo;
    }

    public boolean isEstatico() {
        return estatico;
    }

    public void setEstatico(boolean estatico) {
        this.estatico = estatico;
    }

    public int getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(int entidadId) {
        this.entidadId = entidadId;
    }

    public int getGeoreferenciaId() {
        return georeferenciaId;
    }

    public void setGeoreferenciaId(int georeferenciaId) {
        this.georeferenciaId = georeferenciaId;
    }

    public int getOrganigramaId() {
        return organigramaId;
    }

    public void setOrganigramaId(int organigramaId) {
        this.organigramaId = organigramaId;
    }
}
