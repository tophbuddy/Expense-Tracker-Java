package com.example.expensetrackerjava.controller;

import com.example.expensetrackerjava.model.User;
import com.example.expensetrackerjava.repository.DatabaseConnection;
import com.example.expensetrackerjava.repository.daos.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationFormController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button registrationButton;

    private UserDao userDao;

    public RegistrationFormController() {
        userDao = new UserDao(DatabaseConnection.getInstance().getConnection());
    }

    @FXML
    public void initialize() {
        registrationButton.setOnAction(this::handleRegister);
    }

    @FXML
    private void handleRegister(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();

        if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
                email.isEmpty() || phoneNumber.isEmpty()) {
            showRegisterFailureAlert();
        } else {
            User newUser = new User(username, password, firstName, lastName, email, phoneNumber);
            boolean isUserCreated = userDao.createUser(newUser);

            if (isUserCreated) {
                showSuccessAlert();
                goToLoginPage(event);
            } else {
                showUserCreationFailureAlert();
            }
        }
    }

    private void showSuccessAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Registration Success");
        alert.setContentText("User account creation success. Please login into your new account.");
        alert.showAndWait();
    }

    private void showRegisterFailureAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Registration Error");
        alert.setContentText("A registration field has been left empty or filled in incorrectly. Please try again.");
        alert.showAndWait();
    }

    private void showUserCreationFailureAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Registration Error");
        alert.setContentText("Failed to create a new user. Please try again.");
        alert.showAndWait();
    }

    private void goToLoginPage(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/views/LoginForm.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
