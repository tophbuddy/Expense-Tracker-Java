package com.example.expensetrackerjava.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExpensePageController {
    @FXML
    private void goToHomePage(ActionEvent event){
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            stage.setScene(new Scene(root, 300, 200));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
