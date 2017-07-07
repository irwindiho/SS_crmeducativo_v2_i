package com.consultoraestrategia.ss_crmeducativo.entities;

/**
 * Created by irvinmarin on 22/05/2017.
 */

public class Justificacion   {


    private int justificacionId;

    private long asistenciaId;

    private String descripcion;

    private int tipoJustificacionId;

    private int usuarioCreador;

    private String fechaCreacion;

    private int usuarioAccion;

    private String fechaAccion;

    public Justificacion(int justificacionId, long asistenciaId, String descripcion, int tipoJustificacionId, int usuarioCreador, String fechaCreacion, int usuarioAccion, String fechaAccion) {
        this.justificacionId = justificacionId;
        this.asistenciaId = asistenciaId;
        this.descripcion = descripcion;
        this.tipoJustificacionId = tipoJustificacionId;
        this.usuarioCreador = usuarioCreador;
        this.fechaCreacion = fechaCreacion;
        this.usuarioAccion = usuarioAccion;
        this.fechaAccion = fechaAccion;
    }

    public int getJustificacionId() {
        return justificacionId;
    }

    public void setJustificacionId(int justificacionId) {
        this.justificacionId = justificacionId;
    }

    public long getAsistenciaId() {
        return asistenciaId;
    }

    public void setAsistenciaId(long asistenciaId) {
        this.asistenciaId = asistenciaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipoJustificacionId() {
        return tipoJustificacionId;
    }

    public void setTipoJustificacionId(int tipoJustificacionId) {
        this.tipoJustificacionId = tipoJustificacionId;
    }

    public int getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(int usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getUsuarioAccion() {
        return usuarioAccion;
    }

    public void setUsuarioAccion(int usuarioAccion) {
        this.usuarioAccion = usuarioAccion;
    }

    public String getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(String fechaAccion) {
        this.fechaAccion = fechaAccion;
    }
}
