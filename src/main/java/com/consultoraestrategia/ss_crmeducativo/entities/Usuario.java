package com.consultoraestrategia.ss_crmeducativo.entities;

import com.consultoraestrategia.ss_crmeducativo.lib.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;


/**
 * Created by irvinmarin on 23/03/2017.
 */
@Table(database = AppDatabase.class)
public class Usuario extends BaseModel {

    @Column
    @PrimaryKey
    int usuarioId;

    @Column
    private int personaId;
    @Column
    private String usuario;
    @Column
    private String password;
    @Column
    boolean estado;


    private List<Entidad> entidades;

    private List<Georeferencia> georeferencias;

    private List<Rol> roles;

    private List<UsuarioRolGeoreferencia> usuarioRolGeoreferencias;

    private List<PersonaGeoreferencia> personaGeoreferencias;


    public Usuario() {
    }

    public Usuario(int usuarioId, int personaId, String usuario, String password, boolean estado, List<Entidad> entidades, List<Georeferencia> georeferencias, List<Rol> roles, List<UsuarioRolGeoreferencia> usuarioRolGeoreferencias, List<PersonaGeoreferencia> personaGeoreferencias) {
        this.usuarioId = usuarioId;
        this.personaId = personaId;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.entidades = entidades;
        this.georeferencias = georeferencias;
        this.roles = roles;
        this.usuarioRolGeoreferencias = usuarioRolGeoreferencias;
        this.personaGeoreferencias = personaGeoreferencias;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }

    public List<Georeferencia> getGeoreferencias() {
        return georeferencias;
    }

    public void setGeoreferencias(List<Georeferencia> georeferencias) {
        this.georeferencias = georeferencias;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<UsuarioRolGeoreferencia> getUsuarioRolGeoreferencias() {
        return usuarioRolGeoreferencias;
    }

    public void setUsuarioRolGeoreferencias(List<UsuarioRolGeoreferencia> usuarioRolGeoreferencias) {
        this.usuarioRolGeoreferencias = usuarioRolGeoreferencias;
    }

    public List<PersonaGeoreferencia> getPersonaGeoreferencias() {
        return personaGeoreferencias;
    }

    public void setPersonaGeoreferencias(List<PersonaGeoreferencia> personaGeoreferencias) {
        this.personaGeoreferencias = personaGeoreferencias;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", personaId=" + personaId +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", estado=" + estado +
                ", entidades=" + entidades +
                ", georeferencias=" + georeferencias +
                ", roles=" + roles +
                ", usuarioRolGeoreferencias=" + usuarioRolGeoreferencias +
                ", personaGeoreferencias=" + personaGeoreferencias +
                '}';
    }
}
