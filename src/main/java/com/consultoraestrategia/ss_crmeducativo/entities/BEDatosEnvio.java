package com.consultoraestrategia.ss_crmeducativo.entities;


import java.util.List;

/**
 * Created by irvinmarin on 13/04/2017.
 */

public class BEDatosEnvio {
    public List<AnioAcademico> anioAcademicos;
    public List<Contrato> contratos;
    public List<DetalleContratoAcad> detalleContratoAcad;
    public List<CargaAcademica> cargasAcademicas;
    public List<CargaCursos> cargaCursos;
    public List<Empleado> empleados;
    public List<PlanCursos> planCursos;
    public List<Cursos> cursos;
    public List<Periodo> periodos;
    public List<Seccion> secciones;
    public List<Aula> aulas;
    public List<CuentaCorriente> cuentaCorriente;
    public List<ProgramasEducativo> programasEducativos;
    public List<NivelAcademico> nivelesAcademicos;
    public List<PlanEstudios> planEstudios;
    public List<PlanesEstudiosAlumno> planEstudiosAlumno;
    public List<PlanCursosAlumno> planCursosAlumno;
    public List<Estados> estados;
    public List<Tipos> tipos;
    public List<Persona> personas;
    public List<Relaciones> relaciones;
    public List<Competencia> competencias;
    public List<CursoCompetencia> cursoCompetencias;
    public List<CalendarioAcademico> calendarioAcademicos;
    public List<CalendarioPeriodo> calendarioPeriodos;
    public List<DesarrolloCompetenciaCurso> desarrolloCompetenciaCursos;
    public List<EvaluacionCapacidad> evaluacionCapacidades;

    //--------------------------------------------------------
    public List<SilaboEvento> silaboEvento;
    public List<RecursoDidacticoEvento> recursoDidactico;
    public List<TipoNota> tipoNota;
    public List<ValorTipoNota> valorTipoNota;
    public List<ColorCondicional> colorCondicional;
    public List<RubroEvaluacionResultado> rubroEvaluacionResultado;
    public List<RubroEvalRNRFormula> rubroEvalResultadoFormula;
    public List<RubroEvaluacionProceso> rubroEvaluacionProceso;
    public List<RubroEvalRNPFormula> rubroEvalProcesoFormula;
    public List<EvaluacionResultado> evaluacionResultado;
    public List<EvaluacionProceso> evaluacionProceso;

//    anioAcademicos = new List<BEAnioAcademico>();
//    contratos = new List<BEContrato>();
//    detalleContratoAcad = new List<BEDetalleContratoAcad>();
//    cargasAcademicas = new List<BECargaAcademica>();
//    cargaCursos = new List<BECargaCursos>();
//    empleados = new List<BEEmpleado>();
//    planCursos = new List<BEPlanCursos>();
//    cursos = new List<BECursos>();
//    periodos = new List<BEPeriodos>();
//    secciones = new List<BESeccion>();
//    aulas = new List<BEAula>();
//    cuentaCorriente = new List<BECuentaCorriente>();
//    programasEducativos = new List<BEProgramasEducativo>();
//    nivelesAcademicos = new List<BENivelAcademico>();
//    planEstudios = new List<BEPlanEstudios>();
//    planEstudiosAlumno = new List<BEPlanEstudiosAlumno>();
//    planCursosAlumno = new List<BEPlanCursosAlumno>();
//    estados = new List<BEEstados>();
//    tipos = new List<BETipos>();
//    personas = new List<BEPersona>();
//    relaciones = new List<BERelaciones>();
//    competencias = new List<BECompetencia>();
//    cursoCompetencias = new List<BECursoCompetencia>();
//    calendarioAcademicos = new List<BECalendarioAcademico>();
//    calendarioPeriodos = new List<BECalendarioPeriodo>();
//    desarrolloCompetenciaCursos = new List<BEDesarrolloCompetenciaCurso>();
//    evaluacionCapacidades = new List<BEEvaluacionCapacidad>();
//    //--------------------------------------------------------
//    silaboEvento = new List<BESilaboEvento>();
//    recursoDidactico = new List<BERecursoDidactico_Evento>();
//    tipoNota = new List<BETipoNota>();
//    valorTipoNota = new List<BEValorTipoNota>();
//    colorCondicional = new List<BEColorCondicional>();
//    rubroEvaluacionResultado = new List<BERubroEvaluacionResultado>();
//    rubroEvalResultadoFormula = new List<BERubroEval_RNR_Formula>();
//    rubroEvaluacionProceso = new List<BERubroEvaluacionProceso>();
//    rubroEvalProcesoFormula = new List<BERubroEval_RNP_Formula>();
//    evaluacionResultado = new List<BEEvaluacionResultado>();
//    evaluacionProceso = new List<BEEvaluacionProceso>();


    public BEDatosEnvio() {
    }



    public List<SilaboEvento> getSilaboEvento() {
        return silaboEvento;
    }

    public void setSilaboEvento(List<SilaboEvento> silaboEvento) {
        this.silaboEvento = silaboEvento;
    }

    public List<RecursoDidacticoEvento> getRecursoDidactico() {
        return recursoDidactico;
    }

    public void setRecursoDidactico(List<RecursoDidacticoEvento> recursoDidactico) {
        this.recursoDidactico = recursoDidactico;
    }

    public List<TipoNota> getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(List<TipoNota> tipoNota) {
        this.tipoNota = tipoNota;
    }

    public List<ValorTipoNota> getValorTipoNota() {
        return valorTipoNota;
    }

    public void setValorTipoNota(List<ValorTipoNota> valorTipoNota) {
        this.valorTipoNota = valorTipoNota;
    }

    public List<ColorCondicional> getColorCondicional() {
        return colorCondicional;
    }

    public void setColorCondicional(List<ColorCondicional> colorCondicional) {
        this.colorCondicional = colorCondicional;
    }

    public List<RubroEvaluacionResultado> getRubroEvaluacionResultado() {
        return rubroEvaluacionResultado;
    }

    public void setRubroEvaluacionResultado(List<RubroEvaluacionResultado> rubroEvaluacionResultado) {
        this.rubroEvaluacionResultado = rubroEvaluacionResultado;
    }

    public List<RubroEvalRNRFormula> getRubroEvalResultadoFormula() {
        return rubroEvalResultadoFormula;
    }

    public void setRubroEvalResultadoFormula(List<RubroEvalRNRFormula> rubroEvalResultadoFormula) {
        this.rubroEvalResultadoFormula = rubroEvalResultadoFormula;
    }

    public List<RubroEvaluacionProceso> getRubroEvaluacionProceso() {
        return rubroEvaluacionProceso;
    }

    public void setRubroEvaluacionProceso(List<RubroEvaluacionProceso> rubroEvaluacionProceso) {
        this.rubroEvaluacionProceso = rubroEvaluacionProceso;
    }

    public List<RubroEvalRNPFormula> getRubroEvalProcesoFormula() {
        return rubroEvalProcesoFormula;
    }

    public void setRubroEvalProcesoFormula(List<RubroEvalRNPFormula> rubroEvalProcesoFormula) {
        this.rubroEvalProcesoFormula = rubroEvalProcesoFormula;
    }

    public List<EvaluacionResultado> getEvaluacionResultado() {
        return evaluacionResultado;
    }

    public void setEvaluacionResultado(List<EvaluacionResultado> evaluacionResultado) {
        this.evaluacionResultado = evaluacionResultado;
    }

    public List<EvaluacionProceso> getEvaluacionProceso() {
        return evaluacionProceso;
    }

    public void setEvaluacionProceso(List<EvaluacionProceso> evaluacionProceso) {
        this.evaluacionProceso = evaluacionProceso;
    }

    public List<AnioAcademico> getAnioAcademicos() {
        return anioAcademicos;
    }

    public void setAnioAcademicos(List<AnioAcademico> anioAcademicos) {
        this.anioAcademicos = anioAcademicos;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public List<DetalleContratoAcad> getDetalleContratoAcad() {
        return detalleContratoAcad;
    }

    public void setDetalleContratoAcad(List<DetalleContratoAcad> detalleContratoAcad) {
        this.detalleContratoAcad = detalleContratoAcad;
    }

    public List<CargaAcademica> getCargasAcademicas() {
        return cargasAcademicas;
    }

    public void setCargasAcademicas(List<CargaAcademica> cargasAcademicas) {
        this.cargasAcademicas = cargasAcademicas;
    }

    public List<CargaCursos> getCargaCursos() {
        return cargaCursos;
    }

    public void setCargaCursos(List<CargaCursos> cargaCursos) {
        this.cargaCursos = cargaCursos;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<PlanCursos> getPlanCursos() {
        return planCursos;
    }

    public void setPlanCursos(List<PlanCursos> planCursos) {
        this.planCursos = planCursos;
    }

    public List<Cursos> getCursos() {
        return cursos;
    }

    public void setCursos(List<Cursos> cursos) {
        this.cursos = cursos;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public List<CuentaCorriente> getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(List<CuentaCorriente> cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public List<ProgramasEducativo> getProgramasEducativos() {
        return programasEducativos;
    }

    public void setProgramasEducativos(List<ProgramasEducativo> programasEducativos) {
        this.programasEducativos = programasEducativos;
    }

    public List<NivelAcademico> getNivelesAcademicos() {
        return nivelesAcademicos;
    }

    public void setNivelesAcademicos(List<NivelAcademico> nivelesAcademicos) {
        this.nivelesAcademicos = nivelesAcademicos;
    }

    public List<PlanEstudios> getPlanEstudios() {
        return planEstudios;
    }

    public void setPlanEstudios(List<PlanEstudios> planEstudios) {
        this.planEstudios = planEstudios;
    }

    public List<PlanesEstudiosAlumno> getPlanEstudiosAlumno() {
        return planEstudiosAlumno;
    }

    public void setPlanEstudiosAlumno(List<PlanesEstudiosAlumno> planEstudiosAlumno) {
        this.planEstudiosAlumno = planEstudiosAlumno;
    }

    public List<PlanCursosAlumno> getPlanCursosAlumno() {
        return planCursosAlumno;
    }

    public void setPlanCursosAlumno(List<PlanCursosAlumno> planCursosAlumno) {
        this.planCursosAlumno = planCursosAlumno;
    }

    public List<Estados> getEstados() {
        return estados;
    }

    public void setEstados(List<Estados> estados) {
        this.estados = estados;
    }

    public List<Tipos> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipos> tipos) {
        this.tipos = tipos;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Relaciones> getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(List<Relaciones> relaciones) {
        this.relaciones = relaciones;
    }

    public List<Competencia> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<Competencia> competencias) {
        this.competencias = competencias;
    }

    public List<CursoCompetencia> getCursoCompetencias() {
        return cursoCompetencias;
    }

    public void setCursoCompetencias(List<CursoCompetencia> cursoCompetencias) {
        this.cursoCompetencias = cursoCompetencias;
    }

    public List<CalendarioAcademico> getCalendarioAcademicos() {
        return calendarioAcademicos;
    }

    public void setCalendarioAcademicos(List<CalendarioAcademico> calendarioAcademicos) {
        this.calendarioAcademicos = calendarioAcademicos;
    }

    public List<CalendarioPeriodo> getCalendarioPeriodos() {
        return calendarioPeriodos;
    }

    public void setCalendarioPeriodos(List<CalendarioPeriodo> calendarioPeriodos) {
        this.calendarioPeriodos = calendarioPeriodos;
    }

    public List<DesarrolloCompetenciaCurso> getDesarrolloCompetenciaCursos() {
        return desarrolloCompetenciaCursos;
    }

    public void setDesarrolloCompetenciaCursos(List<DesarrolloCompetenciaCurso> desarrolloCompetenciaCursos) {
        this.desarrolloCompetenciaCursos = desarrolloCompetenciaCursos;
    }

    public List<EvaluacionCapacidad> getEvaluacionCapacidades() {
        return evaluacionCapacidades;
    }

    public void setEvaluacionCapacidades(List<EvaluacionCapacidad> evaluacionCapacidades) {
        this.evaluacionCapacidades = evaluacionCapacidades;
    }
}
