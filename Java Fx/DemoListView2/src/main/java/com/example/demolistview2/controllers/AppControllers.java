package com.example.demolistview2.controllers;

import com.example.demolistview2.services.PersonService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.util.List;


public class AppControllers {

    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtAutor;
    @FXML
    private TextField txtAge;

    @FXML
    private ObservableList<String> data =FXCollections.observableArrayList();


    private PersonService service = new PersonService();
    @FXML
    public void initialize(){
        loadFromFile();
        listView.setItems(data);
    }

    @FXML
    public void onReload(){

        loadFromFile();
    }
    @FXML
    public void onAdd() {
        try {
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            String age = txtAge.getText();
            service.addPerson(titulo, autor, age);
            lblMsg.setText("Libro registrado con éxito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtTitulo.clear();
            txtAutor.clear();
            loadFromFile();

        } catch (IOException e) {
            lblMsg.setText("Error en el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText("Error en los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }
    private void loadFromFile () {
        try {
            List<String> items = service.loadDataForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados con exito");
            lblMsg.setStyle("-fx-text-fill: green");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}