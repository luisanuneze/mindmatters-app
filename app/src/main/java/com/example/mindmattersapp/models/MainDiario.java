package com.example.mindmattersapp.models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mindmattersapp.R;
import com.example.mindmattersapp.adapters.DiaryAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainDiario extends AppCompatActivity {

    FloatingActionButton btnNP;

    private RecyclerView diaryRv;
    private DiaryAdapter diaryAdapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_diario);

        btnNP = findViewById(R.id.buttonNPD);
        btnNP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainDiario.this, PaginaDiario.class));
            }
        });
        loadAll();
    }

    public void loadAll(){
        //SETEAMOS LA CANTIDAD DE COLUMNAS QUE TENDRA NUESTRA VISTA AL INICIAL EL ACTIVITY
        gridLayoutManager = new GridLayoutManager(this, 1);

        //SETEAMOS EL VALOR DE NUESTRO RECYCLER VIEW A NUESTRO OBJETO DE TIPO RECYCLERVIEW
        diaryRv = (RecyclerView) findViewById(R.id.rvDiario);
        //SETEAMOS EL LAYOUT QUE TENDRA EL RECYCLER VIEW, EN ESTE CASO EL QUE SETEAMOS ANTERIORMENTE
        diaryRv.setLayoutManager(gridLayoutManager);

        //CREAMOS UNA LINEA ENTRE CADA ITEM DEL RECYCLER VIEW PARA QUE ESTOS SE PUEDAN DISTINGUIR
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        diaryRv.addItemDecoration(dividerItemDecoration);

        //LE SETEAMOS AL ADAPTADOR LA LISTA DE POKEMONS QUE VAMOS A AÑADIR AL RECYCLER VIEW
        diaryAdapter = new DiaryAdapter(obtainDiary());

        //SETEAMOS EL ADAPTADOR EN NUESTRO RECYCLER VIEW
        diaryRv.setAdapter(diaryAdapter);
    }

    //METODO QUE DEVUELVE LA LISTA DE OBJETOS DE TIPO POKEMONS
    public List<PageDiarioModel> obtainDiary(){
        List<PageDiarioModel> diary = new ArrayList<>();
        diary.add(new PageDiarioModel("#1", "Mal día :(", "03/12/2020 5:10 a.m.", "abkjvjvjkdvnkjdnvjdkvndjvn"));
        diary.add(new PageDiarioModel("#2", "Vol mal en la U xd", "04/12/2020 5:11 a.m.", "abkjvdjvjkdvnkjdnvjdkvndjvn"));
        diary.add(new PageDiarioModel("#3", "Dia normal", "05/12/2020 5:13 a.m.", "abkjvjvjkdvvvnkjdnvjdkvndjvn"));
        return diary;
    }}