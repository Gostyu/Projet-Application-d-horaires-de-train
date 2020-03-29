package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;

public class StopDateTime implements Parcelable {
 private String departure_date_time;
 public StopDateTime(String departure_date_time) {
  this.departure_date_time = departure_date_time;
 }

 protected StopDateTime(Parcel in) {
  departure_date_time = in.readString();
 }

 public static final Creator<StopDateTime> CREATOR = new Creator<StopDateTime>() {
  @Override
  public StopDateTime createFromParcel(Parcel in) {
   return new StopDateTime(in);
  }

  @Override
  public StopDateTime[] newArray(int size) {
   return new StopDateTime[size];
  }
 };

 public String getDeparture_date_time() {
  return departure_date_time;
 }

 public void setDeparture_date_time(String departure_date_time) {
  this.departure_date_time = departure_date_time;
 }

 @Override
 public int describeContents() {
  return 0;
 }

 @Override
 public void writeToParcel(Parcel dest, int flags) {
  dest.writeString(departure_date_time);
 }
}
