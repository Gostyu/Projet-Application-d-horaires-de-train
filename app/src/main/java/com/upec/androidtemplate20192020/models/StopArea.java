package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class StopArea{
    String id;
    String name;
    String label;
    //Coord coord;
    ArrayList<StopPoint> stop_points;

    public StopArea(String id, String name, String label, Coord coord, ArrayList<StopPoint> stop_points) {
        this.id = id;
        this.name = name;
        this.label = label;
        //this.coord = coord;
        this.stop_points = stop_points;
    }

    @NonNull
    @Override
    public String toString() {
        return "Stop_area:"+id+" "+name+" "+" "+label+" ";
    }
}
