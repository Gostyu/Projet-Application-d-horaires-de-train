package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import java.util.List;

public class ResponseJourneys {
    List<Journey> journeys;
    public ResponseJourneys(List<Journey> journeys){
        this.journeys=journeys;
    }
    public List<Journey> getJourneys() {
        return journeys;
    }

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
