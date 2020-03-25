package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Section {
    String type;
    String id;
    String mode;
    int duration;
    public JourneyInfo display_informations;

    public Section(String type, String id, String mode, int duration, Place from, Place to,JourneyInfo display_informations) {
        this.type = type;
        this.id = id;
        this.mode = mode;
        this.duration = duration;
        this.display_informations = display_informations;
    }

    @NonNull
    @Override
    public String toString() {
        return "type:"+type+" duration :"+duration+", mode:"+mode;
    }
}
