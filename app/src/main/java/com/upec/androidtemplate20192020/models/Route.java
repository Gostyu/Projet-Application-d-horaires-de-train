package com.upec.androidtemplate20192020.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Route implements Parcelable {
 String id;
 Direction direction;

 public Route(String id, Direction direction) {
  this.id = id;
  this.direction = direction;
 }

 protected Route(Parcel in) {
  id = in.readString();
  direction = in.readParcelable(Direction.class.getClassLoader());
 }

 public static final Creator<Route> CREATOR = new Creator<Route>() {
  @Override
  public Route createFromParcel(Parcel in) {
   return new Route(in);
  }

  @Override
  public Route[] newArray(int size) {
   return new Route[size];
  }
 };

 public Direction getDirection() {
  return direction;
 }

 @NonNull
 @Override
 public String toString() {
  return "Route:"+id+","+direction.toString();
 }

 @Override
 public int describeContents() {
  return 0;
 }

 @Override
 public void writeToParcel(Parcel dest, int flags) {
  dest.writeString(id);
  dest.writeParcelable(direction, flags);
 }
}
