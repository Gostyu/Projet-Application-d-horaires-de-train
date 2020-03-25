package com.upec.androidtemplate20192020.Backend;

<<<<<<< HEAD
import android.content.Context;
=======
>>>>>>> 7ef9f95a21a4a5b477500a6150065539c0e1b790
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.upec.androidtemplate20192020.fragments.JourneyFragment;
import com.upec.androidtemplate20192020.fragments.StationsFragment;
import com.upec.androidtemplate20192020.fragments.TrainsFragment;
import com.upec.androidtemplate20192020.models.Journey;
<<<<<<< HEAD
import com.upec.androidtemplate20192020.models.ResponseCoverageZoneList;
=======
>>>>>>> 7ef9f95a21a4a5b477500a6150065539c0e1b790
import com.upec.androidtemplate20192020.models.ResponseDepartures;
import com.upec.androidtemplate20192020.models.ResponseJourneys;
import com.upec.androidtemplate20192020.models.ResponseStopAreas;
import com.upec.androidtemplate20192020.models.StopArea;

<<<<<<< HEAD
=======
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

>>>>>>> 7ef9f95a21a4a5b477500a6150065539c0e1b790
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SncfApiWorker {
<<<<<<< HEAD

    Context context;

=======
>>>>>>> 7ef9f95a21a4a5b477500a6150065539c0e1b790
    static TrainsFragment trainsFragment;
    static StationsFragment stationsFragment;
    static JourneyFragment journeyFragment;
    static String TAG ="INFO_Response";
    static int MAX_RETRIES = 3;
    static ResponseStopAreas mRepsonseStopAreas;
    static SncfApiService SncfApiServiceInstance=sncfApiServiceSingleton();
<<<<<<< HEAD




=======
>>>>>>> 7ef9f95a21a4a5b477500a6150065539c0e1b790
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

<<<<<<< HEAD
    /******************************************************************/




    public void requestCoverageResult(){
        Log.d("SEND ALLCOVERAGE","OK");
       // Toast.makeText(getApplicationContext(),"TEST",Toast.LENGTH_LONG).show();
       try{
             Call <ResponseCoverageZoneList> coverageZoneListCall=SncfApiServiceInstance.getCoverageZoneList();
             coverageZoneListCall.enqueue(handleResponseCoverageZoneList());
        }catch(Exception e){
           e.printStackTrace();
       }
    }

    private Callback<ResponseCoverageZoneList> handleResponseCoverageZoneList(){

        return new Callback<ResponseCoverageZoneList>() {
            @Override
            public void onResponse(Call<ResponseCoverageZoneList> call, Response<ResponseCoverageZoneList> response) {

            }

            @Override
            public void onFailure(Call<ResponseCoverageZoneList> call, Throwable t) {

            }
        };
    }

    /*******************************************************************/

=======
>>>>>>> 7ef9f95a21a4a5b477500a6150065539c0e1b790
    private Callback<ResponseStopAreas> handleResponseAllStations() {
        return new Callback<ResponseStopAreas>() {
            @Override
            public void onResponse(Call<ResponseStopAreas> call, Response<ResponseStopAreas> response) {
                if(response.body()!=null){
                   Log.d(TAG +"ALLStations",response.body().toString());
                    mRepsonseStopAreas=response.body();
                    if(trainsFragment!=null) {
                        trainsFragment.getAllStationsResults(response.body());
                    }
                    if(journeyFragment!=null) {
                        journeyFragment.getAllStationsResults(response.body());
                    }
                    if(stationsFragment!=null){

<<<<<<< HEAD

=======
>>>>>>> 7ef9f95a21a4a5b477500a6150065539c0e1b790
                    }
                }else{
                    Log.d(TAG+"Deparatures", response.raw().toString());
                }
            }
            @Override
            public void onFailure(Call<ResponseStopAreas> call, Throwable t) {
                Log.e(TAG+"ALLStations",t.toString());
                call.clone().enqueue(handleResponseAllStations());
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
                   if(response.body().getDepartures().size()>0){
                       Log.d(TAG+"DepBYStAId size = ",String.valueOf(response.body().getDepartures().size()));
                       String dateDepart=response.body().getDepartures().get(0).getStopDateTime();
                       if(dateDepart!=null) {
                           Log.d("DATE FOR DEPARTURE", dateDepart);
                           try{
                               //DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMd'T'Hms");
                               //DateTime dateTime= DateTime.parse(dateDepart,formatter);
                              // String hour=dateTime.toString("HH:mm");
                              // Log.d("NEW DATE",dateTime.toString());
                              // Log.d("NEW DATE",hour);
                           }catch(IllegalArgumentException e){
                               e.printStackTrace();
                           }
                       }

                     }
               }else{
                   if(trainsFragment ==null){
                       Log.d("INfO trainfragment","null");
                   }
                   Toast.makeText(trainsFragment.getContext(),"Liste des départs indisponible !",Toast.LENGTH_LONG).show();
                   Log.d(TAG+"DepBYStAId",response.raw().toString());
               }
           }
           @Override
           public void onFailure(Call<ResponseDepartures> call, Throwable t) {

           }
       };
    }
    public void getJourneys(String from, String to){
       String stopAreaId_from="";
        String stopAreasId_to="";
       if(mRepsonseStopAreas!=null) {
           Log.d("GETJOURNEY", mRepsonseStopAreas.toString());
           stopAreaId_from=mRepsonseStopAreas.getStopAreaId(from);
           stopAreasId_to=mRepsonseStopAreas.getStopAreaId(to);
           try {
               Call<ResponseJourneys> journeyCall = SncfApiServiceInstance.getJourneys(stopAreaId_from,stopAreasId_to);
               journeyCall.enqueue(handleResponseJourneys());
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
    private static Callback<ResponseJourneys> handleResponseJourneys(){
       return new Callback<ResponseJourneys>(){
           @Override
           public void onResponse(Call<ResponseJourneys> call, Response<ResponseJourneys> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        Log.d("HRJ OK",response.raw().toString());
                        Log.d("HRJ OK",response.body().toString());
                        Log.d("HRJ OK","count of journeys :"+String.valueOf(response.body().getJourneys().size()));
                        //journeyFragment
                        sendDataTo(journeyFragment,response.body().getJourneys());
                    }
                }else{
                    Log.d("HRJ",response.raw().toString());
                }
           }

           @Override
           public void onFailure(Call<ResponseJourneys> call, Throwable t) {

           }
       };
    }

    private static void sendDataTo(JourneyFragment journeyFragment, List<Journey> journeys) {

    }


}
