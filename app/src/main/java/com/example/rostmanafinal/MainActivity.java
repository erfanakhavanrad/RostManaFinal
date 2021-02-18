package com.example.rostmanafinal;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rostmanafinal.Fragments.FirstFragment;
import com.example.rostmanafinal.Fragments.FragmentAddToHome;
import com.example.rostmanafinal.Fragments.FragmentHome;
import com.example.rostmanafinal.Fragments.FragmentMonitoring;
import com.example.rostmanafinal.Options.SharedPrefHandler;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity {


    Context context = this;
    boolean doubleBackToExitPressedOnce = false;
    UserManagerSharedPrefs userManagerSharedPrefs;
    private CardView cardView;
    private int duration = Toast.LENGTH_SHORT;
    final Fragment fragment1 = new FragmentHome();
    final Fragment fragment2 = new FragmentAddToHome();
    final Fragment fragment3 = new FragmentMonitoring();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;
    BottomNavigationView navigation;

    //    @Override
//            BottomNavigationView.OnNavigationItemReselectedListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBottom);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navigation = (BottomNavigationView) findViewById(R.id.navigationBottom);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.nav_host_fragment, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.nav_host_fragment, fragment1, "1").commit();
        navigation.setSelectedItemId(R.id.fragmentHome);
        navigation.setClickable(true);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.fragmentHome:
//                    fm.beginTransaction().hide(active).show(fragment1).addToBackStack("home").commit();
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;

                    return true;

                case R.id.fragmentViewPagerTabbed23:
                    fm.beginTransaction().hide(active).show(fragment2).commit();
                    active = fragment2;
                    return true;

                case R.id.fragmentMonitoring:
//                    fm.beginTransaction().add(R.id.nav_host_fragment, fragment3).show(fragment3).addToBackStack("monitoring").commit();
//                    active = fragment3;
                    fm.beginTransaction().hide(active).show(fragment3).commit();
                    active = fragment3;
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
//        fm.popBackStack();
        switch (navigation.getSelectedItemId()) {

            // If it is on the home screen, close the application
            case R.id.fragmentHome:

                // exit app
                System.exit(0);
                break;

            // If it is on a page other than the home page, go to the home page

/*           case R.id.fragmentViewPagerTabbed23:
           case R.id.fragmentMonitoring:
                // Select homeFragment
                navigation.setSelectedItemId(R.id.fragmentHome);
                break;*/
            default:
                if (SharedPrefHandler.getBooleanPreference(context,SharedPrefHandler.HOW_TO_SHOW_HOME_FRAGMENT,true)){
                    // Select homeFragment
                    navigation.setSelectedItemId(R.id.fragmentHome);
                }else {
                    fm.popBackStack();
                }
        }
    }
}


//        userManagerSharedPrefs = new UserManagerSharedPrefs(this);

//        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBottom);
//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
//        NavController navController = navHostFragment.getNavController();
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);


//        Fragment currentFragment = getParent().getFragmentManager().findFragmentById(R.id.fragment_container);
//        Fragment currentFragment = getActivity().getFragmentManager().findFragmentById(R.id.fragment_container);


//        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
//        if (backStackEntryCount == 0) {
//            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.fragmentHome:
//                        item.setEnabled(false);
//                        break;
//                    case R.id.fragmentViewPagerTabbed23:
//                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.add(R.id.nav_host_fragment, new FragmentAddToHome());
//                        fragmentTransaction.addToBackStack("fragmentA");
//                        fragmentTransaction.commit();
//                        break;
//                    case R.id.fragmentMonitoring:
//                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction2.add(R.id.nav_host_fragment, new FragmentMonitoring());
//                        fragmentTransaction2.addToBackStack("fragmentM");
//                        fragmentTransaction2.commit();
//                break;
//                }
//                    return false;
//                }
//            });   // write your code to switch between fragments.
//        } else {
//            super.onBackPressed();
//        }

//        bottomNavigationView.setSelectedItemId(R.id.fragmentHome);
//        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.fragmentHome:
//                        Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
//                        item.setEnabled(false);
//                        break;
//                }
//                return false;
//            Toast.makeText(this, "empty back stack", Toast.LENGTH_SHORT).show();
//        } else if (getSupportFragmentManager().getBackStackEntryCount() > 1) {

//            Toast.makeText(this, "FULL back stack", Toast.LENGTH_SHORT).show();

//        }
//        });
