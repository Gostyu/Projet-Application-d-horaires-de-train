package com.upec.androidtemplate20192020.views;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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
    ImageView imageView;
    List<ImageView> imageViews;
    public JourneySncfViewHolder(@NonNull View itemView,OnClickImageListener listener) {
        super(itemView);
        cardView = itemView.findViewById(R.id.cardViewJourney);
        textView=itemView.findViewById(R.id.timeJourney);
        imageView=itemView.findViewById(R.id.saveJourney);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    int pos=getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){
                        listener.onSaveJourney(pos);
                    }
                }
            }
        });
    }

    public void updateUI(String time){
        textView.setText(time);
    }
}
