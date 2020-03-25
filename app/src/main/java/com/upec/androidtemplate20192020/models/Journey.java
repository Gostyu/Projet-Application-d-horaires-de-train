package com.upec.androidtemplate20192020.models;

import android.util.Log;

import androidx.annotation.NonNull;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Map;

public class Journey {
    int duration;
    Map<String,Integer> durations;
    List<Section> sections;
    String arrival_date_time;
    public Journey(int duration,Map<String,Integer>durations,String arrival_date_time,List<Section> sections){
        this.duration=duration;
        this.durations=durations;
        this.arrival_date_time=arrival_date_time;
        this.sections=sections;
    }

    @NonNull
    @Override
    public String toString() {
        return "duration :" +duration+", arrival datetime :"+arrival_date_time+", durations : "+durations.toString()+", sections :"+sections.toString();
    }

    public List<Section> getSections() {
        return sections;
    }

    public String getTotalJourneyTime() {
        StringBuilder str=new StringBuilder();
        String hour;
        String minutes;
        String seconds;
        int SEC_ONE_MIN=60;
        int SEC_ONE_HOUR=3600;
        if(duration!=0) {
            //pour un trajet d'au moins une heure
            if(duration>=SEC_ONE_HOUR){
                hour= String.valueOf(duration/SEC_ONE_HOUR);
                minutes=String.valueOf((duration/SEC_ONE_MIN)%SEC_ONE_MIN);
                str.append(hour+"h"+minutes+"min");
            }
            //pour un trajet d'au moins une heure
            if(duration>SEC_ONE_MIN && duration<SEC_ONE_HOUR){
                minutes=String.valueOf(duration/SEC_ONE_MIN);
                seconds=String.valueOf(duration%SEC_ONE_MIN);
                if(Integer.parseInt(seconds)!=0){
                    str.append(minutes+"min"+seconds+"s");
                }else {
                    str.append(minutes + "min");
                }
            }
        }
        return str.toString();
    }

    public String getArrival_date_time(){
        try{
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMd'T'Hms");
            DateTime dateTime= DateTime.parse(arrival_date_time,formatter);
            Log.d("NEW DATE",dateTime.toString());
            Log.d("NEW DATE",dateTime.toString("HH:mm"));
            return dateTime.toString("HH:mm");
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }

        return null;
    }
}
