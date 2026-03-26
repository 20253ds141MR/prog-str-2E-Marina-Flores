package com.example.objetosperdidos.controller;

import com.example.objetosperdidos.model.Objetos;
import com.example.objetosperdidos.service.objetosService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class objetosController {
    @FXML private TextField txtNombre;
    @FXML private TextField txtLugar;
    @FXML private ComboBox<String> comboEstado;
    @FXML private ListView<String> listView;

    private objetosService objetosService = new objetosService();

    private String [] estado = {
            "Sin reclamar",
            "Entregado"
    };

    @FXML
    public void initialize() {
        comboEstado.setItems(FXCollections.observableArrayList(estado));
        actualizarLista();
    }
    @FXML
    public void actualizarLista() {
        listView.setItems(FXCollections.observableArrayList(objetosService.listar()));
    }
    private void limpiar(){
        txtNombre.clear();
        txtLugar.clear();
        comboEstado.getValue(null);
    }

    @FXML
    public void agregar() {
        String objeto = objetosService.agregar(
                txtNombre.getText(),
                txtLugar.getText(),
                comboEstado.getValue()
        );
        if(objeto.equals("Sin reclamar")){
            actualizarLista();
            limpiar();
        } else {
            mostrarMensaje(objeto);
        }
    }

    private void mostrarMensaje(String objeto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(objeto);
        alert.show();
    }

    @FXML
    public void actualizar() {
        Objetos seleccionado = listView.getSelectionModel().getSelectedItem();
        if(seleccionado != null){

            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setLugar(txtLugar.getText());
            seleccionado.setEstado(comboEstado.getValue());

            actualizarLista();
            listView.getSelectionModel().select(seleccionado);
        } else {
            mostrarMensaje("Seleccione un objeto");
        }
    }

    @FXML
    public void buscar(ActionEvent event) {
        String titulo = txtNombre.getText().trim();

        if(titulo.isEmpty()){
        mostrarMensaje("El nombre es obligatorio");
        }
    }
    @FXML
    public void eliminar() {
        Objetos seleccionado = listView.getSelectionModel().getSelectedItem();
        if(seleccionado != null){
            objetosService.eliminar(seleccionado.getNombre());
            actualizarLista();
            limpiar();
        } else {
            mostrarMensaje("Seleccione un objeto");
        }
    }

}
