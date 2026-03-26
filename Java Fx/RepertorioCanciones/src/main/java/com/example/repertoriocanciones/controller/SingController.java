package com.example.repertoriocanciones.controller;

import com.example.repertoriocanciones.model.Sing;
import com.example.repertoriocanciones.service.SingService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SingController {

    @FXML private TextField txtTitulo;
    @FXML private TextField txtArtista;
    @FXML private ComboBox<String> comboCategoria;
    @FXML private ListView<Sing> listView;

    private SingService singService = new SingService();

    private String [] categoria = {
            "Entrada",
            "Alabanza",
            "Especial",
            "Cierre"
    };

    @FXML
    public void initialize() {
        comboCategoria.setItems(FXCollections.observableArrayList(categoria));
        actualizarLista();
    }

    @FXML
    private void actualizarLista() {
        listView.setItems(FXCollections.observableArrayList(singService.listar()));
    }

    private void limpiar(){
        txtTitulo.clear();
        txtArtista.clear();
        comboCategoria.setValue(null);
    }
    @FXML
    private void agregar(){
    String sing = singService.agregar(
            txtTitulo.getText(),
            txtArtista.getText(),
            comboCategoria.getValue()
    );
    if(sing.equals("OK")){
        actualizarLista();
        limpiar();
    } else {
        mostrarMensaje(sing);
    }
    }

    private void mostrarMensaje(String sing){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(sing);
        alert.show();
    }

    @FXML
    private void actualizar(){
        Sing seleccionado = listView.getSelectionModel().getSelectedItem();
        if(seleccionado != null){

            seleccionado.setTitulo(txtTitulo.getText().trim());
            seleccionado.setArtista(txtArtista.getText().trim());
            seleccionado.setCategoria(comboCategoria.getValue());

            actualizarLista();
            listView.getSelectionModel().select(seleccionado);
        } else {
            mostrarMensaje("Seleccione una canción");
        }
    }

    @FXML
    private void buscar(ActionEvent event) {
        String titulo = txtTitulo.getText().trim();
        if(titulo.isEmpty()){
            mostrarMensaje("Introduce un título a buscar");
        }

        Sing resultado = singService.buscar(titulo);
        if(resultado != null){
            listView.getSelectionModel().select(resultado);

            txtTitulo.setText(resultado.getTitulo());
            txtArtista.setText(resultado.getArtista());
            comboCategoria.setValue(resultado.getCategoria());
        } else {
            mostrarMensaje("No encontrado");
        }
    }
    @FXML
    private void eliminar(){
        Sing seleccionado = listView.getSelectionModel().getSelectedItem();
        if(seleccionado != null){
            singService.eliminar(seleccionado.getTitulo());
            actualizarLista();
            limpiar();
        } else {
            mostrarMensaje("Selecciona una canción");
        }
    }

}
