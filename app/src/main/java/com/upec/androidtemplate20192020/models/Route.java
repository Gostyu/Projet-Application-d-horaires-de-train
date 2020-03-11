package com.upec.androidtemplate20192020.models;

import androidx.annotation.NonNull;

public class Route{
 String id;
 Direction direction;

 public Route(String id, Direction direction) {
  this.id = id;
  this.direction = direction;
 }

 public Direction getDirection() {
  return direction;
 }

 @NonNull
 @Override
 public String toString() {
  return "Route:"+id+","+direction.toString();
 }
}
