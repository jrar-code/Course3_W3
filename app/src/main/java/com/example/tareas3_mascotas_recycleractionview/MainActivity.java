package com.example.tareas3_mascotas_recycleractionview;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ImageButton ibn_fav;


    RecyclerView lstPerfiles;
    ArrayList<Perrito> perfiles = new ArrayList<Perrito>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);

        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle(null);
        //-------------

        lstPerfiles = (RecyclerView) findViewById(R.id.rv1_perritos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lstPerfiles.setLayoutManager(llm);

        iniciaAdaptador(); // es problema está aquí escondido
        iniciaPerfiles();


//*
        ibn_fav = (ImageButton) findViewById(R.id.ab_favs);

        ibn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Holi", Toast.LENGTH_SHORT).show();

                //idea para enviar solo los perritos que estén en favoritos.

                ArrayList<Perrito> perritosFavs = new ArrayList<Perrito>();

                misFavs(perritosFavs,perfiles);


                Intent intent = new Intent(MainActivity.this,FavPetsActivity.class);
                //dos formas de mandar una lista completa. usando esto (perfiles debe tener implements Serializable en su class
                intent.putExtra("lista",perritosFavs);
                //para recogerlo en la otra activity:
                // perfiles = (ArrayList<Perrito>) getIntent().getSerializableExtra("lista");

                /* o usando esto

                Bundle bundle = new Bundle();
                bundle.putSerializable("lista",perfiles);
                intent.putExtras(bundle);
                // REVISAR que sea "putExtras" y no "putExtra"
                // --- para recogerlo en la otra actividad:
                Bundle perfiles = getIntent().getExtras();
                perfiles = (ArrayList<Perrito>) bundle.getSerializable("lista");
                */

                startActivity(intent);


            }
        });
    /*
        bn_siguiente = (Button) findViewById(R.id.bn_ir2da);
        bn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Holi", Toast.LENGTH_SHORT).show();
                irSegundaAct(view);
            }
        });
        */

        //fin onCreae
    }

    private void misFavs(ArrayList<Perrito> perritosFavs, ArrayList<Perrito> perfiles) {

        //una vez añadido implements Comparable<Perrito perrito> a Perrito.class
        Collections.sort(perfiles);

        for(int i = 0; i< perfiles.size(); i++){
            if(perfiles.get(i).getMifavorito() == 0){
                continue;
            }

            if (perritosFavs.size()>= 5){
                break;
            }
            //Toast.makeText(MainActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
            perritosFavs.add(perfiles.get(i));




            //esto si fuera solo un ArrayList<Interger>
            //Comparator c = Collections.reverseOrder();
            //Collections.sort(perritosFavs,c);


        }
    }

    private void iniciaAdaptador() {
        //PerritoAdaptador adaptador = new PerritoAdaptador(perfiles, this);
        PerritoAdaptador adaptador = new PerritoAdaptador(perfiles,this);
        lstPerfiles.setAdapter(adaptador);
    }

    private void iniciaPerfiles() {
        perfiles.add(new Perrito(R.drawable.perrito_1,"perrito_1",0,12));
        perfiles.add(new Perrito(R.drawable.perrito_2,"perrito_2",1,23));
        perfiles.add(new Perrito(R.drawable.perrito_3,"perrito_3",1,5));
        perfiles.add(new Perrito(R.drawable.perrito_4,"perrito_4",1,24));
        perfiles.add(new Perrito(R.drawable.perrito_5,"perrito_5",0,42));
        perfiles.add(new Perrito(R.drawable.perrito_6,"perrito_6",1,34));
        perfiles.add(new Perrito(R.drawable.perrito_7,"perrito_7",1,60));
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


    public void irSegundaAct(View view){
        Intent intent = new Intent(MainActivity.this,FavPetsActivity.class);
        //dos formas de mandar una lista completa. usando esto
        intent.putExtra("holi",perfiles);
        //para recogerlo en la otra activity:
        // perfiles = (ArrayList<Perrito>) getIntent().getSerializableExtra("lista");


        /* o usando esto
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista",perfiles);
        intent.putExtras(bundle);
        // REVISAR que sea "putExtras" y no "putExtra"
        // --- para recogerlo en la otra actividad:
        Bundle perfiles = getIntent().getExtras();
        perfiles = (ArrayList<Perrito>) bundle.getSerializable("lista");
        */

        startActivity(intent);

    }

    public void bnFotoAct(View view){
        Toast.makeText(MainActivity.this, "Boton Foto", Toast.LENGTH_SHORT).show();
    }
}