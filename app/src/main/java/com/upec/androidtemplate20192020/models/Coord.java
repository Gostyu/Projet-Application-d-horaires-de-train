package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

//pour StopPoint
public class Coord{
 float lat;
 float lon;
 public Coord(float lat, float lon) {
  this.lat = lat;
  this.lon = lon;
 }

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
}
