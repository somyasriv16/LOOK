package com.example.sigmathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    Animation topAnim,bottomAnim;
    TextView textView;
    ImageView logo,img1,img2;

    private static int SPLASH_SCREEN= 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        textView = findViewById(R.id.text);
        img1 = findViewById(R.id.left);
        img2 = findViewById(R.id.right);

        logo = findViewById(R.id.logo);

        logo.setAnimation(topAnim);
        img1.setAnimation(bottomAnim);
        img2.setAnimation(bottomAnim);
        textView.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
                startActivity(intent);
            }
        },SPLASH_SCREEN);

    }
}
