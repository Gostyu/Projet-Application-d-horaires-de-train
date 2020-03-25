package com.upec.androidtemplate20192020.models;

public class StopDateTime{
 private String departure_date_time;
 public StopDateTime(String departure_date_time) {
  this.departure_date_time = departure_date_time;
 }
 public String getDeparture_date_time() {
  return departure_date_time;
 }

 public void setDeparture_date_time(String departure_date_time) {
  this.departure_date_time = departure_date_time;
 }
}
