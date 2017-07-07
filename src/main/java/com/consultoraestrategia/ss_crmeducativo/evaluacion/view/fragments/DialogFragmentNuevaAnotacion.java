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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.interfaces.OnAnotacionAccion;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 24/03/2017.
 */

public class DialogFragmentNuevaAnotacion extends DialogFragment {

    private static final String TAG = "DialogFragmentNuevaAnotacion";
    View viewPadre;
    ImageLoader imageLoader;
    @BindView(R.id.txtReferenciaAnotacion)
    TextView txtReferenciaAnotacion;
    @BindView(R.id.txtTitulo)
    EditText txtTitulo;
    @BindView(R.id.txtEtiquetas)
    EditText txtEtiquetas;
    @BindView(R.id.txtLLamarUrgente)
    EditText txtLLamarUrgente;
    @BindView(R.id.txtTexto)
    EditText txtTexto;
    OnAnotacionAccion onAnotacionAccion;
    int idAlumno;


    public DialogFragmentNuevaAnotacion newInstance(OnAnotacionAccion onAnotacionAccion) {
        this.onAnotacionAccion = onAnotacionAccion;
        return new DialogFragmentNuevaAnotacion();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // do something with 'view'
    }

    String TitleDialog;

    public View onCreateDialogView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.dialog_fragment_nueva_anotacion, container);
        ButterKnife.bind(this, viewPadre);

        setupDatosAlumno();

        return viewPadre;
    }

    private void setupDatosAlumno() {
        if (getArguments() != null) {
            idAlumno = getArguments().getInt("idAlumno");
            String refereciaCurso = getArguments().getString("NombreCurso");
            String Titulo = getArguments().getString("Titulo");
            String NombreDocente = getArguments().getString("NombreDocente");
            String Content = getArguments().getString("Content");
            txtReferenciaAnotacion.setText(refereciaCurso + " > " + NombreDocente);
            txtTitulo.setText(Titulo);
            txtTexto.setText(Content);
        }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        imageLoader = new GlideImageLoader(getActivity().getApplicationContext());

        if (getArguments() != null) {
            TitleDialog = "Editar Anotacion";
        } else {
            TitleDialog = "Nueva Anotacion";
        }


        // setup dialog: buttons, title etc
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle(TitleDialog)

                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
//                                onAnotacionAccion.setOnDataChange("Cancelado");
                                dismiss();
                            }
                        }
                )
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dismiss();

//                                onAnotacionAccion.setOnDataChange("Guardado");
                                getParentFragment().onDestroyView();
                                DialogFragment dialogFragment = new TabsFragmentVerAlumnoDetalle();
                                Bundle bundle = new Bundle();
                                bundle.putInt("idAlumno", idAlumno);
                                bundle.putInt("nroTab", 2);
                                dialogFragment.setArguments(bundle);
                                dialogFragment.show(getActivity().getSupportFragmentManager(), TAG);
                                Toast.makeText(getContext(), "Anotacion Guardada", Toast.LENGTH_LONG).show();
                            }
                        }
                );

        // call default fragment methods and set view for dialog
        View view = onCreateDialogView(getActivity().getLayoutInflater(), null, null);
        onViewCreated(view, null);
        dialogBuilder.setView(view);


        return dialogBuilder.create();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }
}
