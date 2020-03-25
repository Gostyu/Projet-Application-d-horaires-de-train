package com.upec.androidtemplate20192020.views;

<<<<<<< HEAD
import android.content.Context;
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
    public JourneySncfAdapter(List<Journey> journeyList) {
        this.journeyList=journeyList;
    }

    @NonNull
    @Override
    public JourneySncfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.journeys_rv_item,parent,false);
        return new JourneySncfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JourneySncfViewHolder vh, int position) {
        String timeJourney =journeyList.get(position).getTotalJourneyTime();
        vh.updateUI(timeJourney);
    }

    @Override
    public int getItemCount() {
        return journeyList.size();
    }
=======
public class JourneySncfAdapter {
>>>>>>> a195ba196185235f115a53cf4db2a70c8cd17c57
}
