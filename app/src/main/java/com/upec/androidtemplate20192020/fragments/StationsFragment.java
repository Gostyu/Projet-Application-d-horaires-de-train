package com.upec.androidtemplate20192020.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.upec.androidtemplate20192020.Backend.InfoApi;
import com.upec.androidtemplate20192020.Backend.SncfApiService;
import com.upec.androidtemplate20192020.Backend.SncfApiWorker;
import com.upec.androidtemplate20192020.MainActivity;
import com.upec.androidtemplate20192020.R;
import com.upec.androidtemplate20192020.models.Coord;
import com.upec.androidtemplate20192020.models.ResponseObjectListNearbyWithoutRegionIdentifier;
import com.upec.androidtemplate20192020.models.SavedObjectListNearbyCoordinate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class StationsFragment extends Fragment implements LocationListener  {


    TextView textView;
    private Context mContext;
    private static final int REQUEST_LOCATION = 1;
    private LocationManager mLocationManager;
    private static final String TAG = "LocationFragment";
    private Coord coord;
    SavedObjectListNearbyCoordinate savedObjectListNearbyCoordinate;
    final SncfApiWorker sncfApiWorker =  new SncfApiWorker(this);


    public StationsFragment() {

    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedObjectListNearbyCoordinate =new SavedObjectListNearbyCoordinate();
        sncfApiWorker.requestObjectListNearbyWithoutRegionIdentifierResult();

    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext=context;
        mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootStationsView = inflater.inflate(R.layout.fragment_trouver_gare, container, false);
        textView=rootStationsView.findViewById(R.id.textViewStations);
        return rootStationsView;
    }


    @Override
    public void onResume() {
        super.onResume();

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity() , new String[] {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }else{

            if(mContext==null){
                Log.d("mContext","null");
            }else{
                Log.d("mContext","is not null");
            }
            mLocationManager=(LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
            Location location=mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            if(location!=null){

                double longitude=location.getLongitude();
                double latitude=location.getLatitude();

             //   textView.setText(String.valueOf(longitude));

            }else{
                Log.d("Location","Null");
            }
        }
        mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,this);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
