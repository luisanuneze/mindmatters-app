package com.example.mindmattersapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mindmattersapp.R;
import com.example.mindmattersapp.models.Doctor;

public class DoctorDetailsActivity extends AppCompatActivity {
    private static final String TAG = DoctorDetailsActivity.class.getName();
    private TextView tvNombre;
    private TextView tvEspecialidad;
    private ImageView ivFoto;
    private TextView tvDescripcion;
    private TextView tvHorario1;
    private TextView tvHorario2;
    private TextView tvTel1;
    private TextView tvTel2;
    private TextView tvDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvEspecialidad = (TextView) findViewById(R.id.tvEspecialidad);
        ivFoto = (ImageView) findViewById(R.id.ivFoto);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvHorario1 = (TextView) findViewById(R.id.tvHorario1);
        tvHorario2 = (TextView) findViewById(R.id.tvHorario2);
        tvTel1 = (TextView) findViewById(R.id.tvTel1);
        tvTel2 = (TextView) findViewById(R.id.tvTel2);
        tvDireccion = (TextView) findViewById(R.id.tvDireccion);
        setup();
    }

    private void setup() {
        setupBar();
        Intent navIntent = getIntent();
        Doctor doctor = (Doctor) navIntent.getExtras().getSerializable("DOCTOR");
        tvNombre.setText(doctor.getNombre());
        tvEspecialidad.setText(doctor.getEspecialidad()+"\n"+doctor.getSubEspecialidad());
        ivFoto.setImageResource(doctor.getFoto());
        tvDescripcion.setText(doctor.getDescripcion());
        tvHorario1.setText(doctor.getHorario1());
        tvHorario2.setText(doctor.getHorario2());
        tvTel1.setText(doctor.getTel1());
        tvTel2.setText(doctor.getTel2());
        tvDireccion.setText(doctor.getDireccion());
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