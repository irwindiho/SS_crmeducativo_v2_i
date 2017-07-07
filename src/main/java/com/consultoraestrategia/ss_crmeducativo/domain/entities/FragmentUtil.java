package com.consultoraestrategia.ss_crmeducativo.domain.entities;

import android.support.v4.app.Fragment;

/**
 * Created by kelvi on 23/02/2017.
 */

public class FragmentUtil {
    private Fragment fragment;
    private String name;
    private int resource;

    public FragmentUtil(Fragment fragment, String name, int resource) {
        this.fragment = fragment;
        this.name = name;
        this.resource = resource;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
