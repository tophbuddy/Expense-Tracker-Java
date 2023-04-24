package com.example.expensetrackerjava.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML
    private Button expensePageButton;

    @FXML
    public void initialize() {
        expensePageButton.setOnAction(event -> goToExpensePage());
        AnchorPane.setTopAnchor(expensePageButton, 100.0);
        AnchorPane.setLeftAnchor(expensePageButton, 100.0);
    }

    @FXML
    private void goToExpensePage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ExpensePage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Expense Page");
            stage.show();

            // Close the current (home) stage
            Stage homeStage = (Stage) expensePageButton.getScene().getWindow();
            homeStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
