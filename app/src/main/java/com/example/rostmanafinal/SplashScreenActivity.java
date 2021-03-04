package com.example.rostmanafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.BoringLayout;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 1000;

    //Variables
    Animation topAnim, bottomAnim;
    ImageView imageSplash1;
    TextView textSlogan;
    UserManagerSharedPrefs userManagerSharedPrefs;
    String token, verifiedAt;
    Boolean agreed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        configSharedP();

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        //hooks
        imageSplash1 = findViewById(R.id.imageSplash1);
        textSlogan = findViewById(R.id.textSlogan);
        imageSplash1.setAnimation(topAnim);
        textSlogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentSplash = new Intent(SplashScreenActivity.this, LoginRegisterActivity.class);
//                startActivity(intent1);
//                finish();
                if (!agreed) {
                    Intent intent = new Intent(SplashScreenActivity.this, TermsAndConditionsActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    if (token != null && verifiedAt != null) {
                        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Pair[] pairs = new Pair[2];
                        pairs[0] = new Pair<View, String>(imageSplash1, "logo_image");
                        pairs[1] = new Pair<View, String>(textSlogan, "logo_text");
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this, pairs);
                        startActivity(intentSplash, options.toBundle());
                        finish();
                    }
                }
//Intent intent = new Intent(OldActivity.this, NewActivity.class);
// set the new task and clear flags
//                intent .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
            }
        }, SPLASH_SCREEN);
    }

    private void configSharedP() {

        this.userManagerSharedPrefs = new UserManagerSharedPrefs(this);
        token = userManagerSharedPrefs.getFullName();
        verifiedAt = userManagerSharedPrefs.getVerifiedAt();
        agreed = userManagerSharedPrefs.getAgreeToTerms();
    }
}