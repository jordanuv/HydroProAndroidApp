package com.example.hydropro;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity implements NavigationListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Button backButton = findViewById(R.id.btnBack);
        backButton.setOnClickListener(v -> navigateToSplashScreen());

        Button sendButton = findViewById(R.id.btnSend);
        sendButton.setOnClickListener(view -> {
            // Get email address from input box
            EditText emailEditText = findViewById(R.id.editTextEmail);
            String emailAddress = emailEditText.getText().toString();
            findViewById(R.id.btnBack);
            // Check if the email address is not empty
            if (!emailAddress.isEmpty()) {
                // Show an alert dialog with the email address
                showEmailSentDialog(emailAddress);
            } else {
                // Notify the user that the email address is empty (you can handle this according to your requirements)
                Toast.makeText(ForgotPasswordActivity.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
            }
        });

        Button submitButton = findViewById(R.id.btnSubmit);
        submitButton.setOnClickListener(v -> {
            //Get Code
            EditText codeEditText = findViewById(R.id.editTextCode);
            String code = codeEditText.getText().toString();

            //Check to see if code field is empty
            if (!code.isEmpty()) {
                navigateToResetPasswordScreen();
            } else {
                Toast.makeText(ForgotPasswordActivity.this, "Please enter code sent to your email address", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToSplashScreen() {
        // Implement navigation to the "Splash" screen
        startNewActivity(SplashScreenActivity.class);
    }

    private void navigateToResetPasswordScreen() {
        // Implement navigation to the "Reset Password" screen
        startNewActivity(ResetPasswordActivity.class);
    }

    private void showEmailSentDialog(String emailAddress) {
        // Build the dialog message
        String message = "Email Sent to " + emailAddress;

        // Create an alert dialog
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Email Sent")
                .setMessage(message)
                .setPositiveButton("OK", (dialogInterface, i) -> {
                    // Dismiss the dialog
                    dialogInterface.dismiss();
                })
                .create();

        // Show the dialog
        alertDialog.show();
    }

    @Override
    // Method for starting any new activity
    public void startNewActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
