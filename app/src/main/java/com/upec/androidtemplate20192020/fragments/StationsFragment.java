package com.upec.androidtemplate20192020.fragments;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.upec.androidtemplate20192020.R;

public class StationsFragment extends Fragment {
    TextView textView;
    public StationsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootStationsView = inflater.inflate(R.layout.fragment_trouver_gare, container, false);
        textView=rootStationsView.findViewById(R.id.textViewStations);


        Log.e("businessService","cALLING");
        return rootStationsView;
    }
}
