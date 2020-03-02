package com.upec.androidtemplate20192020.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upec.androidtemplate20192020.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class trajet extends Fragment {


    public trajet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trajet, container, false);
    }

}
