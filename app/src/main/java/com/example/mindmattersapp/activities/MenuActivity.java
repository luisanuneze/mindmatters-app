package com.example.mindmattersapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mindmattersapp.R;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final Button buttonLau = findViewById(R.id.bnLaura);
        buttonLau.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(getApplicationContext(), DirectorioActivity.class);
                startActivity(intent);
            }
        });

        final Button buttonJess = findViewById(R.id.bnJessica);
        buttonJess.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(getApplicationContext(), WellBeingActivity.class);
                startActivity(intent);
            }
        });
    }
}