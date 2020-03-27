package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

//pour StopPoint
public class Coord{


 private double lat;
 private double lon;


 public Coord(float lat, float lon) {
  this.lat = lat;
  this.lon = lon;
 }

 public double getLat() {
  return lat;
 }

 public double getLon() {
  return lon;
 }

 @NonNull
 @Override
 public String toString() {
  return "Coord : {"+lat+";"+lon+"}";
 }


}
