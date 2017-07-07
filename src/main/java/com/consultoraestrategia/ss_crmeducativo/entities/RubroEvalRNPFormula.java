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
public class RubroEvalRNPFormula extends BaseModel {

    @Unique
    @PrimaryKey
    private int rubroFormulaId;
    @Column
    private int rubroEvaluacionPrinId;
    @Column
    private int rubroEvaluacionSecId;
    @Column
    private double peso;

    public RubroEvalRNPFormula() {
    }

    public RubroEvalRNPFormula(int rubroFormulaId, int rubroEvaluacionPrinId, int rubroEvaluacionSecId, double peso) {
        this.rubroFormulaId = rubroFormulaId;
        this.rubroEvaluacionPrinId = rubroEvaluacionPrinId;
        this.rubroEvaluacionSecId = rubroEvaluacionSecId;
        this.peso = peso;
    }

    public int getRubroFormulaId() {
        return rubroFormulaId;
    }

    public void setRubroFormulaId(int rubroFormulaId) {
        this.rubroFormulaId = rubroFormulaId;
    }

    public int getRubroEvaluacionPrinId() {
        return rubroEvaluacionPrinId;
    }

    public void setRubroEvaluacionPrinId(int rubroEvaluacionPrinId) {
        this.rubroEvaluacionPrinId = rubroEvaluacionPrinId;
    }

    public int getRubroEvaluacionSecId() {
        return rubroEvaluacionSecId;
    }

    public void setRubroEvaluacionSecId(int rubroEvaluacionSecId) {
        this.rubroEvaluacionSecId = rubroEvaluacionSecId;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
