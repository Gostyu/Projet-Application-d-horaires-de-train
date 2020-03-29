package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Section implements Parcelable {
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

    protected Section(Parcel in) {
        type = in.readString();
        id = in.readString();
        mode = in.readString();
        duration = in.readInt();
    }

    public static final Creator<Section> CREATOR = new Creator<Section>() {
        @Override
        public Section createFromParcel(Parcel in) {
            return new Section(in);
        }

        @Override
        public Section[] newArray(int size) {
            return new Section[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        return "type:"+type+" duration :"+duration+", mode:"+mode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(id);
        dest.writeString(mode);
        dest.writeInt(duration);
    }
}
