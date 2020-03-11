package com.upec.androidtemplate20192020.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.upec.androidtemplate20192020.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JourneyFragment extends Fragment {
    TextView textView;

    public JourneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootJourneyView =  inflater.inflate(R.layout.fragment_trajet, container, false);
        textView=rootJourneyView.findViewById(R.id.textViewJourney);
        return rootJourneyView;
    }

}
