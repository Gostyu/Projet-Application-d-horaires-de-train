package com.upec.androidtemplate20192020.Backend;


import com.upec.androidtemplate20192020.models.Stations;
import com.upec.androidtemplate20192020.models.StopArea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SncfApiService {
    @Headers("Authorization:"+InfoApi.SNCF_API_KEY)
    @GET("coverage/sncf/networks/network:sncf/physical_modes/physical_mode:RapidTransit/commercial_modes/commercial_mode:rer/stop_areas?count=255")
    Call<Stations> getStopAreas();
    /*Call<List<StopArea>> getStopAreas(@Path("network") String networkParam,
                                      @Path("physical_mode") String physical_modeParam,
                                      @Path("commercial_mode") String commercial_modeParam);
    */


}
