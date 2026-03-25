package com.example.contactosemergencia.services;

import com.example.contactosemergencia.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoService {

    private List<Contacto> lista = new ArrayList();

    public String agregar(String nombre, String telefono, String parentesco) {

        if (nombre.isEmpty()) return "Nombre invalido";
        if (telefono.isEmpty()) return "Telefono invalido";
        if (telefono.length() != 10) return "Telefono invalido, deben ser 10 dígitos";
        if (parentesco == null) return "Parentesco invalido";
        if (parentesco.isEmpty()) return "Parentesco invalido";

        if (buscar(nombre) != null) {
            return "OK";
        }

        lista.add(new Contacto(nombre, telefono, parentesco));
        return "OK";
    }


    public Contacto buscar(String nombre) {
        nombre= nombre.trim();
        for (Contacto contacto : lista) {
            if (contacto.getNombre().equalsIgnoreCase(nombre.trim())) {
                return contacto;
            }
        }
        return null;
    }

    public String actualizar(String nombre, String telefono, String parentesco) {
        Contacto contacto = buscar(nombre);
        if (contacto == null) return "No encontrado";

        telefono = telefono.trim();

        if (!telefono.matches("\\d{10}")) return "Telefono invalido";
        contacto.setTelefono(telefono);
        contacto.setParentesco(parentesco);
        return "OK";
    }

    public String eliminar(String nombre) {
        Contacto contacto = buscar(nombre);

        if (contacto != null) {
            lista.remove(contacto);
            return "OK";
        }
        return "No encontrado";

    }

    public List<Contacto> listar() {
        return lista;
    }
}
