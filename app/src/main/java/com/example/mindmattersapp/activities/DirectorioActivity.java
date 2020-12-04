package com.example.mindmattersapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mindmattersapp.R;
import com.example.mindmattersapp.adapters.DoctorAdapter;
import com.example.mindmattersapp.adapters.RecyclerViewOnItemClickListener;
import com.example.mindmattersapp.models.Doctor;

import java.util.ArrayList;
import java.util.List;


public class DirectorioActivity extends AppCompatActivity {
    private RecyclerView doctorsRV;
    private GridLayoutManager gridLayoutManager;
    private Menu menu;
    private DoctorAdapter doctorsAdapter;
    List<Doctor> doctors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directorio);
        setUp();
    }


    public void setUp(){

        gridLayoutManager = new GridLayoutManager(this, 1);

        //SETEAMOS EL VALOR DE NUESTRO RECYCLER VIEW A NUESTRO OBJETO DE TIPO RECYCLERVIEW
        doctorsRV = (RecyclerView) findViewById(R.id.rvDoctors);
        //SETEAMOS EL LAYOUT QUE TENDRA EL RECYCLER VIEW, EN ESTE CASO EL QUE SETEAMOS ANTERIORMENTE
        doctorsRV.setLayoutManager(gridLayoutManager);

        //CREAMOS UNA LINEA ENTRE CADA ITEM DEL RECYCLER VIEW PARA QUE ESTOS SE PUEDAN DISTINGUIR
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        doctorsRV.addItemDecoration(dividerItemDecoration);


        //Obtenemos los datos
        loadDoctors();
        doctorsAdapter=new DoctorAdapter(doctors, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Bundle argument = new Bundle();
                argument.putSerializable("DOCTOR",doctors.get(position));
                Intent intent = new Intent(getApplicationContext(), DoctorDetailsActivity.class);
                intent.putExtras(argument);
                startActivity(intent);
            }
        });

        doctorsRV.setAdapter(doctorsAdapter);
    }

    //METODO QUE DEVUELVE LA LISTA DE OBJETOS DE TIPO DOCTOR
    public List<Doctor> loadDoctors(){

        doctors.add(new Doctor("Dra. Lorena Juarez", "Psiquiatría", "Infanto-Juvenil", 5,
                "6 KM","Doctora con especialidad de la universidad de Córdoba, con 15 años de experiencia en la atención a niños y jóvenes",
                "Lunes a Viernes: 10 AM - 3 PM","Sábado: 10 AM - 1 PM","2229 - 8522",
                "8874 - 1052 Tigo", "Semáforos del Club Terraza, 2 KM al sur.", R.drawable.doctor1));

        doctors.add(new Doctor("Dr. Juan Peralta", "Psiquiatría", "Adicciones", 5,
                "8 KM","Doctor con 25 años de experiencia tratando todo tipo de adicciones. Estudios en la Universidad Nacional Autónoma de México",
                "Lunes a Jueves: 8 AM - 12 M","","22789658",
                "88425211 Claro", "Centro Comercial Managua Módulo C34", R.drawable.doctor2));

        doctors.add(new Doctor("Dr. Freddy Cárdenas", "Psicología", "Familia", 5,
                "1 KM","Problemas dentro de la familia. Estudios en la Universidad Nacional Autónoma de Nicaragua",
                "Lunes a Viernes: 8 AM - 5PM","","22569874",
                "89655851", "Altamira casa M987", R.drawable.doctor3));

        doctors.add(new Doctor("Dra. Grethel Villanueva", "Psicología", "Adolescencia", 5,
                "11 KM","Problemas de adaptación de los jóvenes. Graduada en Argentina",
                "Lunes a Viernes: 8 AM - 5PM","","22698555",
                "58998854", "Los Robles 21", R.drawable.doctor4));

        return doctors;
    }

    //METODO USADO PARA INFLAR LAS ACCIONES DEL ACTION BAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;

        //INFLAMOS EL MENU
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //METODO QUE FUNCIONA PARA HACER ALGO AL MOMENTO DE SELECCIONAR
    //UNA DE LAS ACCIONES DEL ACTION BAR
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (item.getItemId() == R.id.gridLayout) {
            switchLayout();
            switchIcon(item);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //METODO QUE FUNCIONA PARA CAMBIAR EL DISEÑO DEL GridLayourManager
    //QUE LE SETEAMOS AL RECYCLER VIEW EN EL METODO ONCREATE DE LA VISTA
    private void switchLayout() {
        if (gridLayoutManager.getSpanCount() == 1) {
            gridLayoutManager.setSpanCount(2);
        } else {
            gridLayoutManager.setSpanCount(1);
        }
        doctorsAdapter.notifyItemRangeChanged(0, doctorsAdapter.getItemCount());
    }

    //METODO QUE CAMBIA EL ICONO DE LA ACCION DEL ACTION BAR CADA VEZ QUE
    //SE TOCA
    private void switchIcon(MenuItem item) {
        if (gridLayoutManager.getSpanCount() == 2) {
            item.setIcon(getResources().getDrawable(R.drawable.ic_linearlayoutbutton));
        } else {
            item.setIcon(getResources().getDrawable(R.drawable.ic_gridlayoutbutton));
        }
    }

}