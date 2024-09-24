package org.labarranca.barrancapp.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CowTableController {

    public void openAddCowForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/labarranca/barrancapp/cowForm.fxml"));
            Parent addCowFormRoot = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Registrar Vaca");
            stage.setScene(new Scene(addCowFormRoot));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
