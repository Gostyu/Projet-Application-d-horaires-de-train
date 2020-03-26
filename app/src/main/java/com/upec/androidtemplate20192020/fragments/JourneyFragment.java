package com.upec.androidtemplate20192020.fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ComponentActivity;
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
import android.widget.Toast;

import com.upec.androidtemplate20192020.Backend.SncfApiWorker;
import com.upec.androidtemplate20192020.R;
import com.upec.androidtemplate20192020.models.Departure;
import com.upec.androidtemplate20192020.models.Journey;
import com.upec.androidtemplate20192020.models.ResponseStopAreas;
import com.upec.androidtemplate20192020.models.SavedJourneys;
import com.upec.androidtemplate20192020.views.JourneySncfAdapter;
import com.upec.androidtemplate20192020.views.MyAutoCompleteTextViewConfig;
import com.upec.androidtemplate20192020.views.OnClickImageListener;
import com.upec.androidtemplate20192020.views.horaireSncfAdapter;

import java.util.List;
import com.upec.androidtemplate20192020.models.ResponseStopAreas;
import com.upec.androidtemplate20192020.views.MyAutoCompleteTextViewConfig;

/**
 * A simple {@link Fragment} subclass.
 */
public class JourneyFragment extends Fragment {
    RecyclerView recyclerView;
    ResponseStopAreas stopAreas;
    EditText editTextStart;
    AutoCompleteTextView editTextEnd;
    MyAutoCompleteTextViewConfig myAutoCompleteTextViewConfig;
    MyAutoCompleteTextViewConfig myAutoCompleteTextViewConfig2;
    final SncfApiWorker sncfApiWorker =  new SncfApiWorker(this);
    SavedJourneys savedJourneys;
    public JourneyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedJourneys = new SavedJourneys();
        sncfApiWorker.requestAllStationsResults();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_trajet, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState==null) {
            editTextStart = getActivity().findViewById(R.id.editText_trajet1);
            editTextEnd = getActivity().findViewById(R.id.editText_trajet2);
            recyclerView = getActivity().findViewById(R.id.recyclerView_trajet);
            myAutoCompleteTextViewConfig = new MyAutoCompleteTextViewConfig(getContext(), getActivity().findViewById(R.id.editText_trajet1));
            myAutoCompleteTextViewConfig2 = new MyAutoCompleteTextViewConfig(getContext(), getActivity().findViewById(R.id.editText_trajet2));
            editTextStart = myAutoCompleteTextViewConfig.getEditText();
            editTextEnd = myAutoCompleteTextViewConfig2.getEditText();
            myAutoCompleteTextViewConfig.setListener(onEditorActionListener);
            myAutoCompleteTextViewConfig2.setListener(onEditorActionListener);
        }

    }

    public void getAllStationsResults(ResponseStopAreas response){
        myAutoCompleteTextViewConfig.autoCompleteTextViewData(response.getStop_areasNames());
        myAutoCompleteTextViewConfig2.autoCompleteTextViewData(response.getStop_areasNames());
        stopAreas=response;
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
        JourneySncfAdapter journeySncfAdapter = new JourneySncfAdapter(journeyList);
        recyclerView.setAdapter(journeySncfAdapter);
        recyclerView.setVisibility(View.VISIBLE);
        saveJourney(journeySncfAdapter,journeyList);
        //  editText.setVisibility(View.GONE);
    }

    private void saveJourney(JourneySncfAdapter journeySncfAdapter, List<Journey> journeyList) {
        journeySncfAdapter.setOnClickImageListener(new OnClickImageListener() {
            @Override
            public void onSaveJourney(int position) {
                Log.d("ONSAVE IN JF","ok bien sauvegardé");
                savedJourneys.addJourney(journeyList.get(position));
                Toast.makeText(getActivity(),"TRAJET SAUVEGARDE",Toast.LENGTH_LONG).show();
                displaySaveJourneys(savedJourneys);
            }
        });
    }

    private void displaySaveJourneys(SavedJourneys savedJourneys) {
            Log.d("DISPLAY", savedJourneys.getJourneys().toString());
    }


}
