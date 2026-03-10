package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonsFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Recibe el listado
public class PersonService {

    PersonsFileRepository repo = new PersonsFileRepository();

    //Logica de negocio (EXAMEN)
    public List<String> loadDataForListView() throws IOException {

        List<String> lines= repo.readAllLines();
        List<String> result= new ArrayList<>();



        //Devuelve un arreglo separado por comas
        for(String line:lines){
            if(line==null||line.isBlank())continue;

            String[] parts = line.split(",");
            String name = parts[0];
            String email = parts[1];
            result.add(name +" - "+ email);
        }
        return result;
    }

    public void addPerson(String name, String email) throws IOException {
        validate(name, email);
        repo.appenNewLine(name+","+email);
    }

    private void validate(String name, String email) throws IOException {
        if(name==null||name.isBlank()||name.length()<3){
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        String em=(email==null)? "" : email.trim();
        if(em.isEmpty()|| !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email es obligatorio");
        }
    }
}
