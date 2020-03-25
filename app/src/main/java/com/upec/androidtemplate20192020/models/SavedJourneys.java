package com.upec.androidtemplate20192020.models;

import java.util.Set;

public class SavedJourneys {
    Set<Journey> journeys;//ne prend pas les doublons
    public void addJourney(Journey j){
        journeys.add(j);
    }

    public Set<Journey> getJourneys() {
        return journeys;
    }
}
