package com.example.mindmattersapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mindmattersapp.R;

public class DisplayMessageActivity extends AppCompatActivity {
    private static final String TAG = DisplayMessageActivity.class.getName();
    private TextView messageHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        messageHeader = (TextView) findViewById(R.id.tvHeader);
        setup();
    }

    private void setup() {
        setupBar();
        Intent navIntent = getIntent();
        String pagina = navIntent.getStringExtra("URL");
        String encabezado = navIntent.getStringExtra("HEADER");
        messageHeader.setText(encabezado);
        WebView myWebView = (WebView) findViewById( R.id.wvMensaje);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(pagina);
    }

    private void setupBar() {
        if(getSupportActionBar() == null) {
            Log.d(TAG, "ActionBar null");
            return;
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}