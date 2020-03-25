package com.upec.androidtemplate20192020.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.upec.androidtemplate20192020.R;

import java.util.List;

public class JourneySncfViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    TextView textView;
    List<ImageView> imageViews;
    public JourneySncfViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardViewJourney);
        textView=itemView.findViewById(R.id.timeJourney);
    }
    public void updateUI(String time){
        textView.setText(time);
    }
}
