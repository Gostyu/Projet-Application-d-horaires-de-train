package com.upec.androidtemplate20192020.Backend;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.upec.androidtemplate20192020.fragments.JourneyFragment;
import com.upec.androidtemplate20192020.fragments.StationsFragment;
import com.upec.androidtemplate20192020.fragments.TrainsFragment;
import com.upec.androidtemplate20192020.models.ResponseDepartures;
import com.upec.androidtemplate20192020.models.ResponseStopAreas;
import com.upec.androidtemplate20192020.models.StopArea;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SncfApiWorker {
    static TrainsFragment trainsFragment;
    static StationsFragment stationsFragment;
    static JourneyFragment journeyFragment;
    static String TAG ="INFO_Response";
    static int MAX_RETRIES = 3;
   static SncfApiService SncfApiServiceInstance=sncfApiServiceSingleton();
   public SncfApiWorker(Fragment fragment){
       if(fragment instanceof TrainsFragment){
           trainsFragment = (TrainsFragment) fragment;
       }else if(fragment instanceof StationsFragment){
           stationsFragment=(StationsFragment) fragment;
       }else if(fragment instanceof JourneyFragment){
          journeyFragment=(JourneyFragment) fragment;
       }
   }
   private static SncfApiService sncfApiServiceSingleton(){
         return new Retrofit.Builder().baseUrl(InfoApi.SNCF_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                 .build().create(SncfApiService.class);
    }

    public void requestAllStationsResults() {
       Log.d("SEND ALLSTATIONSRES","OK");
        try{
            Call <ResponseStopAreas> stopAreasCall = SncfApiServiceInstance.getStopAreas();
            stopAreasCall.enqueue(handleResponseAllStations());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private Callback<ResponseStopAreas> handleResponseAllStations() {
        return new Callback<ResponseStopAreas>() {
            @Override
            public void onResponse(Call<ResponseStopAreas> call, Response<ResponseStopAreas> response) {
                if(response.body()!=null){
                   Log.d(TAG +"ALLStations",response.body().toString());
                    trainsFragment.getAllStationsResults(response.body());
                }else{
                    Log.d(TAG+"Deparatures", response.raw().toString());
                }
            }
            @Override
            public void onFailure(Call<ResponseStopAreas> call, Throwable t) {
                Log.e(TAG+"ALLStations",t.toString());

            }
        };
    }
    public static void requestDeparturesByStopAreaName(String stopAreaName){
       try{
            Call<ResponseStopAreas> StopAreasCall = SncfApiServiceInstance.getStopAreas();
            StopAreasCall.enqueue(handleResponseDeparturesByStopAreaName(stopAreaName));
       }catch(Exception e){
           e.printStackTrace();
       }
    }

    private static Callback<ResponseStopAreas> handleResponseDeparturesByStopAreaName(String stopAreaName) {
        return new Callback<ResponseStopAreas>() {
            @Override
            public void onResponse(Call<ResponseStopAreas> call, Response<ResponseStopAreas> response) {
                if(response.isSuccessful()){
                    Log.d(TAG+" DepBySTName", stopAreaName);
                    Log.d(TAG+" DepBySTName", response.raw().toString());
                    if(response.body()!=null){
                        List<StopArea> areaList = response.body().getStop_areas();
                        Log.d(TAG+" DepBySTName", areaList.toString());
                        for(StopArea s :areaList){
                            if(s.getName().toLowerCase().equals(stopAreaName.toLowerCase())){
                                Log.d(TAG+" DepBySTName","TEST OK");
                                Log.d(TAG+" DepBySTName",s.getName()+ " "+s.getId());
                                requestDeparturesByStopAreaId(s.getId());
                            }
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseStopAreas> call, Throwable t) {

            }
        };
   }
    private static void requestDeparturesByStopAreaId(String id){
       try{
           Call<ResponseDepartures> departuresCall= SncfApiServiceInstance.getDeparturesFromStopAreaId(id);
           departuresCall.enqueue(handleResponseDeparturesByStopAreaId());
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    private static Callback<ResponseDepartures> handleResponseDeparturesByStopAreaId(){
       return new Callback<ResponseDepartures>() {
           @Override
           public void onResponse(Call<ResponseDepartures> call, Response<ResponseDepartures> response) {
               if(response.body()!=null){
                   Log.d(TAG+"DepBYStAId",response.body().toString());
                   trainsFragment.createRecylerView(response.body().getDepartures());
                   Log.d(TAG+"DepBYStAId size = ",String.valueOf(response.body().getDepartures().size()));
               }else{
                   Log.d(TAG+"DepBYStAId",response.raw().toString());
               }
           }
           @Override
           public void onFailure(Call<ResponseDepartures> call, Throwable t) {

           }
       };
    }
/*public static void getDeparturesByStopAreaId(String id){
        try {
            Log.d("SNCF_API","getDeparturesByStopAreaID OK");
          Call<ResponseDepartures> response=SncfApiServiceInstance.getDeparturesFromStopArea(id);
          response.enqueue(handleResponseGetAllDeparturesByStopAreaId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Callback<ResponseDepartures> handleResponseGetAllDeparturesByStopAreaId() {
        return new Callback<ResponseDepartures>() {
            @Override
            public void onResponse(Call<ResponseDepartures> call, Response<ResponseDepartures> response) {

                if(response.body()!=null){
                   Log.d(TAG+"Deparatures", response.body().toString());
                }else{
                    Log.d(TAG+"Deparatures", response.raw().toString());
                }
            }
            @Override
            public void onFailure(Call<ResponseDepartures> call, Throwable t) {
                    Log.d(TAG+"Departures",t.toString());
            }
        } ;
   }*/
    /*public static void getDeparturesByStopAreaIdResults(Call<ResponseDepartures> response) {
        Log.d("getDeparturesbySAIR","Ok");
        trainsFragment.getAllDepartures(response);
    }

    public void getJourneys(String from, String to){
        try{
            Call<Journeys> response= SncfApiServiceInstance.getJourneys(from,to);

        }catch(Exception e){
            e.printStackTrace();
        }
    }*/
     /*public void getDepartures(String from,Call<ResponseDepartures> response){
        try{
           // LocalDate localDate = LocalDate.now();
            //localDate.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            //return SncfApiServiceInstance.getDeparturesFromStopArea(from,)
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
