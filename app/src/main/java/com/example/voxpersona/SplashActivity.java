package com.example.voxpersona;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

private static final int Splash_time_out=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ImageView logo = findViewById(R.id.logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // After 5 seconds, navigate to SignupActivity
                Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
                startActivity(intent);
                // Close this activity so the user can't go back to it
                finish();
            }
        }, Splash_time_out);
    }
}