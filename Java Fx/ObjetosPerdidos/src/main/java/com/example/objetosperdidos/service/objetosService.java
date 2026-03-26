package com.example.objetosperdidos.service;

import com.example.objetosperdidos.model.Objetos;

import java.util.ArrayList;
import java.util.List;

public class objetosService {

    private List<String> lista = new ArrayList();

    public String agregar (String nombre, String lugar, String estado) {
        if(nombre.isEmpty() || lugar.isEmpty() || estado.isEmpty()) {
            return "Campos inválido";
        }
        if(buscar(nombre) !=null){
            return "El objeto ya existe";
        }

        lista.add(new String (nombre,lugar,estado));
        return "OK";
    }

    public Objetos buscar (String nombre) {
         nombre= nombre.trim();
        for(String objeto : lista){
            if(objeto.getNombre().equals(nombre)){
                return objeto;
            }
        }
    }
}
