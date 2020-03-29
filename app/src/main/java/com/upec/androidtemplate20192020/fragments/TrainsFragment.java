package com.upec.androidtemplate20192020.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;


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
    //List<StopArea> stopAreasList = null;
    public TrainsFragment() {
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
<<<<<<< HEAD
        editText = rootView.findViewById(R.id.editText_train);
=======
>>>>>>> 40e29f9a7cd6c2946ff3ae8d64131658d5c7098c
        recyclerView = rootView.findViewById(R.id.recyclerView_train);
        sncfApiWorker.requestAllStationsResults();
        myAutoCompleteTextView=new MyAutoCompleteTextViewConfig(getContext(),rootView.findViewById(R.id.editText_train));
        myAutoCompleteTextView.setListener(onEditorActionListener);
        editText=myAutoCompleteTextView.getEditText();
        // Inflate the layout for this fragment
        return rootView;
    }

    /**
     * Mets la liste des gares dans l'editText pour l'autocompletion
     */
    public void getAllStationsResults(ResponseStopAreas response){
        myAutoCompleteTextView.autoCompleteTextViewData(response.getStop_areasNames());
    }
    /*

     */
    TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId==EditorInfo.IME_ACTION_SEARCH||actionId==EditorInfo.IME_ACTION_DONE) {
                if(editText.getText().toString()!=""){
                    Log.d("onEditor", editText.getText().toString());
                   searchDepartures(editText.getText().toString());
                }
                return true;
            }
            return false;
        }
    };

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

    }

}
