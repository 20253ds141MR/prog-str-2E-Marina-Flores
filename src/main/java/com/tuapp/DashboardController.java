package com.tuapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

    public class DashboardController {

        @FXML private Label lblBienvenida;

        public void setNombre(String nombre) {
            lblBienvenida.setText("Bienvenido, " + nombre);
        }
    }
