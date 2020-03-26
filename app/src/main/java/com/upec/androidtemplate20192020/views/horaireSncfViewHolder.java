package com.upec.androidtemplate20192020.views;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.upec.androidtemplate20192020.R;

/*
Crée
 */
public class horaireSncfViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    TextView directionTv;
    TextView horaireTv;
    String TAG="Départ à ";
    public horaireSncfViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView=itemView.findViewById(R.id.cardView);
        directionTv= itemView.findViewById(R.id.directionTv);
        horaireTv=itemView.findViewById(R.id.horaireTV);
    }
    public void updateUI(String directionName, String horaire, long itemId){
        directionTv.setText(directionName);
        horaireTv.setText(horaire +" pos "+ itemId);
    }
    public void updateUI(String directionName, String horaire){
        directionTv.setText(directionName);
        horaireTv.setText(horaire);
    }
}
