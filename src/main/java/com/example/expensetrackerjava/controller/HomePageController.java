package com.example.expensetrackerjava.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML
    private Button goToExpensePageButton;

    @FXML
    public void initialize() {
        AnchorPane.setTopAnchor(goToExpensePageButton, 100.0);
        AnchorPane.setLeftAnchor(goToExpensePageButton, 100.0);
    }

    @FXML
    private void goToExpensePage(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("ExpensePage.fxml"));
            stage.setScene(new Scene(root, 300, 200));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
