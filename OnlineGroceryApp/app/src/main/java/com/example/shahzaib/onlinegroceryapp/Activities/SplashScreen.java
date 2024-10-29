package com.example.shahzaib.onlinegroceryapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shahzaib.onlinegroceryapp.R;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over


                Intent i = new Intent(SplashScreen.this, Login.class);
                startActivity(i);
                finish();

            }


        }, 3000);
    }
}
