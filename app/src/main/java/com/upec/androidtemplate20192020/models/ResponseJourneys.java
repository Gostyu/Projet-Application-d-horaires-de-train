package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import java.util.List;

public class ResponseJourneys {
    List<Journey> journeys;
<<<<<<< HEAD
    public ResponseJourneys(List<Journey> journeys)
    {
=======
    public ResponseJourneys(List<Journey> journeys){
>>>>>>> a195ba196185235f115a53cf4db2a70c8cd17c57
        this.journeys=journeys;
    }
    public List<Journey> getJourneys() {
        return journeys;
    }
<<<<<<< HEAD


=======
>>>>>>> a195ba196185235f115a53cf4db2a70c8cd17c57
    @NonNull
    @Override
    public String toString() {
        if(journeys!=null){
            for (Journey d: journeys) {
                return d.toString()+"\n";
            }
        }
        return "Liste des départs indisponible !";
    }
}
