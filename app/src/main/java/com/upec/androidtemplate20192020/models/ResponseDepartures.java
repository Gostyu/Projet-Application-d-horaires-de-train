package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import java.util.List;

public class ResponseDepartures {
    List<Departure> departures;
    public ResponseDepartures(List<Departure> departureList) {
        this.departures = departureList;
    }

    public List<Departure> getDepartures() {
        return departures;
    }
    @NonNull
    @Override
    public String toString() {
        if(departures!=null){
            for (Departure d: departures) {
                return d.toString()+"\n";
            }
        }
        return "Liste des départs indisponible !";
    }
}
