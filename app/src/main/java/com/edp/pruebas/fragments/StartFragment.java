package com.edp.pruebas.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edp.pruebas.R;


public class StartFragment extends Fragment {

    public static StartFragment newInstance(Bundle bundle) {
        final StartFragment imageFragment = new StartFragment();
        if (bundle != null) {
            imageFragment.setArguments(bundle);
        }
        return imageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }
}