package com.consultoraestrategia.ss_crmeducativo.domain.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.consultoraestrategia.ss_crmeducativo.domain.entities.FragmentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kelvi on 23/02/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    List<FragmentUtil> fragmentList = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position).getFragment();
    }

    public void addFragment(FragmentUtil fragment) {
        fragmentList.add(fragment);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getName();
    }
}
