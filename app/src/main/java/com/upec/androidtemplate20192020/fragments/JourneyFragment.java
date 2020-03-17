package com.upec.androidtemplate20192020.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
import com.upec.androidtemplate20192020.models.ResponseStopAreas;
import com.upec.androidtemplate20192020.views.MyAutoCompleteTextViewConfig;

/**
 * A simple {@link Fragment} subclass.
 */
public class JourneyFragment extends Fragment {
    EditText editTextStart;
    AutoCompleteTextView editTextEnd;
    MyAutoCompleteTextViewConfig myAutoCompleteTextViewConfig;
    MyAutoCompleteTextViewConfig myAutoCompleteTextViewConfig2;
    final SncfApiWorker sncfApiWorker2 =  new SncfApiWorker(this);
    public JourneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootJourneyView =  inflater.inflate(R.layout.fragment_trajet, container, false);
        editTextStart=rootJourneyView.findViewById(R.id.editText_trajet1);
        editTextEnd=rootJourneyView.findViewById(R.id.editText_trajet2);
        sncfApiWorker2.requestAllStationsResults();
        myAutoCompleteTextViewConfig=new MyAutoCompleteTextViewConfig(getContext(),rootJourneyView.findViewById(R.id.editText_trajet1));
        myAutoCompleteTextViewConfig2=new MyAutoCompleteTextViewConfig(getContext(),rootJourneyView.findViewById(R.id.editText_trajet2));
        editTextStart=myAutoCompleteTextViewConfig.getEditText();
        editTextEnd=myAutoCompleteTextViewConfig2.getEditText();
        myAutoCompleteTextViewConfig.setListener(onEditorActionListener1);
        myAutoCompleteTextViewConfig2.setListener(onEditorActionListener1);
        return rootJourneyView;
    }
    public void getAllStationsResults(ResponseStopAreas response){
        myAutoCompleteTextViewConfig.autoCompleteTextViewData(response.getStop_areasNames());
        myAutoCompleteTextViewConfig2.autoCompleteTextViewData(response.getStop_areasNames());
    }
    /*

     */
   TextView.OnEditorActionListener onEditorActionListener1 = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

            if(actionId==EditorInfo.IME_ACTION_NEXT) {
                editTextEnd.setFocusable(true);
            }
            if(actionId==EditorInfo.IME_ACTION_SEARCH){
                if(editTextStart.getText().toString()!="" && editTextEnd.getText().toString()!=""){
                    Log.d("onEditor", editTextStart.getText().toString());
                    //searchJourneys(editText.getText().toString());
                }
                return true;
            }
            return false;
        }
    };

}
