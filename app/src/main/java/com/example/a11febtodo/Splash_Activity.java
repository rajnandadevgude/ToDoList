package com.example.a11febtodo;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import androidx.appcompat.app.AppCompatActivity;

public class Splash_Activity extends AppCompatActivity {

    // Splash screen timer
    private static final int SPLASH_TIME_OUT = 5000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app's main activity
                Intent intent = new Intent(Splash_Activity.this, MainActivity.class);
                startActivity(intent);

                // Close this activity
                finish();
            }
        }, 5000);
    }
}
