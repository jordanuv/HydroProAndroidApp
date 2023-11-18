// ResetPasswordActivity.java
package com.example.hydropro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity implements NavigationListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        Button backButton = findViewById(R.id.btnBack);
        backButton.setOnClickListener(v -> navigateToForgotPasswordScreen());

        Button submitButton = findViewById(R.id.btnSubmit);
        submitButton.setOnClickListener(v -> {
            EditText editNewPassword = findViewById(R.id.editTextNewPassword);
            String newPassword = editNewPassword.getText().toString();
            EditText editRepeatNewPassword = findViewById(R.id.editTextRepeatNewPassword);
            String repeatNewPassword = editRepeatNewPassword.getText().toString();

            if (newPassword.isEmpty()) {
                Toast.makeText(ResetPasswordActivity.this, "New password field cannot be empty", Toast.LENGTH_SHORT).show();
            } else if (repeatNewPassword.isEmpty()) {
                Toast.makeText(ResetPasswordActivity.this, "Repeat new password field cannot be empty", Toast.LENGTH_SHORT).show();
            } else if (!newPassword.equals(repeatNewPassword)) {
                Toast.makeText(ResetPasswordActivity.this, "New password field does not match repeat new password field", Toast.LENGTH_SHORT).show();
            } else {
                navigateToHomeScreen();
            }
        });
    }

    private void navigateToForgotPasswordScreen() {
        // Implement navigation to the "Forgot Password" screen
        startNewActivity(ForgotPasswordActivity.class);
    }

    //TODO: Need to link this to the Home screen after it's implemented
    private void navigateToHomeScreen() {
        // Implement navigation to the "Splash" screen
        //startNewActivity(HomeScreenActivity.class);
    }

    @Override
    // Method for starting any new activity
    public void startNewActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
