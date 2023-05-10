package com.example.expensetrackerjava.controller;

import com.example.expensetrackerjava.repository.DatabaseConnection;
import com.example.expensetrackerjava.repository.daos.ExpenseDao;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class AddExpensePageController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField titleField;

    @FXML
    private TextField descriptionField;

    @FXML
    private Spinner<Double> amountSpinner;

    @FXML
    private ComboBox categoryField;

    @FXML
    private ComboBox subCategoryField;

    private ExpenseDao expenseDao;

    public AddExpensePageController() {
        expenseDao = new ExpenseDao(DatabaseConnection.getInstance().getConnection());
    }

    @FXML
    public void initialize() {

    }

}
