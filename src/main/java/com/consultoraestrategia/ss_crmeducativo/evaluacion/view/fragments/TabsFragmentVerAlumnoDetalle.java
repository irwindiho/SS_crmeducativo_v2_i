package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.consultoraestrategia.ss_crmeducativo.R;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters.PagerAlumnoAdapter;
import com.consultoraestrategia.ss_crmeducativo.lib.GlideImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TabsFragmentVerAlumnoDetalle extends DialogFragment {

    String TAG = "TabAlumnoDetalle";
    View viewPadre;
    @BindView(R.id.imgProfileAlumno)
    ImageView imgProfileAlumno;
    @BindView(R.id.tabDetallesAlumno)
    TabLayout tabDetallesAlumno;

    Fragment fragment;
    @BindView(R.id.rowHeader)
    TableRow rowHeader;
    @BindView(R.id.vpDetallesAlumnos)
    ViewPager vpDetallesAlumnos;
    @BindView(R.id.contendedorFragments)
    LinearLayout contendedorFragments;
    @BindView(R.id.txtPrueba)
    TextView txtPrueba;

    GlideImageLoader imageLoader;

    int idAlumno;
    int nroTab;

    public static TabsFragmentVerAlumnoDetalle newInstance() {

        TabsFragmentVerAlumnoDetalle fragment = new TabsFragmentVerAlumnoDetalle();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewPadre = inflater.inflate(R.layout.dialog_fragment_ver_alumno_detalles, container, false);
        ButterKnife.bind(this, viewPadre);
        imageLoader = new GlideImageLoader(this.getContext());
        setupDatosAlumno();
        setupTabs();
        return viewPadre;
    }

    private void setupDatosAlumno() {
        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        idAlumno = getArguments().getInt("idAlumno");
        nroTab = getArguments().getInt("nroTab");
        String urlProfile = getArguments().getString("urlProfile");
        imageLoader.loadWithCircular(imgProfileAlumno,urlProfile);
    }

    private void setupTabs() {
        tabDetallesAlumno.addTab(tabDetallesAlumno.newTab().setText("Alumno"));
        tabDetallesAlumno.addTab(tabDetallesAlumno.newTab().setText("Carga Academica"));
        tabDetallesAlumno.addTab(tabDetallesAlumno.newTab().setText("Anotaciones"));
        tabDetallesAlumno.addTab(tabDetallesAlumno.newTab().setText("Calendario"));

        tabDetallesAlumno.setTabGravity(TabLayout.GRAVITY_CENTER);

        tabDetallesAlumno.setTabMode(TabLayout.MODE_SCROLLABLE);
        setupViewPager();
        setupTabSelectedItem();
    }

    private void setupTabSelectedItem() {
        tabDetallesAlumno.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                vpDetallesAlumnos.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void setupViewPager() {
        PagerAlumnoAdapter pagerCursoAlumnoAdapter = new PagerAlumnoAdapter(getChildFragmentManager(), tabDetallesAlumno.getTabCount(), idAlumno);
        Log.d(TAG, "nroTab: " + nroTab);
        vpDetallesAlumnos.setAdapter(pagerCursoAlumnoAdapter);
        if (nroTab == 2) {
            vpDetallesAlumnos.setCurrentItem(nroTab);
        }
        vpDetallesAlumnos.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabDetallesAlumno));

    }


}
