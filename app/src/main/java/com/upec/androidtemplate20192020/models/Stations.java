package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Stations {
    ArrayList<StopArea> stop_areas;

    public Stations(ArrayList<StopArea> stopAreas) {
        this.stop_areas = stopAreas;
    }

    @NonNull
    @Override
    public String toString() {
        for(StopArea stopArea:stop_areas){
            return stopArea.toString()+"\n";
        }
        return "Liste vide !";
    }
}
