package com.example.expensetrackerjava.controller;

import com.example.expensetrackerjava.ExpenseTrackerApplication;
import com.example.expensetrackerjava.model.User;
import com.example.expensetrackerjava.repository.DatabaseConnection;
import com.example.expensetrackerjava.repository.daos.UserDao;
import com.example.expensetrackerjava.repository.daos.UserDaoInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LoginFormController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginStatusLabel;

    private UserDao userDao;

    public LoginFormController() {
        userDao = new UserDao(DatabaseConnection.getInstance().getConnection());
    }

    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty()) {
            loginStatusLabel.setText("Please enter your username");
            return;
        }
        if (password.isEmpty()) {
            loginStatusLabel.setText("Please enter your password");
            return;
        }

        Optional<User> optionalUser = userDao.getUser(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                loginStatusLabel.setText("Login successful");
                goToHomePage(event);
            } else {
                loginStatusLabel.setText("Password is incorrect. Please try again.");
            }
        } else {
            loginStatusLabel.setText("User not found. Please try again.");
        }
    }

    private void goToHomePage(ActionEvent event){
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
            ExpenseTrackerApplication.getInstance().showHomePage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
