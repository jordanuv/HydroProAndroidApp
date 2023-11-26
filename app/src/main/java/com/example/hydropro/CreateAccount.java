package com.example.hydropro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button backButton = findViewById(R.id.btnBack);
        backButton.setOnClickListener(v -> finish()); // Finish activity to return to the previous screen

        Button submitButton = findViewById(R.id.btnSubmit);
        submitButton.setOnClickListener(view -> {
            // Get user input from EditText fields
            EditText emailEditText = findViewById(R.id.editTextEmail);
            EditText usernameEditText = findViewById(R.id.editTextUsername);
            EditText passwordEditText = findViewById(R.id.editTextPassword);
            EditText confirmPasswordEditText = findViewById(R.id.editTextConfirmPassword);

            // Convert input to String
            String email = emailEditText.getText().toString();
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPasswordEditText.getText().toString();

            // Check if any field is empty
            if (!email.isEmpty() && !username.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()) {
                if (password.equals(confirmPassword)) {
                    // Implement account creation logic here
                    createAccount(email, username, password);
                } else {
                    // Notify the user that the passwords do not match with toast if not correct
                    Toast.makeText(CreateAccount.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Notify the user that all fields are required if not correct, ensure good submission with toast
                Toast.makeText(CreateAccount.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createAccount(String email, String username, String password) {
        // account creation if needed further
    }
}
