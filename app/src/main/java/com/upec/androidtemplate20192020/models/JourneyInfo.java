package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import java.util.List;

public class JourneyInfo {
    public String network;
    public String direction;
    public String commercial_mode;
    public String physical_mode;
    public String label;
    public String color;
    public String code;
    public String description;
    public List<String> equipments;

    public JourneyInfo(String network, String direction, String commercial_mode, String physical_mode, String label, String color, String code, String description, List<String> equipments) {
        this.network = network;
        this.direction = direction;
        this.commercial_mode = commercial_mode;
        this.physical_mode = physical_mode;
        this.label = label;
        this.color = color;
        this.code = code;
        this.description = description;
        this.equipments = equipments;
    }

    @NonNull
    @Override
    public String toString() {
        return direction+ " ";
    }
}
