package org.labarranca.barrancapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.labarranca.barrancapp.database.DatabaseConnection;
import org.labarranca.barrancapp.models.Cow;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    public void handleAddCow() {
        Cow cow = new Cow();
        cow.setEarTag(earTagField.getText());
        cow.setBreed(breedField.getText());
        cow.setSex(sexField.getText());
        cow.setWeight(Double.parseDouble(weightField.getText()));
        cow.setBirthdate(birthdatePicker.getValue());

        if (cow.getEarTag().isEmpty() || cow.getBreed().isEmpty() || cow.getSex().isEmpty() || cow.getWeight() <= 0 || cow.getBirthdate() == null) {
            System.out.println("Invalid input, all fields are required");
            return;
        }

        saveCowToDatabase(cow);
    }

    private void saveCowToDatabase(Cow cow) {
        String insertSQL = "INSERT INTO cow (ear_tag, breed, sex, weight, birthdate) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, cow.getEarTag());
            preparedStatement.setString(2, cow.getBreed());
            preparedStatement.setString(3, cow.getSex());
            preparedStatement.setDouble(4, cow.getWeight());

            Date birthDate = Date.valueOf(cow.getBirthdate());
            preparedStatement.setDate(5, birthDate);

        } catch (SQLException e) {
            System.out.println("Error saving cow: " + e.getMessage());
        }
    }
}
