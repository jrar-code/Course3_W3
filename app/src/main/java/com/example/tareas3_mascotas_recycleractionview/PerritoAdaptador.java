package com.example.tareas3_mascotas_recycleractionview;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PerritoAdaptador extends RecyclerView.Adapter<PerritoAdaptador.PerritoViewHolder>{

    Activity activity;//para que sea clickeable
    ArrayList<Perrito> perfiles;

    public PerritoAdaptador(ArrayList<Perrito> perfiles, Activity activity){ //, Activity activity){
        this.perfiles = perfiles;
        this.activity = activity;
    }


    @NonNull
    @Override
    public PerritoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /* declarar View v
        LayoutInflater
        .from(a)
        a = viewGroup.getContext()
        .from(a).inflate()
        .inflate requiere ( layout, viewGroup, attatchToRoot)
        layout <-- layout a reciclar
        viewGroup aun no sé exactamente pero represente al view heredado
        attatchToRoot ni idea que sea
        */
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cv_perrito, viewGroup,false);
        return new PerritoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerritoViewHolder perritoViewHolder, int i) {
        final Perrito perrito = perfiles.get(i);

        //el vewHolder.elItemDeInteres.set[loQueQuieresDefinir](el objeto java creado . el nombre del geeter correspondiente ());
        perritoViewHolder.cv_iv_perrito.setImageResource(perrito.getFoto());
        perritoViewHolder.cv_txt_nombre.setText(perrito.getNombre());
        perritoViewHolder.cv_nLikes.setText(String.valueOf(perrito.getLikes()));

        defineLikes(perritoViewHolder, perrito);

        //perritoViewHolder.tv_a_miFav.setImageResource(perrito.isMifavorito());
        // ya declaradas las variables en esta función, ahora a usarlas:


        perritoViewHolder.cv_iv_perrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Click en Foto de perrito", Toast.LENGTH_SHORT).show();
            }
        });


        perritoViewHolder.cv_bn_Like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(activity, "Bn_like", Toast.LENGTH_SHORT).show();
                if (perrito.getMifavorito()==0){
                    Toast.makeText(activity, "+1 Like y agregado a favoritos", Toast.LENGTH_SHORT).show();
                    perritoViewHolder.cv_bn_Like.setImageResource(android.R.drawable.btn_star_big_on);
                    perrito.setMifavorito(1);
                    perrito.setLikes(perrito.getLikes()+1);
                    perritoViewHolder.cv_nLikes.setText(String.valueOf(perrito.getLikes()));
                } else if (perrito.getMifavorito()==1){
                    Toast.makeText(activity, "+0 Like y eliminado de favoritos", Toast.LENGTH_SHORT).show();
                    perritoViewHolder.cv_bn_Like.setImageResource(android.R.drawable.btn_star_big_off);
                    perrito.setMifavorito(0);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return perfiles.size();
    }

    public void defineLikes( PerritoViewHolder perritoViewHolder, Perrito perrito){
        if (perrito.getMifavorito()==0){
            perritoViewHolder.cv_bn_Like.setImageResource(android.R.drawable.btn_star_big_off);
        } else if (perrito.getMifavorito()==1){
            perritoViewHolder.cv_bn_Like.setImageResource(android.R.drawable.btn_star_big_on);
        }
    }


    public static class PerritoViewHolder extends RecyclerView.ViewHolder {
        private ImageView cv_iv_perrito;
        private TextView cv_txt_nombre;

        private ImageButton cv_bn_Like;
        private Button cv_nLikes;

        //private ImageButton tv_likeTotal;

        public PerritoViewHolder(@NonNull View itemView) {
            super(itemView);
/*
            cv_iv_perrito = (ImageView)itemView.findViewById(R.id.cv_iv_perrito);
            cv_txt_nombre = (TextView) itemView.findViewById(R.id.cv_txt_nombre);
*/


            cv_iv_perrito = itemView.findViewById(R.id.cv_iv_perrito);
            cv_txt_nombre = itemView.findViewById(R.id.cv_txt_nombre);

            cv_bn_Like = (ImageButton) itemView.findViewById(R.id.cv_bn_Like);

            cv_nLikes = (Button) itemView.findViewById(R.id.cv_bn_nFavs);

        }
    }
}
