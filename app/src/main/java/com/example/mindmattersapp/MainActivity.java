package com.example.mindmattersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText email,pwd;



    private Button btn_Login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Setup();
    }

    private void Setup (){

        email = findViewById(R.id.tv_user);
        pwd = findViewById(R.id.tv_pass);

        btn_Login=findViewById(R.id.btn_login);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restrict(v);
            }
        });

    }

    private void NavigateMenu() {

        Intent intent = new Intent(this, menuprincipal.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    private void Restrict( View view){
        if (email.getText().toString().isEmpty()){
            if (pwd.getText().toString().isEmpty()){
                Snackbar.make(view, " Los campos son requeridos.", Snackbar.LENGTH_SHORT).show();
            }
        }
        else{
            NavigateMenu();
        }
    }


}