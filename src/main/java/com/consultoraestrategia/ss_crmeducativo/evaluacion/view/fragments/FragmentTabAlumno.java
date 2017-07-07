package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona;
import com.consultoraestrategia.ss_crmeducativo.entities.Persona_Table;
import com.consultoraestrategia.ss_crmeducativo.entities.Relaciones;
import com.consultoraestrategia.ss_crmeducativo.entities.Relaciones_Table;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by irvinmarin on 24/03/2017.
 */

public class FragmentTabAlumno extends Fragment {

    ImageLoader imageLoader;
    View viewPadre;
    @BindView(R.id.txtApellidosALumno)
    TextView txtApellidosALumno;
    @BindView(R.id.txtNombreALumno)
    TextView txtNombreALumno;
    @BindView(R.id.txtCelularALumno)
    TextView txtCelularALumno;
    @BindView(R.id.txtTelefonoALumno)
    TextView txtTelefonoALumno;
    @BindView(R.id.txtFechaNacimeintoALumno)
    TextView txtFechaNacimeintoALumno;
    @BindView(R.id.txtCorreoALumno)
    TextView txtCorreoALumno;
    @BindView(R.id.verAlumno)
    TextView verAlumno;
    @BindView(R.id.contentAlumno)
    LinearLayout contentAlumno;
    @BindView(R.id.verApoderados)
    TextView verApoderados;
    @BindView(R.id.txtPadre)
    TextView txtPadre;
    @BindView(R.id.txtMadre)
    TextView txtMadre;
    @BindView(R.id.contentApoderados)
    LinearLayout contentApoderados;
    @BindView(R.id.toggleAlumno)
    ToggleButton toggleAlumno;
    @BindView(R.id.toggleApoderados)
    ToggleButton toggleApoderados;

    Persona alumno;

    public static FragmentTabAlumno newInstance() {
        FragmentTabAlumno fragment = new FragmentTabAlumno();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.tab_personal_alumno, container, false);


        ButterKnife.bind(this, viewPadre);

        SetupDatosAlumno();
        SetupDatosPadres();

        return viewPadre;
    }

    @OnClick(R.id.toggleAlumno)
    public void onToggleAlumno() {
        if (!toggleAlumno.isChecked()) {
            contentAlumno.setVisibility(View.INVISIBLE);
            ViewGroup.LayoutParams params = contentAlumno.getLayoutParams();
            params.height = 0;
            contentAlumno.setLayoutParams(params);
        } else {
            contentAlumno.setVisibility(View.VISIBLE);
            ViewGroup.LayoutParams params = contentAlumno.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            contentAlumno.setLayoutParams(params);

        }
    }

    @OnClick(R.id.toggleApoderados)
    public void onToggleApoderados() {
        if (!toggleApoderados.isChecked()) {
            contentApoderados.setVisibility(View.INVISIBLE);
            ViewGroup.LayoutParams params = contentApoderados.getLayoutParams();
            params.height = 0;
            contentApoderados.setLayoutParams(params);

        } else {
            contentApoderados.setVisibility(View.VISIBLE);
            ViewGroup.LayoutParams params = contentApoderados.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            contentApoderados.setLayoutParams(params);

        }

    }

    private void SetupDatosPadres() {
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
            txtPadre.setText(padre.getApellidoPaterno() + " " + padre.getApellidoMaterno() + ", " + padre.getNombres());
        } else {
            txtPadre.setText(R.string.tabAlumno_errorPadre);
        }

        if (madre != null) {
            txtMadre.setText(madre.getApellidoPaterno() + " " + madre.getApellidoMaterno() + ", " + madre.getNombres());
        } else {
            txtMadre.setText(R.string.tabAlumno_errorMadre);
        }

    }


    private void SetupDatosAlumno() {
        int idAlumno = getArguments().getInt("idAlumno");
        alumno = SQLite.select()
                .from(Persona.class)
                .where(Persona_Table.personaId.is(idAlumno))
                .querySingle();

        txtApellidosALumno.setText(alumno.getApellidoPaterno() + " " + alumno.getApellidoMaterno());
        txtNombreALumno.setText(alumno.getNombres());

        checkStringNull(txtCelularALumno, alumno.getCelular() + "");
        checkStringNull(txtTelefonoALumno, alumno.getTelefono() + "");
        checkStringNull(txtCorreoALumno, alumno.getCorreo() + "");
        checkStringNull(txtFechaNacimeintoALumno, alumno.getFechaNac() + "");
    }

    private void checkStringNull(TextView textView, String field) {
        if (field.equals("")) {
            textView.setText(R.string.Registro_nullo);
        } else {
            textView.setText(field);
        }
    }

    Persona padre;
    Persona madre;
}
