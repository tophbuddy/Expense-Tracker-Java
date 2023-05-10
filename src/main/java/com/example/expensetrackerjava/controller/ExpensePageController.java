package com.example.expensetrackerjava.controller;

import com.example.expensetrackerjava.ExpenseTrackerApplication;
import com.example.expensetrackerjava.model.Expense;
import com.example.expensetrackerjava.repository.DatabaseConnection;
import com.example.expensetrackerjava.repository.daos.ExpenseDao;
import com.example.expensetrackerjava.session.SessionManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ExpensePageController {
    @FXML
    private TableView<Expense> expenseTableView;

    @FXML
    private TableColumn<Expense, Integer> idColumn;

    @FXML
    private TableColumn<Expense, String> titleColumn;

    @FXML
    private TableColumn<Expense, LocalDate> dateColumn;

    @FXML
    private TableColumn<Expense, String> categoryColumn;

    @FXML
    private TableColumn<Expense, String> subCategoryColumn;

    @FXML
    private TableColumn<Expense, String> descriptionColumn;

    @FXML
    private TableColumn<Expense, Double> amountColumn;

    @FXML
    private Button homePageButton;

    private ObservableList<Expense> expenses;

    private ExpenseDao expenseDao;

    public ExpensePageController() {
        expenseDao = new ExpenseDao(DatabaseConnection.getInstance().getConnection());
    }

    @FXML
    public void initialize() {
//        expenses.add(new Expense(LocalDate.of(2023,4,2), "Food", "Groceries",
//                "Grocery shopping for dinner", 104.50));
//        expenses.add(new Expense(LocalDate.of(2023,4,7), "Housing", "Mortgage",
//                "Monthly Mortgage payment to Wells Fargo", 4200.80));
//        expenses.add(new Expense(LocalDate.of(2023,4,14), "Personal", "Haircut",
//                "Bottle and the Barber haircut", 50.75));
//        expenses.add(new Expense(LocalDate.of(2023,4,22), "Entertainment", "Alcohol",
//                "Drinks at Rumba", 64.20));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        subCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("subCategory"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        loadCurrentUserExpenses();
    }

    @FXML
    private void goToHomePage(ActionEvent event){
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
            ExpenseTrackerApplication.getInstance().showHomePage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddExpense(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        ExpenseTrackerApplication.getInstance().showAddExpensePage();
    }

    @FXML
    private void handleUpdateExpense() {

    }

    @FXML
    private void handleDeleteExpense() {

    }

    private void loadCurrentUserExpenses() {
        int userId = SessionManager.getInstance().getCurrentUser().getUserId();
        expenses = FXCollections.observableArrayList(expenseDao.getAllExpenses(userId));
        expenseTableView.setItems(expenses);
    }
}
