package org.labarranca.barrancapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.labarranca.barrancapp.database.DatabaseConnection;

import java.sql.*;

public class AddCowFormController {
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
    public void handleSaveCow() {
        String earTag = earTagField.getText();
        String breed = breedField.getText();
        String sex = sexField.getText();
        double weight = Double.parseDouble(weightField.getText());
        String birthdate = birthdatePicker.getValue().toString();

        if (earTag.isEmpty() || breed.isEmpty() || sex.isEmpty() || birthdate == null || weight <= 0) {
            System.out.println("Invalid input, all fields are required.");
            return;
        }

        String insertSQL = "INSERT INTO cow (ear_tag, breed, sex, weight, birthdate) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect(); PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
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
