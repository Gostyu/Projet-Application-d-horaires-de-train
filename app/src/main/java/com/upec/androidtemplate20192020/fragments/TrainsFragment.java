package com.upec.androidtemplate20192020.fragments;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.upec.androidtemplate20192020.Backend.SncfApiWorker;
import com.upec.androidtemplate20192020.R;
import com.upec.androidtemplate20192020.models.Departure;
import com.upec.androidtemplate20192020.models.ResponseDepartures;
import com.upec.androidtemplate20192020.models.ResponseStopAreas;
import com.upec.androidtemplate20192020.models.StopArea;
import com.upec.androidtemplate20192020.views.horaireSncfAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainsFragment extends Fragment {
    final int NB_CHARACTERS=2;
   // static ResponseStopAreas stations;
    AutoCompleteTextView editText;
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
        editText = rootView.findViewById(R.id.editText_train);
        recyclerView = rootView.findViewById(R.id.recyclerView_train);
        sncfApiWorker.requestAllStationsResults();
        editText.setOnEditorActionListener(onEditorActionListener);
        // Inflate the layout for this fragment
        return rootView;
    }

    /**
     * Recuperer la liste des gares pour l'autocompletion de l'edittext
     * @param list
     */
    public void autoCompleteTextViewData(ArrayList<String> list){
        if(list!=null){
            ArrayList<String> data = (ArrayList<String>) list.clone();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.select_dialog_item,data);
            editText.setThreshold(NB_CHARACTERS);
            editText.setAdapter(adapter);
        }
    }
    /**
     * Mets la liste des gares dans l'editText pour l'autocompletion
     */
    public void getAllStationsResults(ResponseStopAreas response){
        autoCompleteTextViewData(response.getStop_areasNames());
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
             //   SncfApiWorker.getDeparturesByStopAreaIdResults(SncfApiWorker.getDeparturesByStopAreaId(id));
            }
        }
    }

    public void createRecylerView(List<Departure>departureList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new horaireSncfAdapter(departureList));
        recyclerView.setVisibility(View.VISIBLE);
      //  editText.setVisibility(View.GONE);
    }

}
