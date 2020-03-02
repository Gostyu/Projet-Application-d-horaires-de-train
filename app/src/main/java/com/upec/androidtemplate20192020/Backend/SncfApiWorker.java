package com.upec.androidtemplate20192020.Backend;

import android.util.Log;

import com.google.gson.Gson;
import com.upec.androidtemplate20192020.models.Departure;
import com.upec.androidtemplate20192020.models.Departures;
import com.upec.androidtemplate20192020.models.Stations;
import com.upec.androidtemplate20192020.models.StopArea;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SncfApiWorker {
    String TAG ="INFO_Response";
    private Retrofit retrofit;
    SncfApiService SncfApiServiceInstance;
    public SncfApiWorker() {
        retrofit = initRetrofit();
        setSncfApiServiceInstance(retrofit.create(SncfApiService.class));
    }

    Retrofit initRetrofit(){
         return new Retrofit.Builder().baseUrl(InfoApi.SNCF_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                 .build();
    }

    public void setSncfApiServiceInstance(SncfApiService sncfApiServiceInstance) {
        SncfApiServiceInstance = sncfApiServiceInstance;
    }

    public Call<Stations> getAllStations(){
        try{
            Call <Stations> response = SncfApiServiceInstance.getStopAreas();
            return response;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void getAllStationsResults(Call<Stations> response){
        response.enqueue(new Callback<Stations>() {
            @Override
            public void onResponse(Call<Stations> call, Response<Stations> response) {
                if(response.isSuccessful()){
                    Log.d(TAG,response.raw().toString());
                    if(response.body()!=null){
                        Log.d(TAG,response.body().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<Stations> call, Throwable t) {
                    Log.d("FAIL",t.toString());
            }
        });
    }
    public void getDepartures(Call<Departures> response){

    }
}
