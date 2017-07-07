package com.consultoraestrategia.ss_crmeducativo.entities;

import com.consultoraestrategia.ss_crmeducativo.lib.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 29/06/2017.
 */
@Table(database = AppDatabase.class)
public class RecursoDidacticoEvento extends BaseModel {

    @Unique
    @PrimaryKey
    private int recursoDidacticoId;
    @Column
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private int tipoId;
    @Column
    private int silaboEventoId;
    @Column
    private int unidadAprendizajeId;
    @Column
    private int sesionAprendizajeId;
    @Column
    private int actividadAprendizajeId;
    @Column
    private boolean estado;
    @Column
    private int usuarioCreador;
    @Column
    private String fechaCreacion;
    @Column
    private int usuarioAccion;
    @Column
    private String fechaAccion;
    @Column
    private int planCursoId;

    public RecursoDidacticoEvento() {
    }

    public RecursoDidacticoEvento(int recursoDidacticoId, String titulo, String descripcion, int tipoId, int silaboEventoId, int unidadAprendizajeId, int sesionAprendizajeId, int actividadAprendizajeId, boolean estado, int usuarioCreador, String fechaCreacion, int usuarioAccion, String fechaAccion, int planCursoId) {
        this.recursoDidacticoId = recursoDidacticoId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipoId = tipoId;
        this.silaboEventoId = silaboEventoId;
        this.unidadAprendizajeId = unidadAprendizajeId;
        this.sesionAprendizajeId = sesionAprendizajeId;
        this.actividadAprendizajeId = actividadAprendizajeId;
        this.estado = estado;
        this.usuarioCreador = usuarioCreador;
        this.fechaCreacion = fechaCreacion;
        this.usuarioAccion = usuarioAccion;
        this.fechaAccion = fechaAccion;
        this.planCursoId = planCursoId;
    }

    public int getRecursoDidacticoId() {
        return recursoDidacticoId;
    }

    public void setRecursoDidacticoId(int recursoDidacticoId) {
        this.recursoDidacticoId = recursoDidacticoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public int getSilaboEventoId() {
        return silaboEventoId;
    }

    public void setSilaboEventoId(int silaboEventoId) {
        this.silaboEventoId = silaboEventoId;
    }

    public int getUnidadAprendizajeId() {
        return unidadAprendizajeId;
    }

    public void setUnidadAprendizajeId(int unidadAprendizajeId) {
        this.unidadAprendizajeId = unidadAprendizajeId;
    }

    public int getSesionAprendizajeId() {
        return sesionAprendizajeId;
    }

    public void setSesionAprendizajeId(int sesionAprendizajeId) {
        this.sesionAprendizajeId = sesionAprendizajeId;
    }

    public int getActividadAprendizajeId() {
        return actividadAprendizajeId;
    }

    public void setActividadAprendizajeId(int actividadAprendizajeId) {
        this.actividadAprendizajeId = actividadAprendizajeId;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    public int getPlanCursoId() {
        return planCursoId;
    }

    public void setPlanCursoId(int planCursoId) {
        this.planCursoId = planCursoId;
    }
}
