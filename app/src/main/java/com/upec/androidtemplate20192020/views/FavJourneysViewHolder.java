package com.upec.androidtemplate20192020.views;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upec.androidtemplate20192020.R;


public class FavJourneysViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    ImageView imageView;
    TextView descriptionTv;
    public FavJourneysViewHolder(@NonNull View itemView,OnClickImageListener listener) {
        super(itemView);
        textView=itemView.findViewById(R.id.horaireTV_FT);
        imageView=itemView.findViewById(R.id.deleteJourney);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                   int pos=getAdapterPosition();
                   if(pos!=RecyclerView.NO_POSITION){
                       listener.onDeleteSavedJourney(pos);
                   }
                }
            }
        });
    }
    public void updateUI(String time){
        Log.d("UPDATE_UI_FJVH",time);
        textView.setText(time);
    }

}
