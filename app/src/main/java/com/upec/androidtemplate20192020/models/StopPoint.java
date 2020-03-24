package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

public class StopPoint{
 String name;
 String label;

 public StopPoint(String name, String label) {
  this.name = name;
  this.label = label;
 }

 public String getName() {
  return name;
 }

 public String getLabel() {
  return label;
 }

 @NonNull
 @Override
 public String toString() {
  return "Stop_point :"+name+" "+label;
 }
}
