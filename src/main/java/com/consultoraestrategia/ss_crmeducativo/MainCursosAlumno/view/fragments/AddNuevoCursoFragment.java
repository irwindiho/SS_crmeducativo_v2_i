package com.consultoraestrategia.ss_crmeducativo.MainCursosAlumno.view.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.consultoraestrategia.ss_crmeducativo.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by irvinmarin on 22/03/2017.
 */

public class AddNuevoCursoFragment extends DialogFragment {

    @BindView(R.id.fabAddclase)
    FloatingActionButton fabAddclase;

    @BindView(R.id.txtCodigoClase)
    EditText txtCodigoClase;

    public AddNuevoCursoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_curso_fragment, container, false);


//        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setTitle("Agregar nueva clase");


        ButterKnife.bind(this, view);
        return view;


    }

    @OnClick(R.id.fabAddclase)
    public void clickAddClase() {
        if (txtCodigoClase.getText().toString().length() == 0) {
            Snackbar.make(getView(), "Ingrese un codigo", Snackbar.LENGTH_LONG).show();
        } else {
            if (!Objects.equals(txtCodigoClase.getText().toString(), "111111    ")) {
                Snackbar.make(getView(), "clase no existe", Snackbar.LENGTH_LONG).show();
            } else {
                dismiss();
                getActivity().recreate();
            }
        }

    }
}


