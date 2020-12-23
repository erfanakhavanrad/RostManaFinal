package com.example.rostmanafinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.rostmanafinal.Fragments.FirstFragment;
import com.example.rostmanafinal.Fragments.FragmentHome;
import com.example.rostmanafinal.Fragments.FragmentViewPagerTabbed;
import com.example.rostmanafinal.Fragments.Fragment_Plant_Details;
import com.example.rostmanafinal.Fragments.SecondFragment;
import com.example.rostmanafinal.Fragments.ThirdFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBottom);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        return super.onSupportNavigateUp();
//    }
}