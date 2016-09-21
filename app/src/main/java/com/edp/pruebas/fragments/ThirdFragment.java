package com.edp.pruebas.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edp.pruebas.R;


public class ThirdFragment extends Fragment {

    public static ThirdFragment newInstance(Bundle bundle) {
        final ThirdFragment imageFragment = new ThirdFragment();
        if (bundle != null) {
            imageFragment.setArguments(bundle);
        }
        return imageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bb_fragment_third, container, false);
    }
}
