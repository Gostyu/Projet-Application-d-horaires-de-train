package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.ArrayList;

public class Departure {
 private Route route;
 private StopPoint stop_point;
private StopDateTime stop_date_time;
 public Departure(Route route, StopPoint stop_point,StopDateTime time) {
  this.route = route;
  this.stop_point = stop_point;
  this.stop_date_time=time;
 }

 @NonNull
 @Override
 public String toString() {
  return route.toString()+", "+stop_point.toString();
 }
 public Route getRoute(){return route;}
 public StopPoint getStop_point(){return stop_point;}
 public void setStop_date_time(){
 // LocalDateTime localDateTime = LocalDateTime.parse(getStopDateTime(),);

 //dateTimeFormatter.print()
 }
 public String getStopDateTime(){
   return stop_date_time.getDeparture_date_time();
 }
}

