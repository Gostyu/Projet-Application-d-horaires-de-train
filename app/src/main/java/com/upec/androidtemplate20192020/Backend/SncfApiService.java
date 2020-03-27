package com.upec.androidtemplate20192020.Backend;


import com.upec.androidtemplate20192020.models.ResponseDepartures;
import com.upec.androidtemplate20192020.models.ResponseJourneys;
import com.upec.androidtemplate20192020.models.ResponseCoverageZoneList;
import com.upec.androidtemplate20192020.models.ResponseDepartures;
import com.upec.androidtemplate20192020.models.ResponseJourneys;
import com.upec.androidtemplate20192020.models.ResponseObjectListNearbyOfCoordinate;
import com.upec.androidtemplate20192020.models.ResponseObjectListNearbyOfResource;
import com.upec.androidtemplate20192020.models.ResponseObjectListNearbyWithoutRegionIdentifier;
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

    String PATH2="coverage/sncf/commercial_modes";

    /**/
    // Zone list covered by the navitia
    @Headers({"Authorization:"+InfoApi.SNCF_API_KEY2,"Connection:keep-alive"})
    @GET(PATH)
    Call<ResponseCoverageZoneList> getCoverageZoneList();
    
    // Object list nearby of the coordinate
    //@Headers({"Authorization:"+InfoApi.SNCF_API_KEY2,"Connection:keep-alive"})
    //@GET(PATH+"/{region_id}/"+"/coords/"+"/{lon;lat}/"+"places_nearby")
    //Call<ResponseObjectListNearbyOfCoordinate> getObjectListNearbyOfCoordinate();

    // Object list nearby of the resource
    //@Headers({"Authorization:"+InfoApi.SNCF_API_KEY2,"Connection:keep-alive"})
    //@GET(PATH+"/{region_id}/"+"/{resource_path}/"+"places_nearby")
    //Call<ResponseObjectListNearbyOfResource> getObjetListNearbyOfResource();

    //https://api.sncf.com/v1/coord/2.475551%3B48.782097/places_nearby?


    // Object list nearby of the resource without the region identifier
    @Headers({"Authorization:"+InfoApi.SNCF_API_KEY2,"Connection:keep-alive"})
    @GET("/coord/"+"2.475551;48.782097"+"/places_nearby")
    Call<ResponseObjectListNearbyWithoutRegionIdentifier> getObjectListNearbyWithoutRegionIdentifier();

    /**/

    @Headers({"Authorization:"+InfoApi.SNCF_API_KEY,"Connection:keep-alive"})
    @GET(PATH+"networks/"+rerNetwork+"/physical_modes/"+physical_mode+"/stop_areas?count=250&disable_disruption=true")
    Call<ResponseStopAreas> getStopAreas();


    /*Donne la liste des départs de trains à partir de l'id d'une gare
    * */
    @Headers({"Authorization:"+InfoApi.SNCF_API_KEY,"Connection:keep-alive"})
    @GET(PATH+"stop_areas/{stop_area_ID}/physical_modes/"+physical_mode+"/departures?data_freshness=realtime")
    Call<ResponseDepartures> getDeparturesFromStopAreaId(@Path("stop_area_ID")String stop_area_id);

    @Headers({"Authorization:"+InfoApi.SNCF_API_KEY,"Connection:keep-alive"})
    @GET(PATH+"journeys?data_freshness=realtime")
    Call<ResponseJourneys> getJourneys(@Query("from") String from, @Query("to") String to);
   // Call<Places> getPlaces();
}
