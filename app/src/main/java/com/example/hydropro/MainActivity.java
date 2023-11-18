package com.example.hydropro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements NavigationListener {

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // No UI elements in MainActivity
        // You may want to perform initialization or checks here

        // Start the SplashScreenActivity
        startActivity(SplashScreenActivity.newIntent(this));
        finish(); // Close the MainActivity
    }

    @Override
    // Method for starting any new activity
    public void startNewActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
