package com.upec.androidtemplate20192020.Backend;


import com.upec.androidtemplate20192020.models.ResponseDepartures;
import com.upec.androidtemplate20192020.models.Journeys;
import com.upec.androidtemplate20192020.models.ResponseStopAreas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SncfApiService {
    String PATH="coverage/fr-idf/";
    String rerNetwork="network:0:741";
    String physical_mode="physical_mode:RapidTransit";
    /**
     * Donne la liste de toutes les gares du réseau RER sans les perturbations
     * @return
     */
    @Headers({"Authorization:"+InfoApi.SNCF_API_KEY,"Connection:keep-alive"})
    @GET(PATH+"networks/"+rerNetwork+"/physical_modes/"+physical_mode+"/stop_areas?count=250&disable_disruption=true")
    Call<ResponseStopAreas> getStopAreas();

    //@Headers("Authorization:"+InfoApi.SNCF_API_KEY)
    //@GET(PATH+"commercial_modes/commercial_mode:rer/stop_areas?count=255")
    //Call<ResponseStopAreas> getStopsAreasByName(@Query("q") String name);

    /*Donne la liste des départs de trains à partir de l'id d'une gare
    * */
    @Headers({"Authorization:"+InfoApi.SNCF_API_KEY,"Connection:keep-alive"})
    @GET(PATH+"stop_areas/{stop_area_ID}/physical_modes/"+physical_mode+"/departures?data_freshness=realtime")
    Call<ResponseDepartures> getDeparturesFromStopAreaId(@Path("stop_area_ID")String stop_area_id);

    @GET(PATH+"journeys")
    Call<Journeys> getJourneys(@Query("from") String from, @Query("to") String to);
   // Call<Places> getPlaces();
}
