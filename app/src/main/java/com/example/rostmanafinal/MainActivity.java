package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;
UserManagerSharedPrefs userManagerSharedPrefs;
    private CardView cardView;
    private int duration = Toast.LENGTH_SHORT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userManagerSharedPrefs = new UserManagerSharedPrefs(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationBottom);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

            }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "برای خروج دوباره بازگشت را بزنید", Toast.LENGTH_SHORT).show();
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_exit, cardView);
        TextView text = layout.findViewById(R.id.text);
        text.setText(R.string.exitApp);
        Toast toast = new Toast(MainActivity.this);
        toast.setGravity(Gravity.BOTTOM, 0, 165);
        toast.setDuration(duration);
        toast.setView(layout);
        toast.show();


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


        }



//    @Override
//    public boolean onSupportNavigateUp() {
//        return super.onSupportNavigateUp();
//    }