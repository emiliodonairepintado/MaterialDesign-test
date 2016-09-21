package com.edp.pruebas.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edp.pruebas.R;


public class FourthFragment extends Fragment {

    public static FourthFragment newInstance(Bundle bundle) {
        final FourthFragment imageFragment = new FourthFragment();
        if (bundle != null) {
            imageFragment.setArguments(bundle);
        }
        return imageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bb_fragment_fourth, container, false);
    }
}
