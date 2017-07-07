package com.consultoraestrategia.ss_crmeducativo.evaluacion.view.adapters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments.FragmentTabAlumno;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments.FragmentTabAnotacionesAlumno;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments.FragmentTabCalendarioAlumno;
import com.consultoraestrategia.ss_crmeducativo.evaluacion.view.fragments.FragmentTabCargaAcademica;

/**
 * Created by irvinmarin on 24/02/2017.
 */

public class PagerAlumnoAdapter extends FragmentPagerAdapter {
    private static final String TAG = "PagerCursoAlumnoAdapter";


    int idAlumno;
    //integer to count number of tabs
    private int tabCount;

    //Constructor to the class
    public PagerAlumnoAdapter(FragmentManager fm, int tabCount, int idAlumno) {
        super(fm);
        this.tabCount = tabCount;
        this.idAlumno = idAlumno;

    }

    //    Overriding method getItem
    @Override
    public Fragment getItem(int position) {
//        Returning the current tabs
        Bundle bundle1 = new Bundle();
        bundle1.putInt("idAlumno", idAlumno);
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = FragmentTabAlumno.newInstance();
                fragment.setArguments(bundle1);
                break;

            case 1:
                fragment = FragmentTabCargaAcademica.newInstance();
                fragment.setArguments(bundle1);
                break;
            case 2:
                fragment = FragmentTabAnotacionesAlumno.newInstance();
                fragment.setArguments(bundle1);
                break;
            case 3:
                fragment = FragmentTabCalendarioAlumno.newInstance();
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