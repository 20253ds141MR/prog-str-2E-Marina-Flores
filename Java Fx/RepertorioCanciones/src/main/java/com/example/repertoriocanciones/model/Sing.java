package com.example.repertoriocanciones.model;

public class Sing {

    String titulo;
    String artista;
    String categoria;

    public Sing(String titulo, String artista, String categoria) {
        this.artista = artista;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " - (" + categoria + ")";
    }
}
