package org.labarranca.barrancapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.labarranca.barrancapp.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CowController {
    @FXML
    private TextField earTagField;
    @FXML
    private TextField breedField;
    @FXML
    private TextField sexField;
    @FXML
    private TextField weightField;
    @FXML
    private DatePicker birthdatePicker;

    @FXML
    private void handleSave() {
        String earTag = earTagField.getText();
        String breed = breedField.getText();
        String sex = sexField.getText();
        double weight = Double.parseDouble(weightField.getText());

        String sql = "INSERT INTO cows(ear_tag, breed, sex, weight, birthdate) VALUES(?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, earTag);
            preparedStatement.setString(2, breed);
            preparedStatement.setString(3, sex);
            preparedStatement.setDouble(4, weight);

            Date birthDate = Date.valueOf(birthdatePicker.getValue());
            preparedStatement.setDate(5, birthDate);

            preparedStatement.executeUpdate();
            System.out.println("Cow saved successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
