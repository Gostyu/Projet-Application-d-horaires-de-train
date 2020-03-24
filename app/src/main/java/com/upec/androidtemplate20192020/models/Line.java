package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

public class Line{
 String id;
 String name;

 public Line(String id, String name) {
  this.id = id;
  this.name = name;
 }

 public String getName() {
  return name;
 }

 @NonNull
 @Override
 public String toString() {
  return "Line:"+id+" "+name;
 }
}
