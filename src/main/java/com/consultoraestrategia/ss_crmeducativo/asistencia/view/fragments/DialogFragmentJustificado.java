package com.consultoraestrategia.ss_crmeducativo.asistencia.view.fragments;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.view.interfacesUtils.OnDialogVerSesionListener;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by irvinmarin on 24/03/2017.
 */

public class DialogFragmentJustificado extends DialogFragment {
    OnDialogVerSesionListener listener;
    ImageLoader imageLoader;
    @BindView(R.id.spnJustificacion)
    AppCompatSpinner spnJustificacion;
    @BindView(R.id.txtDescripcionJustificacion)
    AppCompatEditText txtDescripcionJustificacion;
    Unbinder unbinder;
    View viewPadre;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // do something with 'view'
    }

    public View onCreateDialogView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.dialog_fragment_ver_justificado, container);
        ButterKnife.bind(this, viewPadre);
        return viewPadre;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnDialogVerSesionListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(
                    activity.toString() +
                            " no implementó OnSimpleDialogListener");

        }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        // setup dialog: buttons, title etc
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle("Justificación")

                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        }
                )
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
//
                                if ("".equals(txtDescripcionJustificacion.getText().toString())) {
                                    Snackbar.make(viewPadre, "Escriba una justificacíon", Snackbar.LENGTH_LONG).show();
                                } else {
                                    dismiss();
                                }
                            }
                        }
                );

        // call default fragment methods and set view for dialog
        View view = onCreateDialogView(getActivity().getLayoutInflater(), null, null);
        onViewCreated(view, null);
        dialogBuilder.setView(view);

        txtDescripcionJustificacion.setEnabled(false);
        spnJustificacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    txtDescripcionJustificacion.setEnabled(true);
                } else {
                    txtDescripcionJustificacion.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return dialogBuilder.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        return rootView;
    }


}
