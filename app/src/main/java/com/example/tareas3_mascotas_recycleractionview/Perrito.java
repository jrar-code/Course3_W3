package com.example.tareas3_mascotas_recycleractionview;

import java.io.Serializable;

//si uso implements Seriealizable puedo enviar toda la lista en el intent.
public class Perrito implements Serializable, Comparable<Perrito> {

    private String nombre; // el nombre del perrito
    private int likes; //Total Likes
    private int mifavorito; // mi like
    private int foto; // la foto del perrito

    public Perrito(int foto, String nombre, int mifavorito, int likes) {
//    public Perrito(int foto, String nombre, int likes, int mifavorito) {
        this.foto = foto;
        this.nombre = nombre;
        this.mifavorito = mifavorito;
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getMifavorito() {
        return mifavorito;
    }

    public void setMifavorito(int mifavorito) {
        this.mifavorito = mifavorito;
    }

    @Override
    public int compareTo(Perrito perrito) {
        //esto es para ordenar de menor a mayor
        //return this.likes > perrito.likes ? 1 : (this.likes < perrito.likes ? -1 : 0);
        //para ordenar de mayor a menor, solo cambiar
        return this.likes < perrito.likes ? 1 : (this.likes > perrito.likes ? -1 : 0);
    }
}
