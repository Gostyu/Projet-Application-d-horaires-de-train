package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.jar.Pack200;

public class Place implements Parcelable {
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

    protected Place(Parcel in) {
        name = in.readString();
        stop_area = in.readParcelable(StopArea.class.getClassLoader());
        stop_point = in.readParcelable(StopPoint.class.getClassLoader());
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        return "name : "+name+" "+ stop_area.toString()+" "+stop_point.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(stop_area, flags);
        dest.writeParcelable(stop_point, flags);
    }
}


