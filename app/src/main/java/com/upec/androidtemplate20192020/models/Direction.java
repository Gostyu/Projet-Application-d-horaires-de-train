package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Direction implements Parcelable {
 String id;
 String name;
 StopArea stop_area;

 public Direction(String id, String name, StopArea stop_area) {
  this.id = id;
  this.name = name;
  this.stop_area = stop_area;
 }

 protected Direction(Parcel in) {
  id = in.readString();
  name = in.readString();
  stop_area = in.readParcelable(StopArea.class.getClassLoader());
 }

 public static final Creator<Direction> CREATOR = new Creator<Direction>() {
  @Override
  public Direction createFromParcel(Parcel in) {
   return new Direction(in);
  }

  @Override
  public Direction[] newArray(int size) {
   return new Direction[size];
  }
 };

 public String getName() {
  return name;
 }

 public StopArea getStop_area() {
  return stop_area;
 }

 @NonNull
 @Override
 public String toString() {
  return "Stop_area :"+id+" "+name+", "+stop_area.toString();
 }

 @Override
 public int describeContents() {
  return 0;
 }

 @Override
 public void writeToParcel(Parcel dest, int flags) {
  dest.writeString(id);
  dest.writeString(name);
  dest.writeParcelable(stop_area, flags);
 }
}
