package com.upec.androidtemplate20192020;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.upec.androidtemplate20192020.Backend.InfoApi;
import com.upec.androidtemplate20192020.Backend.SncfApiService;
import com.upec.androidtemplate20192020.Backend.SncfApiWorker;
import com.upec.androidtemplate20192020.fragments.trainsFragment;
import com.upec.androidtemplate20192020.models.StopArea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.activity_main);
        SncfApiWorker sncfApiWorker = new SncfApiWorker();
        sncfApiWorker.getAllStationsResults(sncfApiWorker.getAllStations());
    }

}
