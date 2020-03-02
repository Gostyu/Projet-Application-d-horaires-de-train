package com.upec.androidtemplate20192020.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.upec.androidtemplate20192020.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class trainsFragment extends Fragment {
    EditText editText;
    Button searchBtn;
    RecyclerView recyclerView;
    public trainsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*on charge la vue du fragment dans l'objet de type View (rootView)
        * un peu comme si on faisait appel dans une activité à la fonction
        * setContentView.
         */
        final View rootView = inflater.inflate(R.layout.fragment_trains, container, false);
        editText=rootView.findViewById(R.id.editText_train);
        searchBtn=rootView.findViewById(R.id.btn_search_horaires);
        recyclerView=rootView.findViewById(R.id.recyclerView_train);
        // Inflate the layout for this fragment
        return rootView;
    }

}
