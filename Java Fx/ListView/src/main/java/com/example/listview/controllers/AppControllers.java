package com.example.listview.controllers;

import com.example.listview.services.PersonService;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
     private TextField txtCampoAge;

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
            String name = txtName.getText();
            String email = txtEmail.getText();


            if (txtCampoAge.getText().isEmpty()) {
                lblMsg.setText("Debe ingresar un edad");
                lblMsg.setStyle("-fx-text-fill: red");
                return;
            }

            int edad = Integer.parseInt(txtCampoAge.getText());



            service.addPerson(name, email, edad);
            lblMsg.setText("Persona creada con éxito");
            lblMsg.setStyle("-fx-text-fill: purple");
            txtEmail.clear();
            txtName.clear();
            loadFromFile();

        } catch (NumberFormatException e) {
            lblMsg.setText("La edad debe ser un número válido");
            lblMsg.setStyle("-fx-text-fill: red");
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
            lblMsg.setStyle("-fx-text-fill: purple");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}