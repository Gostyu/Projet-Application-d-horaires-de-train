package com.upec.androidtemplate20192020.fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
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

import com.google.android.material.snackbar.Snackbar;
import com.upec.androidtemplate20192020.Backend.SncfApiWorker;
import com.upec.androidtemplate20192020.R;
import com.upec.androidtemplate20192020.models.Journey;
import com.upec.androidtemplate20192020.models.ResponseStopAreas;
import com.upec.androidtemplate20192020.models.SavedJourneys;
import com.upec.androidtemplate20192020.views.JourneySncfAdapter;
import com.upec.androidtemplate20192020.views.MyAutoCompleteTextViewConfig;
import com.upec.androidtemplate20192020.views.OnClickImageListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JourneyFragment extends Fragment {
    String NAME_FRAGMENT = "JourneyFragment";
    static RecyclerView recyclerView;
    EditText editTextStart;
    AutoCompleteTextView editTextEnd;
    MyAutoCompleteTextViewConfig myAutoCompleteTextViewConfig;
    MyAutoCompleteTextViewConfig myAutoCompleteTextViewConfig2;
    final SncfApiWorker sncfApiWorker = new SncfApiWorker(this);
    static SavedJourneys savedJourneys;
    public static String DATA_TAG = "JOURNEYS";
    List<String> stopAreaNames;
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
        return inflater.inflate(R.layout.fragment_trajet, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null) {
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

    public void getAllStationsResults(ResponseStopAreas response) {
        stopAreaNames=response.getStop_areasNames();
        myAutoCompleteTextViewConfig.autoCompleteTextViewData(response.getStop_areasNames());
        myAutoCompleteTextViewConfig2.autoCompleteTextViewData(response.getStop_areasNames());
    }

    TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String from = "", to = "";
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                editTextEnd.setFocusable(true);
            }
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                from = editTextStart.getText().toString();
                to = editTextEnd.getText().toString();
                if (from != "" && to != "") {
                    Log.d("onEditor in JFragment", from + " " + to);
                    from=getStationName(from);
                    to=getStationName(to);
                    sncfApiWorker.getJourneys(from, to);
                }
                return true;
            }
            return false;
        }
    };
    private String getStationName(String userInput){
        if(stopAreaNames!=null) {
            for (String s : stopAreaNames) {
                if (s.toLowerCase().contains(userInput.toLowerCase())) {
                    return s;
                }
            }
        }
        return null;
    }
    public void createRecylerView(List<Journey> journeyList) {
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
         recyclerView.setLayoutManager(layoutManager);
         JourneySncfAdapter journeySncfAdapter = new JourneySncfAdapter(journeyList);
         recyclerView.setAdapter(journeySncfAdapter);
         recyclerView.setVisibility(View.VISIBLE);
         saveJourney(journeySncfAdapter,journeyList);
         //  editText.setVisibility(View.GONE);
     }
    public void saveJourney(JourneySncfAdapter journeySncfAdapter, List<Journey> journeyList) {
         journeySncfAdapter.setOnClickImageListener(new OnClickImageListener() {
             @Override
             public void onSaveJourney(int position) {
                 Log.d("ONSAVE IN JF","ok bien sauvegardé");
                 savedJourneys.addJourney(journeyList.get(position));
                 displaySuccessMessage("trajet sauvegardé".toUpperCase());
                 displaySaveJourneys(savedJourneys);
             }
             @Override
             public void onDeleteSavedJourney(int position) {

             }
         });
     }

    private void displaySuccessMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }

    private static void displaySaveJourneys(SavedJourneys savedJourneys) {
        Log.d("DISPLAY", savedJourneys.getJourneys().toString());
            FavoriteJourneysFragment.setSaveJourney(savedJourneys);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myAutoCompleteTextViewConfig.setListener(null);
        myAutoCompleteTextViewConfig2.setListener(null);
    }
}
