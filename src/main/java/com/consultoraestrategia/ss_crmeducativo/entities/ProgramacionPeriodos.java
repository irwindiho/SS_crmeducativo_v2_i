package com.consultoraestrategia.ss_crmeducativo.entities;

public class ProgramacionPeriodos   {


    private int progPeriodoId;
    private int periodoId;
    private String fechaInicio;
    private String fechaFin;
    private int programaEduId;

    public ProgramacionPeriodos() {
    }

    public ProgramacionPeriodos(int progPeriodoId, int periodoId, String fechaInicio, String fechaFin, int programaEduId) {
        this.progPeriodoId = progPeriodoId;
        this.periodoId = periodoId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.programaEduId = programaEduId;
    }

    public int getProgPeriodoId() {
        return progPeriodoId;
    }

    public void setProgPeriodoId(int progPeriodoId) {
        this.progPeriodoId = progPeriodoId;
    }

    public int getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(int periodoId) {
        this.periodoId = periodoId;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getProgramaEduId() {
        return programaEduId;
    }

    public void setProgramaEduId(int programaEduId) {
        this.programaEduId = programaEduId;
    }


}
