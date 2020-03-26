package com.upec.androidtemplate20192020.views;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upec.androidtemplate20192020.R;
import com.upec.androidtemplate20192020.models.Departure;
import com.upec.androidtemplate20192020.models.Journey;

import java.util.List;

public class JourneySncfAdapter extends RecyclerView.Adapter<JourneySncfViewHolder> {
    List<Journey> journeyList;
    int position;
    static OnClickImageListener listener;

    public static OnClickImageListener getListener() {
        return listener;
    }
    public void setOnClickImageListener(OnClickImageListener listener){
        this.listener=listener;
    }

    public JourneySncfAdapter(List<Journey> journeyList) {
        this.journeyList = journeyList;
    }

    public static void saveJourney(int position) {
        Log.d("SAVEJOURNEY","pos:"+position);
    }

    @NonNull
    @Override
    public JourneySncfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.journeys_rv_item, parent, false);
        return new JourneySncfViewHolder(view,listener);
    }


    @Override
    public void onBindViewHolder(@NonNull JourneySncfViewHolder vh, int position) {
        String timeJourney = journeyList.get(position).getTotalJourneyTime();
        vh.updateUI(timeJourney);
    }

    @Override
    public int getItemCount() {
        return journeyList.size();
    }
}