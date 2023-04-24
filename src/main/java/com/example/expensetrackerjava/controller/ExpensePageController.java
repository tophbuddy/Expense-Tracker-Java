package com.example.expensetrackerjava.controller;

import com.example.expensetrackerjava.ExpenseTrackerApplication;
import com.example.expensetrackerjava.model.Expense;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;

public class ExpensePageController {
    @FXML
    private TableView<Expense> expenseTable = new TableView<>();

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

    @FXML
    public void initialize() {

        expenses = FXCollections.observableArrayList();
        expenses.add(new Expense(LocalDate.of(2023,4,2), "Food", "Groceries",
                "Grocery shopping for dinner", 104.50));
        expenses.add(new Expense(LocalDate.of(2023,4,7), "Housing", "Mortgage",
                "Monthly Mortgage payment to Wells Fargo", 4200.80));
        expenses.add(new Expense(LocalDate.of(2023,4,14), "Personal", "Haircut",
                "Bottle and the Barber haircut", 50.75));
        expenses.add(new Expense(LocalDate.of(2023,4,22), "Entertainment", "Alcohol",
                "Drinks at Rumba", 64.20));

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        subCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("subCategory"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

//        ObservableList<Expense> data = FXCollections.observableArrayList(
//                new Expense(LocalDate.of(2023,4,2), "Food", "Groceries",
//                        "Grocery shopping for dinner", 104.50),
//                new Expense(LocalDate.of(2023,4,7), "Housing", "Mortgage",
//                        "Monthly Mortgage payment to Wells Fargo", 4200.80),
//                new Expense(LocalDate.of(2023,4,14), "Personal", "Haircut",
//                        "Bottle and the Barber haircut", 50.75),
//                new Expense(LocalDate.of(2023,4,22), "Entertainment", "Alcohol",
//                        "Drinks at Rumba", 64.20)
//        );

        expenseTable.setItems(expenses);
    }

    @FXML
    private void goToHomePage(ActionEvent event){
        try {
            ExpenseTrackerApplication.getInstance().showHomePage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
