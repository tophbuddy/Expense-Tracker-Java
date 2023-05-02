package com.example.expensetrackerjava.controller;

import com.example.expensetrackerjava.ExpenseTrackerApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomePageController {

    @FXML
    private Button expensePageButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button registrationButton;

    @FXML
    public void initialize() {
//        expensePageButton.setOnAction(event -> goToExpensePage());
        registrationButton.setOnAction(this::goToRegistrationPage);
        loginButton.setOnAction(this::goToLoginPage);
    }

    @FXML
    private void goToLoginPage(ActionEvent event) {
        ExpenseTrackerApplication.getInstance().showLoginPage();
    }

    @FXML
    private void goToRegistrationPage(ActionEvent event) {
        ExpenseTrackerApplication.getInstance().showRegistrationPage();
    }


//    @FXML
//    private void goToExpensePage() {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ExpensePage.fxml"));
//            Parent root = loader.load();
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.setTitle("Expense Page");
//            stage.show();
//
//            // Close the current (home) stage
//            Stage homeStage = (Stage) expensePageButton.getScene().getWindow();
//            homeStage.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
