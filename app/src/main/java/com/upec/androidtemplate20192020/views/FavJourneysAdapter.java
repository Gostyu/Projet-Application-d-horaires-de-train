package com.upec.androidtemplate20192020.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upec.androidtemplate20192020.R;
import com.upec.androidtemplate20192020.models.Journey;

import java.util.List;

public class FavJourneysAdapter extends RecyclerView.Adapter<FavJourneysViewHolder> {
    List<Journey> mjourneyList;
    static OnClickImageListener listener;

    public void setOnClickImageListener(OnClickImageListener listener) {
        FavJourneysAdapter.listener = listener;
    }

    public FavJourneysAdapter(List<Journey> journeyList){
        mjourneyList=journeyList;
    }
    @NonNull
    @Override
    public FavJourneysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_item_fav_journeys, parent, false);
        return new FavJourneysViewHolder(view,listener);
    }
    @Override
    public void onBindViewHolder(@NonNull FavJourneysViewHolder viewHolder, int position) {
        String time=mjourneyList.get(position).getTotalJourneyTime();
        viewHolder.updateUI(time);
    }


    @Override
    public int getItemCount() {
        return mjourneyList.size();
    }
}
