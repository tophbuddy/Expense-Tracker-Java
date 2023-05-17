package com.example.expensetrackerjava.controller;

import com.example.expensetrackerjava.model.Category;
import com.example.expensetrackerjava.model.Expense;
import com.example.expensetrackerjava.model.User;
import com.example.expensetrackerjava.repository.DatabaseConnection;
import com.example.expensetrackerjava.repository.daos.CategoryDao;
import com.example.expensetrackerjava.repository.daos.ExpenseDao;
import com.example.expensetrackerjava.session.SessionManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

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
    private ComboBox<Category> categoryComboBox;

    @FXML
    private ComboBox<Category> subCategoryComboBox;

    @FXML
    private Button addExpenseButton;

    @FXML
    private Button goToExpensePageButton;

    private ExpenseDao expenseDao;

    private CategoryDao categoryDao;

    public AddExpensePageController() {
        expenseDao = new ExpenseDao(DatabaseConnection.getInstance().getConnection());
        categoryDao = new CategoryDao(DatabaseConnection.getInstance().getConnection());
    }

    @FXML
    public void initialize() {
        List<Category> categories = categoryDao.getAllCategories();
        categoryComboBox.setItems(FXCollections.observableArrayList(categories));
    }

    @FXML
    private void handleAddExpense(ActionEvent event) {
        String title = titleField.getText().trim();
        String description = descriptionField.getText().trim();
        double amount = amountSpinner.getValue();
        Category selectedCategory = categoryComboBox.getSelectionModel().getSelectedItem();
        String subCategoryName = subCategoryComboBox.getValue().getName();
        LocalDate date = datePicker.getValue();
        User currentUser = SessionManager.getInstance().getCurrentUser();

        if (currentUser == null) {
            showNullUserAlert();
            return;
        }

        int userId = currentUser.getUserId();
        Expense expense = new Expense(title, date, selectedCategory, description, amount, userId);

        boolean isExpenseAdded = expenseDao.createExpense(expense);
        if (isExpenseAdded) {
            showSuccessAlert();

        } else {
            showAddExpenseFailureAlert();
        }
    }

    private void showSuccessAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Expense Successfully Added");
        alert.setContentText("New expense successfully added.");
        alert.showAndWait();
    }

    private void showAddExpenseFailureAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Failure");
        alert.setHeaderText("Expense Not Added");
        alert.setContentText("Recorded expense was not successfully added. Please ensure that all fields were " +
                "properly filled out.");
        alert.showAndWait();
    }

    private void showNullUserAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("User Not Found");
        alert.setContentText("No current active user found, please re-login or reset application");
        alert.showAndWait();
    }
}
