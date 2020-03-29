package com.upec.androidtemplate20192020.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upec.androidtemplate20192020.R;
import com.upec.androidtemplate20192020.models.Departure;

import java.util.List;

public class horaireSncfAdapter extends RecyclerView.Adapter<horaireSncfViewHolder> {
    private List<Departure> departures;
    public horaireSncfAdapter(List<Departure> departures){
        this.departures=departures;
    }
    @NonNull
    @Override
    public horaireSncfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_item_stations, parent,false);
        return new horaireSncfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull horaireSncfViewHolder vh, int position) {
        String nameDirection = departures.get(position).getRoute().getDirection().getName();
        String horaire=departures.get(position).getStopDateTime();
        vh.updateUI(nameDirection,horaire);
    }

    @Override
    public int getItemCount() {
        return departures.size();
    }
}