package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Departure {
 Route route;
 StopPoint stop_point;

 public Departure(Route route, StopPoint stop_point) {
  this.route = route;
  this.stop_point = stop_point;
 }

 @NonNull
 @Override
 public String toString() {
  return route.toString()+", "+stop_point.toString();
 }
}
class StopDateTime{
 String departure_date_time;
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
class Route{
 String id;
 Direction direction;

 public Route(String id, Direction direction) {
  this.id = id;
  this.direction = direction;
 }

 @NonNull
 @Override
 public String toString() {
  return "Route:"+id+","+direction.toString();
 }
}
class Line{
 String id;
 String name;

 public Line(String id, String name) {
  this.id = id;
  this.name = name;
 }

 @NonNull
 @Override
 public String toString() {
  return "Line:"+id+" "+name;
 }
}
class Direction{
 String id;
 String name;
 StopArea stop_area;

 public Direction(String id, String name, StopArea stop_area) {
  this.id = id;
  this.name = name;
  this.stop_area = stop_area;
 }

 @NonNull
 @Override
 public String toString() {
  return "Stop_area :"+id+" "+name+", "+stop_area.toString();
 }
}
class StopPoint{
 String name;
 String label;

 public StopPoint(String name, String label) {
  this.name = name;
  this.label = label;
 }

 @NonNull
 @Override
 public String toString() {
  return "Stop_point :"+name+" "+label;
 }
}
//pour StopPoint
class Coord{
 float lat;
 float lon;
 public Coord(float lat, float lon) {
  this.lat = lat;
  this.lon = lon;
 }

 @NonNull
 @Override
 public String toString() {
  return "Coord : {"+lat+";"+lon+"}";
 }
}
