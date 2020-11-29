package com.example.mindmattersapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ImageButton;

import com.example.mindmattersapp.R;
import com.example.mindmattersapp.adapters.ForumAdapter;
import com.example.mindmattersapp.models.Topics;

import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends AppCompatActivity {
    private RecyclerView topicsRV;
    private ForumAdapter topicsAdapter;
    private GridLayoutManager gridLayoutManager;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        loadAll();
    }

    public void loadAll(){
        //SETEAMOS LA CANTIDAD DE COLUMNAS QUE TENDRA NUESTRA VISTA AL INICIAL EL ACTIVITY
        gridLayoutManager = new GridLayoutManager(this, 1);

        //SETEAMOS EL VALOR DE NUESTRO RECYCLER VIEW A NUESTRO OBJETO DE TIPO RECYCLERVIEW
        topicsRV = (RecyclerView) findViewById(R.id.rvTopics);
        //SETEAMOS EL LAYOUT QUE TENDRA EL RECYCLER VIEW, EN ESTE CASO EL QUE SETEAMOS ANTERIORMENTE
        topicsRV.setLayoutManager(gridLayoutManager);

        //CREAMOS UNA LINEA ENTRE CADA ITEM DEL RECYCLER VIEW PARA QUE ESTOS SE PUEDAN DISTINGUIR
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        topicsRV.addItemDecoration(dividerItemDecoration);

        //LE SETEAMOS AL ADAPTADOR LA LISTA DE POKEMONS QUE VAMOS A AÑADIR AL RECYCLER VIEW
        topicsAdapter = new ForumAdapter(obtainTopic());

        //SETEAMOS EL ADAPTADOR EN NUESTRO RECYCLER VIEW
        topicsRV.setAdapter(topicsAdapter);
    }

    //METODO QUE DEVUELVE LA LISTA DE OBJETOS DE TIPO POKEMONS
    public List<Topics> obtainTopic(){
        List<Topics> topics = new ArrayList<>();
        topics.add(new Topics("#1","Paz Mental", R.drawable.pazmental));
        topics.add(new Topics("#2","Relajación", R.drawable.relajacion));
        topics.add(new Topics("#3","Minfulness", R.drawable.mindfulness));
        topics.add(new Topics("#1","Meditación", R.drawable.meditacion));
        return topics;
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
        topicsAdapter.notifyItemRangeChanged(0, topicsAdapter.getItemCount());
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