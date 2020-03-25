package com.upec.androidtemplate20192020.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.upec.androidtemplate20192020.Backend.SncfApiWorker;
import com.upec.androidtemplate20192020.R;
import com.upec.androidtemplate20192020.models.Departure;
import com.upec.androidtemplate20192020.models.Journey;
import com.upec.androidtemplate20192020.models.ResponseStopAreas;
import com.upec.androidtemplate20192020.views.JourneySncfAdapter;
import com.upec.androidtemplate20192020.views.MyAutoCompleteTextViewConfig;
import com.upec.androidtemplate20192020.views.horaireSncfAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JourneyFragment extends Fragment {
    RecyclerView recyclerView;
    EditText editTextStart;
    AutoCompleteTextView editTextEnd;
    MyAutoCompleteTextViewConfig myAutoCompleteTextViewConfig;
    MyAutoCompleteTextViewConfig myAutoCompleteTextViewConfig2;
    final SncfApiWorker sncfApiWorker =  new SncfApiWorker(this);
    public JourneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootJourneyView =  inflater.inflate(R.layout.fragment_trajet, container, false);
        editTextStart=rootJourneyView.findViewById(R.id.editText_trajet1);
        editTextEnd=rootJourneyView.findViewById(R.id.editText_trajet2);
        sncfApiWorker.requestAllStationsResults();
        myAutoCompleteTextViewConfig=new MyAutoCompleteTextViewConfig(getContext(),rootJourneyView.findViewById(R.id.editText_trajet1));
        myAutoCompleteTextViewConfig2=new MyAutoCompleteTextViewConfig(getContext(),rootJourneyView.findViewById(R.id.editText_trajet2));
        editTextStart=myAutoCompleteTextViewConfig.getEditText();
        editTextEnd=myAutoCompleteTextViewConfig2.getEditText();
        myAutoCompleteTextViewConfig.setListener(onEditorActionListener);
        myAutoCompleteTextViewConfig2.setListener(onEditorActionListener);
        recyclerView=rootJourneyView.findViewById(R.id.recyclerView_trajet);
        return rootJourneyView;
    }
    public void getAllStationsResults(ResponseStopAreas response){
        myAutoCompleteTextViewConfig.autoCompleteTextViewData(response.getStop_areasNames());
        myAutoCompleteTextViewConfig2.autoCompleteTextViewData(response.getStop_areasNames());
    }

   TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String from="", to="";
            if(actionId==EditorInfo.IME_ACTION_NEXT) {
                editTextEnd.setFocusable(true);
            }
            if(actionId==EditorInfo.IME_ACTION_SEARCH){
                from=editTextStart.getText().toString();
                to=editTextEnd.getText().toString();
                if(from!="" && to!=""){
                    Log.d("onEditor in JFragment", from+" "+to);
                    sncfApiWorker.getJourneys(from,to);
                }
                return true;
            }
            return false;
        }
    };
    public void createRecylerView(List<Journey> journeyList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new JourneySncfAdapter(journeyList));
        recyclerView.setVisibility(View.VISIBLE);
        //  editText.setVisibility(View.GONE);
    }
}
