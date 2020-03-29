package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Line implements Parcelable {
 String id;
 String name;

 public Line(String id, String name) {
  this.id = id;
  this.name = name;
 }

 protected Line(Parcel in) {
  id = in.readString();
  name = in.readString();
 }

 public static final Creator<Line> CREATOR = new Creator<Line>() {
  @Override
  public Line createFromParcel(Parcel in) {
   return new Line(in);
  }

  @Override
  public Line[] newArray(int size) {
   return new Line[size];
  }
 };

 public String getName() {
  return name;
 }

 @NonNull
 @Override
 public String toString() {
  return "Line:"+id+" "+name;
 }

 @Override
 public int describeContents() {
  return 0;
 }

 @Override
 public void writeToParcel(Parcel dest, int flags) {
  dest.writeString(id);
  dest.writeString(name);
 }
}
