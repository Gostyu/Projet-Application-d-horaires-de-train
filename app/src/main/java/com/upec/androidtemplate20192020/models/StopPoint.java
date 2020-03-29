package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class StopPoint implements Parcelable {
 String name;
 String label;

 public StopPoint(String name, String label) {
  this.name = name;
  this.label = label;
 }

 protected StopPoint(Parcel in) {
  name = in.readString();
  label = in.readString();
 }

 public static final Creator<StopPoint> CREATOR = new Creator<StopPoint>() {
  @Override
  public StopPoint createFromParcel(Parcel in) {
   return new StopPoint(in);
  }

  @Override
  public StopPoint[] newArray(int size) {
   return new StopPoint[size];
  }
 };

 public String getName() {
  return name;
 }

 public String getLabel() {
  return label;
 }

 @NonNull
 @Override
 public String toString() {
  return "Stop_point :"+name+" "+label;
 }

 @Override
 public int describeContents() {
  return 0;
 }

 @Override
 public void writeToParcel(Parcel dest, int flags) {
  dest.writeString(name);
  dest.writeString(label);
 }
}
