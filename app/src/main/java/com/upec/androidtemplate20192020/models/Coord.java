package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

//pour StopPoint
public class Coord implements Parcelable {
 float lat;
 float lon;
 public Coord(float lat, float lon) {
  this.lat = lat;
  this.lon = lon;
 }

 protected Coord(Parcel in) {
  lat = in.readFloat();
  lon = in.readFloat();
 }

 public static final Creator<Coord> CREATOR = new Creator<Coord>() {
  @Override
  public Coord createFromParcel(Parcel in) {
   return new Coord(in);
  }

  @Override
  public Coord[] newArray(int size) {
   return new Coord[size];
  }
 };

 public float getLat() {
  return lat;
 }

 public float getLon() {
  return lon;
 }

 @NonNull
 @Override
 public String toString() {
  return "Coord : {"+lat+";"+lon+"}";
 }

 @Override
 public int describeContents() {
  return 0;
 }

 @Override
 public void writeToParcel(Parcel dest, int flags) {
  dest.writeFloat(lat);
  dest.writeFloat(lon);
 }
}
