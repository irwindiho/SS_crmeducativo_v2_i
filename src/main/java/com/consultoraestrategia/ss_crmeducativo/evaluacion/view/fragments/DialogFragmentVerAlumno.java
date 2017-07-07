package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;
import com.consultoraestrategia.ss_crmeducativo.lib.ImageLoader;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 24/03/2017.
 */

public class DialogFragmentVerAlumno extends DialogFragment {

    @BindView(R.id.imgProfile)
    ImageView imgProfile;

    @BindView(R.id.txtNombresCompletos)
    TextView txtNombresCompletos;

    ImageLoader imageLoader;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_fragment_ver_alumno, container, false);


        imageLoader = new GlideImageLoader(getActivity().getApplicationContext());
//        getDialog().setTitle();
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        ButterKnife.bind(this, v);
        String[] data = getArguments().getStringArray("datosAlumnos");
        String imurlImage = getArguments().getString("urlImage");
        assert data != null;
        String nombre = data[0];
        String imagen = data[1];

        txtNombresCompletos.setText(nombre + " " + imagen);


        imageLoader.load(imgProfile, imurlImage);

        return v;
    }
}
