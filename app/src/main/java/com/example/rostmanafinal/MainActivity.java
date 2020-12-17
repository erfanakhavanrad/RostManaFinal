package com.example.rostmanafinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
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
        bottomNavigationView.setSelectedItemId(R.id.thirdFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.firstFragment:
                        Toast.makeText(MainActivity.this, "Left", Toast.LENGTH_SHORT).show();
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        SecondFragment fn2 = new SecondFragment();
                        fragmentTransaction2.replace(R.id.nav_host_fragment, fn2);
                        fragmentTransaction2.commit();
//                        return true;
                        break;
                    case R.id.secondFragment:
                        Toast.makeText(MainActivity.this, "Middle", Toast.LENGTH_SHORT).show();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        FragmentViewPagerTabbed fn = new FragmentViewPagerTabbed();
                        fragmentTransaction.replace(R.id.nav_host_fragment, fn);
                        fragmentTransaction.commit();
                        break;
                    case R.id.thirdFragment:
                        Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                        FragmentHome fn3 = new FragmentHome();
                        fragmentTransaction3.replace(R.id.nav_host_fragment, fn3);
                        fragmentTransaction3.commit();
                        break;
                }
                return true;
            }
        });


    }
}