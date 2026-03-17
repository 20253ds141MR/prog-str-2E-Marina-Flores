package com.example.listview.services;

import com.example.listview.repositories.PersonsFileRepository;

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
            int edad = Integer.parseInt(parts[2]);
            result.add(name +" - "+ email+" - "+ edad);
        }
        return result;
    }

    public void updatePerson(int index, String name, String email, String edad) throws IOException {
        validate(name,email, Integer.parseInt(edad));
        if(index<0) {
            throw new IllegalArgumentException("El indice es inválido");
        }
        List<String> data=getCleanLines();
        data.set(index,name+","+email+","+edad);
        repo.saveFile(data);
    }

    public void deletePerson(int index) throws IOException {
        List<String> data = getCleanLines();

        if (index < 0 || index >= data.size()) {
            throw new IllegalArgumentException("El índice es inválido o está fuera de rango");
        }
        data.remove(index);
        repo.saveFile(data);
    }


    private List<String> getCleanLines() throws IOException {
        List<String> lines= repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for(String line:lines){
            if(line!=null && !line.isBlank()){
                cleanLines.add(line);

            }
        }

        return cleanLines;
    }

    public void addPerson(String name, String email, int edad) throws IOException {
        validate(name, email, edad);
        repo.appenNewLine(name+","+ email + ","+ edad);
    }

    private void validate(String name, String email, int edad) throws IOException {
        if(name==null||name.isBlank()||name.length()<3){
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        String em=(email==null)? "" : email.trim();
        if(em.isEmpty()|| !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email es obligatorio");
        }

        if (edad < 18||edad > 120) {
           throw new IllegalArgumentException("El edad es obligatorio");
        }

    }


}
