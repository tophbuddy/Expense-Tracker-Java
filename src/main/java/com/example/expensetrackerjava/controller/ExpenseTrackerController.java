package com.example.expensetrackerjava.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ExpenseTrackerController {
    @FXML
    private Label testText;

    @FXML
    protected void onTestButtonClick() {
        testText.setText("Welcome to the Expense Tracker Application!");
    }
}