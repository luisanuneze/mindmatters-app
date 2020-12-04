package com.example.mindmattersapp.models;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mindmattersapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;


public class PaginaDiario extends AppCompatActivity {
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diario_pagina);
        date=(TextView) findViewById(R.id.tv_date);

        /*Time today=new Time(Time.getCurrentTimezone());

        today.setToNow();

        int dia=today.monthDay;
        int mes=today.month;
        int ano=today.year;

        mes=mes+1;
        date.setText("Fecha: " + dia + "/"+mes+"/"+ano);*/

        date.setText(fechaActual());

        /*Button btnhecho = (Button) findViewById(R.id.buttonHecho);
        btnhecho.setOnClickListener((view)->{
            String titulo =((EditText) findViewById(R.id.tv_title)).getText().toString();
            String fecha =((TextView) findViewById(R.id.tv_date)).getText().toString();
            String content =((EditText) findViewById(R.id.tv_contenido)).getText().toString();
        }*/


    }

    public static String fechaActual(){

        Date fechaA = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat();

        return formatoFecha.format(fechaA);

    }

}