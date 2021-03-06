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
  //  final SncfApiWorker sncfApiWorker =  new SncfApiWorker(this);
    Location location;

    public StationsFragment() {

    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedObjectListNearbyCoordinate =new SavedObjectListNearbyCoordinate();
    //    sncfApiWorker.requestObjectListNearbyWithoutRegionIdentifierResult();
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext=getActivity();
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
        ActivityCompat.requestPermissions(getActivity() , new String[] {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity() , new String[] {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }else {
            if(mContext==null){
                Log.d("MCONTEXT LOCATION","IS NULL");
            }else{
                Log.d("MCONTEXT LOCATION","NOT NULL");
                if(mLocationManager!=null){
                    location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                    if(location!=null){
                        double lon = location.getLongitude();
                        double latitude = location.getLatitude();
                        textView.setText("Longitude :"+Double.toString(lon)+"Latitude :"+Double.toString(latitude));
                    }else{
                        Log.d("LOCATION","Cest nul");
                    }
                    mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
                    mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
                }
            }
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        if(location!=null) {
            double lon = location.getLongitude();
            double latitude = location.getLatitude();
            textView.setText("Longitude :" + Double.toString(lon) + "Latitude :" + Double.toString(latitude));
        }
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
