package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Place {
    String name;
    @SerializedName("value=stopArea")
    StopArea stop_area;
    @SerializedName("value=stopPoint")
    StopPoint stop_point;

    public Place(String name, StopArea stop_area, StopPoint stop_point) {
        this.name = name;
        this.stop_area = stop_area;
        this.stop_point = stop_point;
    }

    @NonNull
    @Override
    public String toString() {
        return "name : "+name+" "+ stop_area.toString()+" "+stop_point.toString();
    }
}


