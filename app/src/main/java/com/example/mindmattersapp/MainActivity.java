package com.example.mindmattersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mindmattersapp.data.UserConfig;
import com.example.mindmattersapp.models.MainDiario;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private TextView tvUser, tvPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActions();
    }

    private void setupActions(){
        btnStart = findViewById(R.id.btn_login);
        tvUser = findViewById(R.id.tv_user);
        tvPwd = findViewById(R.id.tv_pass);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restrict(v);
            }
        });
    }

    private void navigateToDiario(){
        saveFirstStart();
        Intent intent = new Intent(this, MainDiario.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void saveFirstStart(){
        UserConfig userConfig = new UserConfig(getApplicationContext());
        userConfig.setIsFirstTime(false);
    }

    private void restrict(View v){
        if(tvUser.getText().toString().isEmpty()){
            if(tvPwd.getText().toString().isEmpty()){
                Snackbar.make(v, "Los campos son requeridos", Snackbar.LENGTH_SHORT).show();
            }
        }else{
            navigateToDiario();
        }
    }

}