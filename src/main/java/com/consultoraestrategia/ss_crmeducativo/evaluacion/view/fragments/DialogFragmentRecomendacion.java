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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Relaciones;
import com.consultoraestrategia.ss_crmeducativo.entities.Relaciones_Table;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by irvinmarin on 24/03/2017.
 */

public class DialogFragmentRecomendacion extends DialogFragment {


    ImageLoader imageLoader;
    @BindView(R.id.imgProfileRecomendacion)
    ImageView imgProfileRecomendacion;
    @BindView(R.id.txtNombreAlumno)
    TextView txtNombreAlumno;
    @BindView(R.id.txtNombreCapacidad)
    TextView txtNombreCapacidad;
    @BindView(R.id.txtMensajeComentaio)
    EditText txtMensajeComentaio;

    View viewPadre;
    @BindView(R.id.botVerDesitnoMedio)
    ImageButton botVerDesitnoMedio;
    @BindView(R.id.txtNombrePadre)
    CheckBox txtNombrePadre;
    @BindView(R.id.txtNombreMadre)
    CheckBox txtNombreMadre;
    @BindView(R.id.txtNombreTutor)
    CheckBox txtNombreTutor;
    @BindView(R.id.contentExtent)
    LinearLayout contentExtent;
    Persona padre;
    Persona madre;
    Persona alumno;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // do something with 'view'
    }

    public View onCreateDialogView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.dialog_fragment_recomendacion, container);


        ButterKnife.bind(this, viewPadre);
        imageLoader = new GlideImageLoader(getActivity().getApplicationContext());


        String nombreAlumno = getArguments().getString("nombreAlumno");
        String idAlumno = getArguments().getString("idAlumno");
        String nombreCompetencia = getArguments().getString("nombreCompetencia");
        String urlImage = getArguments().getString("urlImage");

        alumno = SQLite.select()
                .from(Persona.class)
                .where(Persona_Table.personaId.is(Integer.parseInt(idAlumno)))
                .querySingle();

        List<Relaciones> relaciones = SQLite.select()
                .from(Relaciones.class)
                .where(Relaciones_Table.personaPrincipalId.is(alumno.getPersonaId()))
                .queryList();

        for (int i = 0; i < relaciones.size(); i++) {
            if (relaciones.get(i).getTipoId() == 181) {
                padre = SQLite.select()
                        .from(Persona.class)
                        .where(Persona_Table.personaId.is(relaciones.get(i).getPersonaVinculadaId()))
                        .querySingle();
            }
            if (relaciones.get(i).getTipoId() == 182) {
                madre = SQLite.select()
                        .from(Persona.class)
                        .where(Persona_Table.personaId.is(relaciones.get(i).getPersonaVinculadaId()))
                        .querySingle();
            }
        }


        if (padre != null) {
            txtNombrePadre.setText("Padre :" + padre.getApellidoPaterno() + " " + padre.getApellidoMaterno() + ", " + padre.getNombres());
        } else {
            txtNombrePadre.setText("Padre :" + R.string.tabAlumno_errorPadre);
        }

        if (madre != null) {
            txtNombreMadre.setText("Madre : " + madre.getApellidoPaterno() + " " + madre.getApellidoMaterno() + ", " + madre.getNombres());
        } else {
            txtNombreMadre.setText("Madre : " + R.string.tabAlumno_errorMadre);
        }
        txtNombreAlumno.setText(nombreAlumno);
        txtNombreCapacidad.setText(nombreCompetencia);


        imageLoader.loadWithCircular(imgProfileRecomendacion, urlImage);
        contentExtent.setVisibility(View.GONE);
        return viewPadre;
    }

    boolean isVIsibleContentExtent = false;

    @OnClick(R.id.botVerDesitnoMedio)
    public void botVerDesitnoMedio() {
        if (isVIsibleContentExtent) {
            contentExtent.setVisibility(View.GONE);
            isVIsibleContentExtent = false;
        } else {
            contentExtent.setVisibility(View.VISIBLE);
            isVIsibleContentExtent = true;
        }

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        // setup dialog: buttons, title etc
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle("Comentario")

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


    @Override
    public void onDestroyView() {
        super.onDestroyView();


    }
}
