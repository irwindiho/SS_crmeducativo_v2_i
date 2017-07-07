package com.consultoraestrategia.ss_crmeducativo.TabCursoAlumno.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.consultoraestrategia.ss_crmeducativo.sesiones.view.fragments.FragmentSesiones;
import com.consultoraestrategia.ss_crmeducativo.tareas.view.fragments.FragmentHorario;
import com.consultoraestrategia.ss_crmeducativo.tareas.view.fragments.FragmentTareas;

/**
 * Created by irvinmarin on 24/02/2017.
 */

public class PagerCursoAlumnoAdapter extends FragmentPagerAdapter {
    private static final String TAG = "PagerCursoAlumnoAdapter";
    private int backgroudColor;
    private int idCargaCurso;

    //integer to count number of tabs
    private int tabCount;

    //Constructor to the class
    public PagerCursoAlumnoAdapter(FragmentManager fm, int tabCount, int backgroudColor, int idCargaCurso) {
        super(fm);
        this.tabCount = tabCount;
        this.backgroudColor = backgroudColor;
        this.idCargaCurso = idCargaCurso;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
//        Returning the current tabs
        Bundle bundle1 = new Bundle();
        bundle1.putInt("idCargaCurso", idCargaCurso);
        bundle1.putInt("backgroudColor", backgroudColor);
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = FragmentSesiones.newInstance();
                fragment.setArguments(bundle1);
                break;

            case 1:
                fragment = new FragmentTareas();
                fragment.setArguments(bundle1);
                break;
            case 2:
                fragment = new FragmentHorario();
                fragment.setArguments(bundle1);
                break;
        }
        return fragment;

    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}