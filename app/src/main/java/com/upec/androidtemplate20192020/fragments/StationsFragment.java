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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.upec.androidtemplate20192020.MainActivity;
import com.upec.androidtemplate20192020.R;

public class StationsFragment extends Fragment implements LocationListener {


    TextView textView;
    private Context mContext;
    private static final int REQUEST_LOCATION = 1;
    private LocationManager mLocationManager;
    private static final String TAG = "LocationFragment";
    private double lon;
    private double lat;

    public StationsFragment() {

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
        ActivityCompat.requestPermissions(getActivity() , new String[] {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);

        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity() , new String[] {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }else {
            mLocationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
            Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            //lon = location.getLongitude();
            //double latitude = location.getLatitude();
            //textView.setText("Longitude :"+Double.toString(longitude)+"Latitude :"+Double.toString(latitude));
        }

        return rootStationsView;
    }


    @Override
    public void onResume() {
        super.onResume();

        //mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        //mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
        mLocationManager.removeUpdates(this);
    }


    @Override
    public void onLocationChanged(Location location) {
        Log.i(TAG, String.valueOf(location.getLatitude()));
        Log.i(TAG, String.valueOf(location.getLongitude()));

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.i(TAG, "Provider " + provider + " has now status: " + status);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.i(TAG, "Provider " + provider + " is enabled");
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.i(TAG, "Provider " + provider + " is disabled");
    }
}
