package com.example.hydropro;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //create from saved instance
        setContentView(R.layout.activity_info); //view layout for info activity

        // Set up the back button to navigate to the HydrationHome
        ImageButton backButton = findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() { //on click override view
            @Override
            public void onClick(View v) {
                // navigate to the HydrationHome activity
                Intent intent = new Intent(InfoActivity.this, HydrationHome.class);
                startActivity(intent);
                finish(); //not want to return to it when HydrationHome is closed, fnish intent
            }
        });

        // Setting up the TextView with the info text
        TextView textViewInfo = findViewById(R.id.textViewInfo); //info text view here, set as string with bold breakdowns
        String infoText = "<b>Benefits of Staying Hydrated:</b><br>" +
                "- <b>Regulates body temperature</b> through sweat and breath.<br>" +
                "- <b>Supports heart health,</b> improving blood circulation to muscles.<br>" +
                "- <b>Enhances skin health,</b> maintaining moisture and elasticity.<br>" +
                "- <b>Aids in digestion</b> and helps prevent constipation.<br>" +
                "- <b>Facilitates detoxification</b> by helping kidneys to remove blood wastes.<br>" +
                "- <b>Maintains joint and muscle health,</b> ensuring elasticity and lubrication.<br><br>" +
                "<b>Recognizing Dehydration:</b><br>" +
                "- <b>Thirst</b> is a late sign of dehydration.<br>" +
                "- <b>Dark yellow urine</b> indicates a need for more water.<br>" +
                "- <b>Fatigue, dry mouth, or skin,</b> headaches, and dizziness are further signs.<br><br>" +
                "<b>Daily Water Intake:</b><br>" +
                "- <b>Women:</b> Roughly 2.7 liters or 9 cups, including from food.<br>" +
                "- <b>Men:</b> Around 3.7 liters or 13 cups, inclusive of all sources.<br>" +
                "- <b>During exercise</b> or in hot climates, increase intake to compensate for loss through sweat.<br><br>" +
                "<b>Hydration Tips:</b><br>" +
                "- Keep a <b>reusable water bottle</b> handy.<br>" +
                "- <b>Monitor fluid loss</b> when active.<br>" +
                "- Eat <b>fruits and veggies,</b> rich in water.<br>" +
                "- <b>Limit alcohol and caffeine,</b> which dehydrate.<br>" +
                "- <b>Set drinking reminders</b> to hydrate regularly throughout the day.";

        textViewInfo.setText(Html.fromHtml(infoText, Html.FROM_HTML_MODE_COMPACT)); //reference our textview object, then set the text displayted convert html format string and convert to spanned for textview display bold
    }
}
