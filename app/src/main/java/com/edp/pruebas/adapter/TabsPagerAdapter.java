package com.edp.pruebas.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.edp.pruebas.fragments.FirstFragment;
import com.edp.pruebas.fragments.SecondFragment;
import com.edp.pruebas.fragments.ThirdFragment;

public class TabsPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    FirstFragment tab1 = new FirstFragment();
    SecondFragment tab2 = new SecondFragment();
    ThirdFragment tab3 = new ThirdFragment();

    public TabsPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return tab1;
            case 1:
                return tab2;
            case 2:
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}