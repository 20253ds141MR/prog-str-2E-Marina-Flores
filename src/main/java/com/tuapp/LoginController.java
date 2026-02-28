package com.tuapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

    public class LoginController {

        @FXML
        private TextField txtCorreo;
        @FXML
        private PasswordField txtPassword;
        @FXML
        private Label lblError;

        @FXML
        private void onLogin() {
            lblError.setText("");

            String correo = txtCorreo.getText() == null ? "" : txtCorreo.getText().trim();
            String password = txtPassword.getText() == null ? "" : txtPassword.getText();

            StringBuilder errores = new StringBuilder();

            // Validación
            if (correo.isEmpty() || !correo.contains("@") || !correo.contains(".")) {
                errores.append("• Correo inválido (debe incluir @ y .)\n");
            }

            // Password mínimo 6 caracteres
            if (password.length() < 6) {
                errores.append("• Contraseña: mínimo 6 caracteres\n");
            }


            if (errores.length() > 0) {
                lblError.setText(errores.toString());
                return;

            }

            // Extraer "X" a partir del correo (parte antes de @)
            String nombre = correo.substring(0, correo.indexOf('@'));
            if (nombre.isBlank()) nombre = correo;

            // Ir al Dashboard
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tuapp/dashboard.fxml"));
                Scene dashboardScene = new Scene(loader.load(), 420, 220);
                dashboardScene.getStylesheets().add(getClass().getResource("/com/tuapp/styles.css").toExternalForm());

                // Pasar el nombre al controller
                DashboardController controller = loader.getController();
                controller.setNombre(nombre);

                // Cambiar la escena en el Stage actual
                Stage stage = (Stage) txtCorreo.getScene().getWindow();
                stage.setScene(dashboardScene);

            } catch (Exception e) {
                lblError.setText("Ocurrió un error al cargar el Dashboard.");
                e.printStackTrace();
            }
        }
    }

