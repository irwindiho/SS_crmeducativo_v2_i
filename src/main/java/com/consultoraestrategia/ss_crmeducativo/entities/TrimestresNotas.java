package com.consultoraestrategia.ss_crmeducativo.entities;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kelvi on 28/02/2017.
 */

public class TrimestresNotas {
    private int columna;
    private CheckBox checkBox;
    private List<EditText> editTexts;
    private List<TextView> textViews;

    public TrimestresNotas() {
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public TrimestresNotas(int columna, CheckBox checkBox, List<EditText> editTexts) {
        this.columna = columna;
        this.checkBox = checkBox;
        this.editTexts = editTexts;
    }

    public List<TextView> getTextViews() {
        return textViews;
    }

    public void setTextViews(List<TextView> textViews) {
        this.textViews = textViews;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public List<EditText> getEditTexts() {
        return editTexts;
    }

    public void setEditTexts(List<EditText> editTexts) {
        this.editTexts = editTexts;
    }
}
