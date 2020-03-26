package com.upec.androidtemplate20192020.views;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import java.util.ArrayList;

public class MyAutoCompleteTextViewConfig {
    AutoCompleteTextView editText;
    Context context;
   public MyAutoCompleteTextViewConfig(Context c, AutoCompleteTextView editText){
        context=c;
        this.editText=editText;
    }
    final int NB_CHARACTERS=1;
    /**
     * Recuperer la liste des gares pour l'autocompletion de l'edittext
     * @param list
     */
    public void autoCompleteTextViewData(ArrayList<String> list){
        if(list!=null){
            ArrayList<String> data = (ArrayList<String>) list.clone();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(context,android.R.layout.simple_dropdown_item_1line,data);
            editText.setThreshold(NB_CHARACTERS);
            editText.setAdapter(adapter);
        }
    }
    public void setListener(TextView.OnEditorActionListener onEditorActionListener){
        editText.setOnEditorActionListener(onEditorActionListener);
    }

    public AutoCompleteTextView getEditText() {
        return editText;
    }
}
