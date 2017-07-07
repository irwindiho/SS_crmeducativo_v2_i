package com.consultoraestrategia.ss_crmeducativo.entities;

import com.consultoraestrategia.ss_crmeducativo.lib.FlowMangerImpl;


/**
 * Created by kelvi on 03/03/2017.
 */
public class Personas {
    private int id;

    private String codModular;

    private String numDoc;

    private String nombres;

    private String apellidoMaterno;

    private String apellidoPaterno;

    private String telefono;

    private String celular;

    private String fechaNac;

    private String correo;

    private String genero;

    private String estadoCivil;

    private String ocupacion;

    private int tipoPersonaId;

    private int tipoDocId;

    private int usuarioAccionId;

    private int estadoId;

    private int nivelAcademicoId;

    private String fechaCreacion;

    private String fechaActualizacion;

    private int empresaId;

    private int usuarioCreadorId;

    private int cicloVidaCliId;

    private int geoReferenciaId;

    private String facebook;

    private int nivelInteresId;

    private boolean carreraDefinida;

    private String universidadDefinida;

    private int informacionUniv;

    private String posicion;

    private int campañaOrId;

    private boolean matMarketing;

    private int formaContactoId;

    private boolean permCorreo;

    private boolean permTel;

    private int origenCliId;

    private String observacion;

    private boolean contacto;

    private int cntSupPrefId;

    private int condicionEconomicaId;

    private double resultadoNota;

    private int periodoId;

    private int faseActualId;

    private int organigramaId;

    private int programaEducativoId;

    private String foto;

    public int estado;

    public Personas() {
    }

    public Personas(int id, String nombres, String apellidoMaterno, String apellidoPaterno, String urlImagen) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.foto = urlImagen;
    }

    public Personas(int id, String codModular, String numDoc, String nombres, String apellidoMaterno, String apellidoPaterno, String telefono, String celular, String fechaNac, String correo, String genero, String estadoCivil, String ocupacion, int tipoPersonaId, int tipoDocId, int usuarioAccionId, int estadoId, int nivelAcademicoId, String fechaCreacion, String fechaActualizacion, int empresaId, int usuarioCreadorId, int cicloVidaCliId, int geoReferenciaId, String facebook, int nivelInteresId, boolean carreraDefinida, String universidadDefinida, int informacionUniv, String posicion, int campañaOrId, boolean matMarketing, int formaContactoId, boolean permCorreo, boolean permTel, int origenCliId, String observacion, boolean contacto, int cntSupPrefId, int condicionEconomicaId, double resultadoNota, int periodoId, int faseActualId, int organigramaId, int programaEducativoId, String foto) {
        this.id = id;
        this.codModular = codModular;
        this.numDoc = numDoc;
        this.nombres = nombres;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.telefono = telefono;
        this.celular = celular;
        this.fechaNac = fechaNac;
        this.correo = correo;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.ocupacion = ocupacion;
        this.tipoPersonaId = tipoPersonaId;
        this.tipoDocId = tipoDocId;
        this.usuarioAccionId = usuarioAccionId;
        this.estadoId = estadoId;
        this.nivelAcademicoId = nivelAcademicoId;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.empresaId = empresaId;
        this.usuarioCreadorId = usuarioCreadorId;
        this.cicloVidaCliId = cicloVidaCliId;
        this.geoReferenciaId = geoReferenciaId;
        this.facebook = facebook;
        this.nivelInteresId = nivelInteresId;
        this.carreraDefinida = carreraDefinida;
        this.universidadDefinida = universidadDefinida;
        this.informacionUniv = informacionUniv;
        this.posicion = posicion;
        this.campañaOrId = campañaOrId;
        this.matMarketing = matMarketing;
        this.formaContactoId = formaContactoId;
        this.permCorreo = permCorreo;
        this.permTel = permTel;
        this.origenCliId = origenCliId;
        this.observacion = observacion;
        this.contacto = contacto;
        this.cntSupPrefId = cntSupPrefId;
        this.condicionEconomicaId = condicionEconomicaId;
        this.resultadoNota = resultadoNota;
        this.periodoId = periodoId;
        this.faseActualId = faseActualId;
        this.organigramaId = organigramaId;
        this.programaEducativoId = programaEducativoId;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodModular() {
        return codModular;
    }

    public void setCodModular(String codModular) {
        this.codModular = codModular;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getTipoPersonaId() {
        return tipoPersonaId;
    }

    public void setTipoPersonaId(int tipoPersonaId) {
        this.tipoPersonaId = tipoPersonaId;
    }

    public int getTipoDocId() {
        return tipoDocId;
    }

    public void setTipoDocId(int tipoDocId) {
        this.tipoDocId = tipoDocId;
    }

    public int getUsuarioAccionId() {
        return usuarioAccionId;
    }

    public void setUsuarioAccionId(int usuarioAccionId) {
        this.usuarioAccionId = usuarioAccionId;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public int getNivelAcademicoId() {
        return nivelAcademicoId;
    }

    public void setNivelAcademicoId(int nivelAcademicoId) {
        this.nivelAcademicoId = nivelAcademicoId;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getUsuarioCreadorId() {
        return usuarioCreadorId;
    }

    public void setUsuarioCreadorId(int usuarioCreadorId) {
        this.usuarioCreadorId = usuarioCreadorId;
    }

    public int getCicloVidaCliId() {
        return cicloVidaCliId;
    }

    public void setCicloVidaCliId(int cicloVidaCliId) {
        this.cicloVidaCliId = cicloVidaCliId;
    }

    public int getGeoReferenciaId() {
        return geoReferenciaId;
    }

    public void setGeoReferenciaId(int geoReferenciaId) {
        this.geoReferenciaId = geoReferenciaId;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public int getNivelInteresId() {
        return nivelInteresId;
    }

    public void setNivelInteresId(int nivelInteresId) {
        this.nivelInteresId = nivelInteresId;
    }

    public boolean isCarreraDefinida() {
        return carreraDefinida;
    }

    public void setCarreraDefinida(boolean carreraDefinida) {
        this.carreraDefinida = carreraDefinida;
    }

    public String getUniversidadDefinida() {
        return universidadDefinida;
    }

    public void setUniversidadDefinida(String universidadDefinida) {
        this.universidadDefinida = universidadDefinida;
    }

    public int getInformacionUniv() {
        return informacionUniv;
    }

    public void setInformacionUniv(int informacionUniv) {
        this.informacionUniv = informacionUniv;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getCampañaOrId() {
        return campañaOrId;
    }

    public void setCampañaOrId(int campañaOrId) {
        this.campañaOrId = campañaOrId;
    }

    public boolean isMatMarketing() {
        return matMarketing;
    }

    public void setMatMarketing(boolean matMarketing) {
        this.matMarketing = matMarketing;
    }

    public int getFormaContactoId() {
        return formaContactoId;
    }

    public void setFormaContactoId(int formaContactoId) {
        this.formaContactoId = formaContactoId;
    }

    public boolean isPermCorreo() {
        return permCorreo;
    }

    public void setPermCorreo(boolean permCorreo) {
        this.permCorreo = permCorreo;
    }

    public boolean isPermTel() {
        return permTel;
    }

    public void setPermTel(boolean permTel) {
        this.permTel = permTel;
    }

    public int getOrigenCliId() {
        return origenCliId;
    }

    public void setOrigenCliId(int origenCliId) {
        this.origenCliId = origenCliId;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean isContacto() {
        return contacto;
    }

    public void setContacto(boolean contacto) {
        this.contacto = contacto;
    }

    public int getCntSupPrefId() {
        return cntSupPrefId;
    }

    public void setCntSupPrefId(int cntSupPrefId) {
        this.cntSupPrefId = cntSupPrefId;
    }

    public int getCondicionEconomicaId() {
        return condicionEconomicaId;
    }

    public void setCondicionEconomicaId(int condicionEconomicaId) {
        this.condicionEconomicaId = condicionEconomicaId;
    }

    public double getResultadoNota() {
        return resultadoNota;
    }

    public void setResultadoNota(double resultadoNota) {
        this.resultadoNota = resultadoNota;
    }

    public int getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(int periodoId) {
        this.periodoId = periodoId;
    }

    public int getFaseActualId() {
        return faseActualId;
    }

    public void setFaseActualId(int faseActualId) {
        this.faseActualId = faseActualId;
    }

    public int getOrganigramaId() {
        return organigramaId;
    }

    public void setOrganigramaId(int organigramaId) {
        this.organigramaId = organigramaId;
    }

    public int getProgramaEducativoId() {
        return programaEducativoId;
    }

    public void setProgramaEducativoId(int programaEducativoId) {
        this.programaEducativoId = programaEducativoId;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}

