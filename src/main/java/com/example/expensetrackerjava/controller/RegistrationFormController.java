package com.example.expensetrackerjava.controller;

import com.example.expensetrackerjava.repository.DatabaseConnection;
import com.example.expensetrackerjava.repository.daos.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private void handleRegister(ActionEvent event) {

    }
}
