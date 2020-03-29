package com.upec.androidtemplate20192020;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.upec.androidtemplate20192020.fragments.FavoriteJourneysFragment;
import com.upec.androidtemplate20192020.fragments.JourneyFragment;
import com.upec.androidtemplate20192020.fragments.StationsFragment;
import com.upec.androidtemplate20192020.fragments.TrainsFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.view.MenuItem;

import static android.view.View.GONE;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
=======
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
>>>>>>> 40e29f9a7cd6c2946ff3ae8d64131658d5c7098c

    static BottomNavigationView navigationView;
    Fragment.SavedState state;
    @Override
    protected void onCreate(Bundle si) {
        super.onCreate(si);
        setContentView(R.layout.activity_main);
        updateFragment(new TrainsFragment());
        navigationView=findViewById(R.id.bottom_nav_bar);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

     boolean updateFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        if(fragment!=null){
            transaction.replace(R.id.fragment_container, fragment).commit();
        return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment=null;
        switch (item.getItemId()){
            case R.id.trains:
                fragment=new TrainsFragment();
                break;
            case R.id.trajet:
                fragment=new JourneyFragment();
                break;
            case R.id.trouverGare:
                fragment=new StationsFragment();
<<<<<<< HEAD
                break;
            case R.id.trajetsFavoris:
                fragment=new FavoriteJourneysFragment();
=======
>>>>>>> 40e29f9a7cd6c2946ff3ae8d64131658d5c7098c
                break;
        }
        return updateFragment(fragment);
    }
    public static void hideNavBar(){
        navigationView.setVisibility(GONE);
    }

    public static boolean navBarVisible(boolean value){
        if(value){navigationView.setVisibility(View.VISIBLE);}
        return false;
    }
}
