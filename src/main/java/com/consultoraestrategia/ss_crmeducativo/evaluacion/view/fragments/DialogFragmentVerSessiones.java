package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.TabsCursoDocente.view.interfacesUtils.OnDialogVerSesionListener;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 24/03/2017.
 */

public class DialogFragmentVerSessiones extends DialogFragment {
    OnDialogVerSesionListener listener;


    ImageLoader imageLoader;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // do something with 'view'
    }

    public View onCreateDialogView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_fragment_ver_justificado, container);



        ButterKnife.bind(this, v);

        return v;
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

//        final ArrayList itemsSeleccionados = new ArrayList();

        final CharSequence[] items = new CharSequence[4];
        final String[] fechas = new String[4];


        fechas[0] = "10/03/2017";
        fechas[1] = "17/03/2017";
        fechas[2] = "24/03/2017";
        fechas[3] = "31/03/2017";

        items[0] = "Session 1 :" + fechas[0];
        items[1] = "Session 2 : " + fechas[1];
        items[2] = "Session 3 : " + fechas[2];
        items[3] = "Session 4 : " + fechas[3];


        // setup dialog: buttons, title etc
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle("Sesiones")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Session : " + items[which], Toast.LENGTH_LONG).show();
                        listener.onPossitiveButtonClick(fechas[which], which+1);
                    }
                })

                .setNegativeButton("Salir",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                listener.onNegativeButtonClick();
                                dialog.dismiss();
                            }
                        }
                );


        return dialogBuilder.create();
    }
}
