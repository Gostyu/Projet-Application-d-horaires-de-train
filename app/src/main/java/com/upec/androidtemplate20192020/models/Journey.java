package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import java.util.Map;

public class Journey {
    int duration;
    Map<String,Integer> durations;
    String arrival_date_time;
    public Journey(int duration,Map<String,Integer>durations,String arrival_date_time){
        this.duration=duration;
        this.durations=durations;
        this.arrival_date_time=arrival_date_time;
    }

    @NonNull
    @Override
    public String toString() {
        return "duration :" +duration+", arrival datetime :"+arrival_date_time+", durations : "+durations.toString();
    }
}
