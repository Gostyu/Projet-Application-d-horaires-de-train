package com.upec.androidtemplate20192020.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.upec.androidtemplate20192020.Backend.SncfApiWorker;
import com.upec.androidtemplate20192020.R;
import com.upec.androidtemplate20192020.models.Departure;
import com.upec.androidtemplate20192020.models.ResponseStopAreas;
import com.upec.androidtemplate20192020.views.MyAutoCompleteTextViewConfig;
import com.upec.androidtemplate20192020.views.horaireSncfAdapter;

import java.util.List;

public class TrainsFragment extends Fragment {
   // static ResponseStopAreas stations;
    AutoCompleteTextView editText;
    MyAutoCompleteTextViewConfig myAutoCompleteTextView;
    RecyclerView recyclerView;
    final SncfApiWorker sncfApiWorker =  new SncfApiWorker(this);
    TextView messageTv;
    //List<StopArea> stopAreasList = null;
    List<String> stopAreaNames;
    public TrainsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sncfApiWorker.requestAllStationsResults();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*on charge la vue du fragment dans l'objet de type View (rootView)
         * un peu comme si on faisait appel dans une activité à la fonction
         * setContentView.
         */
        final View rootView = inflater.inflate(R.layout.fragment_trains, container, false);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        editText = getActivity().findViewById(R.id.editText_train);
        messageTv=getActivity().findViewById(R.id.messageTv_train);
        recyclerView = getActivity().findViewById(R.id.recyclerView_train);
        myAutoCompleteTextView=new MyAutoCompleteTextViewConfig(getContext(),getActivity().findViewById(R.id.editText_train));
        myAutoCompleteTextView.setListener(onEditorActionListener);
        editText=myAutoCompleteTextView.getEditText();

    }

    /**
     * Mets la liste des gares dans l'editText pour l'autocompletion
     */
    public void getAllStationsResults(ResponseStopAreas response){
        stopAreaNames=response.getStop_areasNames();
        myAutoCompleteTextView.autoCompleteTextViewData(response.getStop_areasNames());
    }
    /*
       le listener pour les edittexts
     */
    TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId==EditorInfo.IME_ACTION_SEARCH||actionId==EditorInfo.IME_ACTION_DONE) {
                String stationName=editText.getText().toString();
                if(stationName!=""){
                    lauchSearchName(stationName);
                    Log.d("onEditor", stationName);
                  // searchDepartures(stationName);
                }
                return true;
            }
            return false;
        }
    };
    private void lauchSearchName(String stationName){
        if(stopAreaNames!=null)
            for(String s:stopAreaNames){
                if(s.toLowerCase().contains(stationName.toLowerCase())){
                    searchDepartures(s);
                }
            }
    }
    public void searchDepartures(String stopAreaName){
        Log.d("SEARCHDEPARTS","OK");
       SncfApiWorker.requestDeparturesByStopAreaName(stopAreaName);
    }


    private void getDataForUI(ResponseStopAreas responseStopAreas, String name) {
        String TAG="DATAUI";
        if(responseStopAreas !=null && (name!=""||name!=null)){
            String id = responseStopAreas.getStopAreaId(name);
            if(id!="ID NOT FOUND"){
                Log.d(TAG,name+":"+id);

            }
        }
    }

    public void createRecylerView(List<Departure>departureList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new horaireSncfAdapter(departureList));
        recyclerView.setVisibility(View.VISIBLE);
        messageTv.setVisibility(View.GONE);
        closeKeyboard();
    }

    private void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        View v = getView();
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myAutoCompleteTextView.setListener(null);
    }
}
