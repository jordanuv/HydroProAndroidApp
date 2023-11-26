package com.example.hydropro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity implements NavigationListener {

    public static Intent newIntent(Context context) {
        return new Intent(context, SplashScreenActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Set up UI elements for the login screen
        setUpLoginScreenUI();
    }

    private void setUpLoginScreenUI() {
                // Set up the user photo circle (using a placeholder image)
        ImageView userPhotoImageView = findViewById(R.id.imageUserPhoto);
        // Set the placeholder image (you can replace it with a user's actual photo later)
        userPhotoImageView.setImageResource(R.mipmap.ic_person_placeholder_round);

        // Set up Username and its input box
        TextView usernameLabel = findViewById(R.id.textUsernameLabel);
        EditText usernameEditText = findViewById(R.id.editTextUsername);

        // Set up Password and its input box
        TextView passwordLabel = findViewById(R.id.textPasswordLabel);
        EditText passwordEditText = findViewById(R.id.editTextPassword);

        // Set up Forgot Password button
        Button forgotPasswordButton = findViewById(R.id.btnForgotPassword);
        forgotPasswordButton.setOnClickListener(v -> navigateToForgotPasswordScreen());

        // Set up Create Account and Login buttons
        Button createAccountButton = findViewById(R.id.btnCreateAccount);
        Button loginButton = findViewById(R.id.btnLogin);

        createAccountButton.setOnClickListener(v -> {
            navigateToCreateAccountScreen(); // Need create account screen to be implemented
        });

        loginButton.setOnClickListener(v -> {
            navigateToHomeScreen(); // Need home screen to be implemented
        });
    }

    private void navigateToForgotPasswordScreen() {
        // Implement navigation to the "Forgot Password" screen
        startNewActivity(ForgotPasswordActivity.class);
    }

    private void navigateToCreateAccountScreen() {

        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }


    private void navigateToHomeScreen() {
        Intent intent = new Intent(SplashScreenActivity.this, HydrationHome.class);
        startActivity(intent);
    }


    @Override
    // Method for starting any new activity
    public void startNewActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
