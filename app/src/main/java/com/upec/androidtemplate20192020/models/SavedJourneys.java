package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SavedJourneys {
    Set<Journey> mJourneys;
    public SavedJourneys(){
        mJourneys=new LinkedHashSet<>();
    }
    public void addJourney(Journey j){
        mJourneys.add(j);
    }
    public ArrayList<Journey> getJourneys() {
        ArrayList<Journey> journeys= new ArrayList<>(mJourneys);
        return journeys;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(Journey j:mJourneys){
            str.append(j.toString());
        }
        return str.toString();
    }
}
