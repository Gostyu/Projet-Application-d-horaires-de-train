package com.upec.androidtemplate20192020.models;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class ResponseStopAreas {
    private ArrayList<StopArea> stop_areas;
    public void setStop_areas(ArrayList<StopArea> stop_areas) {
        this.stop_areas = stop_areas;
    }

    public ArrayList<StopArea> getStop_areas() {
        return stop_areas;
    }

    public ResponseStopAreas(ArrayList<StopArea> stopAreas) {
        this.stop_areas = stopAreas;
    }
    public ArrayList<String> getStop_areasNames(){
        ArrayList<String> names = new ArrayList<>();
        for(StopArea stopArea:stop_areas){
            names.add(stopArea.getName());
        }
        return names;
    }
    public ArrayList<String> getStop_areasIds(){
        ArrayList<String> ids = new ArrayList<>();
        for(StopArea stopArea:stop_areas){
            ids.add(stopArea.getId());
        }
        return ids;
    }
    public String getStopAreaId(String stopAreaName){
        for (StopArea stopArea:stop_areas) {
            if(stopArea.getName().toLowerCase().contains(stopAreaName.toLowerCase())){
               Log.d("TEST in getStopAreaId", "OK");
               // System.out.println("TEST IN GETSTOPAREAID OK");
            }
            if(Objects.equals(stopArea.getName(),stopAreaName)){
                return stopArea.getId();
            }
        }
        return "ID NOT FOUND";
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
