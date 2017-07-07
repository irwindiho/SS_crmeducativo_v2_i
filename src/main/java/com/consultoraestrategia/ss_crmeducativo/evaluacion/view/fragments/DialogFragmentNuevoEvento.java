package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 24/03/2017.
 */

public class DialogFragmentNuevoEvento extends DialogFragment {

    ImageLoader imageLoader;
    View viewPadre;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public View onCreateDialogView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.dialog_fragment_nuevo_evento, container);
        ButterKnife.bind(this, viewPadre);
        return viewPadre;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // setup dialog: buttons, title etc
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle("Nuevo Evento")

                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        }
                )
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        }
                );

        // call default fragment methods and set view for dialog
        View view = onCreateDialogView(getActivity().getLayoutInflater(), null, null);
        onViewCreated(view, null);
        dialogBuilder.setView(view);


        return dialogBuilder.create();
    }


}
