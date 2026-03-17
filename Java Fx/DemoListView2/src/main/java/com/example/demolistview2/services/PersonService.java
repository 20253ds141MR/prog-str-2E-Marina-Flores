package com.example.demolistview2.services;

import com.example.demolistview2.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Recibe el listado
public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    //Logica de negocio (EXAMEN)
    public List<String> loadDataForListView() throws IOException {

        List<String> lines= repo.readAllLines();
        List<String> result= new ArrayList<>();



        //Devuelve un arreglo separado por comas
        for(String line:lines){
            if(line==null||line.isBlank())continue;

            String[] parts = line.split(",");
            String titulo = parts[0];
            String autor = parts[1];
            result.add(titulo +" - "+ autor);
        }
        return result;
    }

    public void addPerson(String titulo, String autor) throws IOException {
        validate(titulo, autor);
        repo.appenNewLine(titulo+","+autor);
    }

    private void validate(String titulo, String autor) throws IOException {
        if(titulo==null||titulo.isBlank()||titulo.length()<3){
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

    }
}

