package com.example.hydropro;

//imports
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HydrationHome extends AppCompatActivity {
//set declarations for ui elements
    private ProgressBar hydrationProgress;
    private EditText editTextOuncesDrank;
    private TextView textViewProgress;
    private int totalHydrationGoalInOunces = 125; // total goal in ounces
    private int currentHydrationInOunces = 0;
    private int lastInputInOunces = 0; // To keep track of the last input
//on create when activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the layout for activity home
        setContentView(R.layout.activity_home);

        //initialize ui elements
        hydrationProgress = findViewById(R.id.progressHydration);
        editTextOuncesDrank = findViewById(R.id.editTextOuncesDrank);
        textViewProgress = findViewById(R.id.textViewProgress);

        //set up info button
        Button buttonInfo = findViewById(R.id.buttonInfo);
        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navifate to infoactivity intent when selected
                Intent intent = new Intent(HydrationHome.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        //declaration button steps (confirm, undo, logout)
        Button buttonConfirmDrink = findViewById(R.id.buttonConfirmDrink);
        Button buttonUndo = findViewById(R.id.buttonUndo); // Make sure you have this button in your XML
        Button buttonLogout = findViewById(R.id.buttonLogout); // Logout button

        //confirm button listenrer
        buttonConfirmDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handle drink confirmation actions
                String ouncesStr = editTextOuncesDrank.getText().toString();
                if (!ouncesStr.isEmpty()) {
                    int ouncesDrank = Integer.parseInt(ouncesStr);
                    lastInputInOunces = ouncesDrank;
                    updateHydration(lastInputInOunces);
                } else {
                    //use toast to prompt user if input is empty
                    Toast.makeText(HydrationHome.this, "Please enter the amount you drank", Toast.LENGTH_SHORT).show();
                }
            }
        });
//undo button click listener
        buttonUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undoLastInput();
            } //simple undo last input
        });
//logout button click listener to navigate back to splash screen
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSplashScreen();
            }
        });

        // Initial ui updated
        updateHydrationDisplay();
    }

    //simple undo last input only for positive values by resetting the last input
    private void undoLastInput() {
        currentHydrationInOunces -= lastInputInOunces;
        if (currentHydrationInOunces < 0) {
            currentHydrationInOunces = 0; //no negative values
        }
        updateHydrationDisplay();
        lastInputInOunces = 0; // Reset the last input
    }

    //update hydration by calculating progress percentage, and updating textview with current
    private void updateHydrationDisplay() {
        int progressPercentage = (currentHydrationInOunces * 100) / totalHydrationGoalInOunces;
        hydrationProgress.setProgress(progressPercentage);
        textViewProgress.setText(currentHydrationInOunces + " / " + totalHydrationGoalInOunces + " oz");
        // Update the ounces left display as needed
    }

    //update based on oz drank
    private void updateHydration(int ouncesDrank) {
        currentHydrationInOunces += ouncesDrank;
        //keep to meet goal
        if (currentHydrationInOunces > totalHydrationGoalInOunces) {
            currentHydrationInOunces = totalHydrationGoalInOunces;
        }
        updateHydrationDisplay();
    }


    //back to splashscreen when logout intent
    private void navigateToSplashScreen() {
        Intent intent = new Intent(HydrationHome.this, SplashScreenActivity.class);
        startActivity(intent);
        finish(); // Close this activity
    }
}
