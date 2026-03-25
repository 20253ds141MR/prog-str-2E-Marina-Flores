package com.example.contactosemergencia.controllers;

import com.example.contactosemergencia.model.Contacto;
import com.example.contactosemergencia.services.ContactoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> comboParentesco;
    @FXML private ListView<Contacto> listView;


    private ContactoService service = new ContactoService();

    private String[] parentesco = {
    "Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"
    };

    @FXML
    public void initialize() {
        comboParentesco.setItems(FXCollections.observableArrayList(parentesco));
        actualizarLista();
    }

    private void actualizarLista() {
        listView.setItems(FXCollections.observableArrayList(service.listar()));
    }

    private void limpiar(){
        txtNombre.clear();
        txtTelefono.clear();
        comboParentesco.setValue(null);
    }

    @FXML
    public void agregar(){
        String res = service.agregar(
                txtNombre.getText(),
                txtTelefono.getText(),
                (String) comboParentesco.getValue()
        );

        if (res.equals("OK")){
            actualizarLista();
            limpiar();
        } else {
            mostrarMensaje(res);
        }
    }
    @FXML
    public void buscar(){
        Contacto seleccionado = listView.getSelectionModel().getSelectedItem();
        if (seleccionado != null){
            txtTelefono.setText(seleccionado.getTelefono());
            txtNombre.setText(seleccionado.getNombre());
            comboParentesco.setValue(seleccionado.getParentesco());
        } else {
            mostrarMensaje("No encontrado");
        }
    }

    @FXML
    public void actualizar(){
        Contacto seleccionado = listView.getSelectionModel().getSelectedItem();

        if (seleccionado != null){

            seleccionado.setTelefono(txtTelefono.getText().trim());
            seleccionado.setParentesco(comboParentesco.getValue());

            actualizarLista();
        } else {
            mostrarMensaje("No seleccionado");
        }
    }
    @FXML
    public void eliminar(){
        Contacto seleccionado = listView.getSelectionModel().getSelectedItem();

        if (seleccionado != null){
            service.eliminar(seleccionado.getNombre());
            actualizarLista();
            limpiar();
        } else {
            mostrarMensaje("Selecciona un contacto");
        }
    }

    @FXML
    public void limpiarCampos(){
        limpiar();
    }

    private void mostrarMensaje(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }
}
