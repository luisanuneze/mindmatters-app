package com.example.mindmattersapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mindmattersapp.activities.ForumActivity;
import com.example.mindmattersapp.adapters.ForumAdapter;
import com.example.mindmattersapp.data.UserConfig;
import com.example.mindmattersapp.models.Topics;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnStart;
    private TextView tvUser, tvPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActions();
    }

    private void setupActions() {
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

    private void navigateToForum() {
        saveFirstStart();
        Intent intent = new Intent(this, ForumActivity.class);
        //la proxima activity ahora será la primera en el back stack
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void saveFirstStart() {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        userConfig.setIsFirstTime(false);
    }

    private void restrict(View v){
        if(tvUser.getText().toString().isEmpty()){
            if(tvPwd.getText().toString().isEmpty()){
                Snackbar.make(v, "Los campos son requeridos", Snackbar.LENGTH_SHORT).show();
            }
        } else {
            navigateToForum();
        }
    }

}