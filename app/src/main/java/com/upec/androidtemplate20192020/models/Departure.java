package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.ArrayList;

public class Departure implements Parcelable {
 private Route route;
 private StopPoint stop_point;
private StopDateTime stop_date_time;
 public Departure(Route route, StopPoint stop_point,StopDateTime time) {
  this.route = route;
  this.stop_point = stop_point;
  this.stop_date_time=time;
 }

 protected Departure(Parcel in) {
  route = in.readParcelable(Route.class.getClassLoader());
  stop_point = in.readParcelable(StopPoint.class.getClassLoader());
  stop_date_time = in.readParcelable(StopDateTime.class.getClassLoader());
 }

 public static final Creator<Departure> CREATOR = new Creator<Departure>() {
  @Override
  public Departure createFromParcel(Parcel in) {
   return new Departure(in);
  }

  @Override
  public Departure[] newArray(int size) {
   return new Departure[size];
  }
 };

 @NonNull
 @Override
 public String toString() {
  return route.toString()+", "+stop_point.toString();
 }
 public Route getRoute(){return route;}
 public StopPoint getStop_point(){return stop_point;}
 public void setStop_date_time(){

 }
 public String getStopDateTime(){

  try{
   DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMd'T'Hms");
   DateTime dateTime= DateTime.parse(stop_date_time.getDeparture_date_time(),formatter);
   Log.d("NEW DATE",dateTime.toString());
   Log.d("NEW DATE",dateTime.toString("HH:mm"));
   return dateTime.toString("HH:mm");
  }catch(IllegalArgumentException e){
   e.printStackTrace();
  }
  return null;
 }

 @Override
 public int describeContents() {
  return 0;
 }

 @Override
 public void writeToParcel(Parcel dest, int flags) {
  dest.writeParcelable(route, flags);
  dest.writeParcelable(stop_point, flags);
  dest.writeParcelable(stop_date_time, flags);
 }
 /*public String getDepartureHour() {
  DateTime dateTime = new DateTime(getStopDateTime());

  return dateTime.hourOfDay().toString();
 }*/
}

