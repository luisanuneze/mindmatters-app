package com.example.mindmattersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mindmattersapp.activities.DirectorioActivity;
import com.example.mindmattersapp.activities.ForumActivity;
import com.example.mindmattersapp.activities.WellBeingActivity;
import com.example.mindmattersapp.models.MainDiario;

public class menuprincipal extends AppCompatActivity {
    private CardView cvForo, cvDiario, cvBienestar, cvDirectorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        setUp();
    }

    private void setUp() {

        ////// REDIRECCION AL FORO
        cvForo = findViewById(R.id.cardView4);
        navigateForum(cvForo);

        ///// REDIRECCION AL DIARIO
        cvDiario = findViewById(R.id.cardView3);
        navigateDiary(cvDiario);

        ///// REDIRECCION AL DIRECTORIO
        cvDirectorio = findViewById(R.id.cardView);
        navigateDirectory(cvDirectorio);

        ///// REDIRECCION AL BIENESTAR
        cvBienestar = findViewById(R.id.cardView2);
        navigateBienestar(cvBienestar);

    }

    //=======================================
    //NAVEGAR AL FORO
    //=======================================
    private void navigateForum(CardView card) {
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickForum();
            }
        });
    }

    public void clickForum() {
        Intent intent = new Intent(this, ForumActivity.class);
        startActivity(intent);
    }

    //=======================================
    //NAVEGAR AL DIARIO
    //=======================================
    private void navigateDiary(CardView card) {
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDiary();
            }
        });
    }

    public void clickDiary() {
        Intent intent = new Intent(this, MainDiario.class);
        startActivity(intent);
    }

    //=======================================
    //NAVEGAR AL DIRECTORIO
    //=======================================
    private void navigateDirectory(CardView card) {
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDirectory();
            }
        });
    }

    public void clickDirectory() {
        Intent intent = new Intent(this, DirectorioActivity.class);
        startActivity(intent);
    }

    //=======================================
    //NAVEGAR AL BIENESTAR
    //=======================================
    private void navigateBienestar(CardView card) {
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBienestar();
            }
        });
    }

    public void clickBienestar() {
        Intent intent = new Intent(this, WellBeingActivity.class);
        startActivity(intent);
    }
}