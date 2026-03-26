package com.example.repertoriocanciones.service;

import com.example.repertoriocanciones.model.Sing;

import java.util.ArrayList;
import java.util.List;

public class SingService {


    private List<Sing>  lista = new ArrayList();

    public String agregar(String titulo, String artista, String categoria){
        if(titulo.isEmpty()) return "Titulo no válido";
        if(artista.isEmpty()) return "Artista no puede estar vacío";
        if(categoria==null) return "Campo inválido";
        if(categoria.isEmpty()) return "Seleccione un categoria";

        if(buscar(titulo) !=null){
            return "OK";
        }

        lista.add(new Sing(titulo,artista,categoria));
        return "OK";
    }

    public Sing buscar(String titulo){
        titulo = titulo.trim();
        for(Sing s : lista){
            if(s.getTitulo().equals(titulo)){
                return s;
            }
        }
        return null;
    }

    public String eliminar(String titulo){
        Sing s = buscar(titulo);
        if(s!=null){
            lista.remove(s);
            return "OK";
        }
        return "No encontrado";
    }

    public List<Sing> listar() {
        return lista;
    }
}
