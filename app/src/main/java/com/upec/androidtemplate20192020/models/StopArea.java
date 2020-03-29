package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class StopArea implements Parcelable {
    public String id;
    public String name;
    public String label;
    //Coord coord;
    ArrayList<StopPoint> stop_points;

    public StopArea(String id, String name, String label, Coord coord, ArrayList<StopPoint> stop_points) {
        this.id = id;
        this.name = name;
        this.label = label;
        //this.coord = coord;
        this.stop_points = stop_points;
    }


    protected StopArea(Parcel in) {
        id = in.readString();
        name = in.readString();
        label = in.readString();
        stop_points = in.createTypedArrayList(StopPoint.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(label);
        dest.writeTypedList(stop_points);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StopArea> CREATOR = new Creator<StopArea>() {
        @Override
        public StopArea createFromParcel(Parcel in) {
            return new StopArea(in);
        }

        @Override
        public StopArea[] newArray(int size) {
            return new StopArea[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getId() {
        return id;
    }

    @NonNull
    @Override
    public String toString() {
        return "Stop_area:"+id+" "+name+" "+" "+label+" ";
    }


}
