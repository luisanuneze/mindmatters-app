package com.example.mindmattersapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindmattersapp.R;
import com.example.mindmattersapp.adapters.RecyclerViewOnItemClickListener;
import com.example.mindmattersapp.adapters.WellBeingAdapter;
import com.example.mindmattersapp.models.WellBeingEntry;

import java.util.ArrayList;
import java.util.List;

public class WellBeingActivity extends AppCompatActivity  {
    private RecyclerView messagesRV;
    private WellBeingAdapter messagesAdapter;
    private GridLayoutManager gridLayoutManager;
    private Menu menu;
    List<WellBeingEntry> messages = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellbeing);
        loadAll();
    }

    public void loadAll(){

        //SETEAMOS LA CANTIDAD DE COLUMNAS QUE TENDRA NUESTRA VISTA AL INICIAL EL ACTIVITY
        gridLayoutManager = new GridLayoutManager(this, 1);

        //SETEAMOS EL VALOR DE NUESTRO RECYCLER VIEW A NUESTRO OBJETO DE TIPO RECYCLERVIEW
        messagesRV = (RecyclerView) findViewById(R.id.rvMessages);
        //SETEAMOS EL LAYOUT QUE TENDRA EL RECYCLER VIEW, EN ESTE CASO EL QUE SETEAMOS ANTERIORMENTE
        messagesRV.setLayoutManager(gridLayoutManager);

        //CREAMOS UNA LINEA ENTRE CADA ITEM DEL RECYCLER VIEW PARA QUE ESTOS SE PUEDAN DISTINGUIR
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        messagesRV.addItemDecoration(dividerItemDecoration);

        //Obtenemos los datos
        cargarDatos();
        messagesAdapter=new WellBeingAdapter(messages, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent webPageIntent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
                webPageIntent.putExtra("URL",messages.get(position).getMsgPath());
                webPageIntent.putExtra("HEADER",messages.get(position).getMsgHeader());
                startActivity(webPageIntent);
            }
        });

        messagesRV.setAdapter(messagesAdapter);


    }

    //METODO QUE DEVUELVE LA LISTA DE OBJETOS DE TIPO WellBeingEntry
    public List<WellBeingEntry> cargarDatos(){
        messages.add(new WellBeingEntry("Consejos para una vida armoniosa","Para lograr una vida armoniosa aplica estos consejos en tu día a día.", R.drawable.mensaje1,"file:///android_asset/mensaje1.html"));
        messages.add(new WellBeingEntry("Cuida tu salud como estudiante","La inteligencia emocional es la capacidad para manejar tus emociones adecuadamente.", R.drawable.mensaje2,"file:///android_asset/mensaje2.html"));
        messages.add(new WellBeingEntry("¿Qué es el Bienestar Emocional?","El bienestar emocional lo constituyen el conjunto de sensaciones positivas derivadas.", R.drawable.mensaje3,"file:///android_asset/mensaje3.html"));
        messages.add(new WellBeingEntry("La importancia de la comunicación","La comunicación permite expresar las ideas y pensamientos que tanto agobian.", R.drawable.mensaje4,"file:///android_asset/mensaje4.html"));
        return messages;
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
        messagesAdapter.notifyItemRangeChanged(0, messagesAdapter.getItemCount());
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