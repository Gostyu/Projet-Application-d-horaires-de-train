package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class JourneyInfo implements Parcelable {
    public String network;
    public String direction;
    public String commercial_mode;
    public String physical_mode;
    public String label;
    public String color;
    public String code;
    public String description;
    //public List<String> equipments;

    public JourneyInfo(String network, String direction, String commercial_mode, String physical_mode, String label, String color, String code, String description) {
        this.network = network;
        this.direction = direction;
        this.commercial_mode = commercial_mode;
        this.physical_mode = physical_mode;
        this.label = label;
        this.color = color;
        this.code = code;
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return "direction: "+direction+ ", network :"+network+", code: "+code+" ";
    }

    protected JourneyInfo(Parcel in) {
        network = in.readString();
        direction = in.readString();
        commercial_mode = in.readString();
        physical_mode = in.readString();
        label = in.readString();
        color = in.readString();
        code = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(network);
        dest.writeString(direction);
        dest.writeString(commercial_mode);
        dest.writeString(physical_mode);
        dest.writeString(label);
        dest.writeString(color);
        dest.writeString(code);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<JourneyInfo> CREATOR = new Creator<JourneyInfo>() {
        @Override
        public JourneyInfo createFromParcel(Parcel in) {
            return new JourneyInfo(in);
        }

        @Override
        public JourneyInfo[] newArray(int size) {
            return new JourneyInfo[size];
        }
    };
}
