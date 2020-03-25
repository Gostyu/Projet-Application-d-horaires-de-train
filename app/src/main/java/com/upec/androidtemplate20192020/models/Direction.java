package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

public class Direction{
 String id;
 String name;
 StopArea stop_area;

 public Direction(String id, String name, StopArea stop_area) {
  this.id = id;
  this.name = name;
  this.stop_area = stop_area;
 }

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
}
