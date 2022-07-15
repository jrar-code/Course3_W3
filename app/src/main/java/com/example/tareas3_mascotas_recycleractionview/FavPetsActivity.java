package com.example.tareas3_mascotas_recycleractionview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class FavPetsActivity extends AppCompatActivity {

    RecyclerView lstPerfiles;
    ArrayList<Perrito> perfiles;
    ImageButton bn_ab1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_pets);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        //identificar y ocultar item específico
        getSupportActionBar().setTitle(null);
        // mostrar botón de back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bn_ab1 = (ImageButton) findViewById(R.id.ab_favs);
        bn_ab1.setImageResource(android.R.drawable.btn_star_big_off);



        perfiles = (ArrayList<Perrito>) getIntent().getSerializableExtra("lista");


        lstPerfiles = (RecyclerView) findViewById(R.id.rv2_perritos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lstPerfiles.setLayoutManager(llm);

        iniciaAdaptador(); // es problema está aquí escondido



        //lstPerfiles = (RecyclerView) findViewById(R.id.rv1_perritos);
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //lstPerfiles.setLayoutManager(llm);

        //iniciaAdaptador();


        //Bundle bundle = getIntent().getExtras();
        //bundle.getSerializable("ListaEnviada");
        //bundle.getParcelableArrayList("list");

    }

    private void iniciaAdaptador() {
        PerritoAdaptador adaptador = new PerritoAdaptador(perfiles,this);
        lstPerfiles.setAdapter(adaptador);
    }





    //crear menú ------------- <
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow,menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1){ Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show(); }
        else if(id == R.id.item2){ Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show(); }
        else if(id == R.id.item2){ Toast.makeText(this, "item 3", Toast.LENGTH_SHORT).show(); }
        //metodo booleano entonces hay que enviar un valor booleano.
        return super.onOptionsItemSelected(item);
        //
    }
    //fin de crear menú --------------- >
}