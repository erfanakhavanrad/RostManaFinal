package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rostmanafinal.Fragments.FirstFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


UserManagerSharedPrefs userManagerSharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userManagerSharedPrefs = new UserManagerSharedPrefs(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBottom);
//        bottomNavigationView.find;
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);



//        Menu menu = bottomNavigationView.getMenu();
//        menu.findItem(R.id.navigationBottom).setIcon();
//
//        switch (item.getItemId()) {
//            case R.id.action_favorites:
//                item.setIcon(favDrawableSelected);
//            case R.id.action_schedules:
//            case R.id.action_music:


//        if (userManagerSharedPrefs == null) {
//
//           MenuItem menuItem = menu.findItem(R.id.fragmentViewPagerTabbed23);
//           menuItem.setActionView(R.id.firstFragment2);
//        }




//        BottomNavigationView.OnNavigationItemSelectedListener { item -> {
//            switch(item.getId()){
//
//                case R.id.item1 :
//                    Navigation.findNavController(item).navigate(R.id.action_login_to_example);
//                    break;
//
//                case R.id.item2 :
//                    Navigation.findNavController(item).navigate(R.id.action_login_to_main);
//                    break;
//
//                default:
// error
            }
        }





//    @Override
//    public boolean onSupportNavigateUp() {
//        return super.onSupportNavigateUp();
//    }