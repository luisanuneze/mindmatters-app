package com.example.mindmattersapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        loadAll();
    }

    public void loadAll(){
        //SETEAMOS LA CANTIDAD DE COLUMNAS QUE TENDRA NUESTRA VISTA AL INICIAL EL ACTIVITY
        gridLayoutManager = new GridLayoutManager(this, 1);

        //SETEAMOS EL VALOR DE NUESTRO RECYCLER VIEW A pokemonRV
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
}