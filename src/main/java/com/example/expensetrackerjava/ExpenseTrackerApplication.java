package com.example.expensetrackerjava;

import com.example.expensetrackerjava.model.Expense;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ExpenseTrackerApplication extends Application {
    private TableView<Expense> table = new TableView<>();
    private final ObservableList<Expense> data = FXCollections.observableArrayList(
            new Expense(LocalDate.of(2023,4,2), "Food", "Groceries",
                    "Grocery shopping for dinner", 104.50),
            new Expense(LocalDate.of(2023,4,7), "Housing", "Mortgage",
                    "Monthly Mortgage payment to Wells Fargo", 4200.80),
            new Expense(LocalDate.of(2023,4,14), "Personal", "Haircut",
                    "Bottle and the Barber haircut", 50.75),
            new Expense(LocalDate.of(2023,4,22), "Entertainment", "Alcohol",
                    "Drinks at Rumba", 64.20)
    );

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ExpenseTrackerApplication.class.getResource("expense-tracker-main-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        primaryStage.setTitle("Expense Tracker");

        TableColumn<Expense, LocalDate> dateColumn = new TableColumn<>("Date");
        TableColumn<Expense, String> categoryColumn = new TableColumn<>("Category");
        TableColumn<Expense, String> subCategoryColumn = new TableColumn<>("Sub-Category");
        TableColumn<Expense, String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<Expense, Double> amountColumn = new TableColumn<>("Amount");

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        subCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("subCategory"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        table.getColumns().addAll(dateColumn, categoryColumn, subCategoryColumn, descriptionColumn, amountColumn);
        table.setItems(data);

        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");

        Label statusBar = new Label("Ready");
        statusBar.setStyle("-fx-background-color: lightgray");

        HBox buttonBox = new HBox(10, addButton, deleteButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10, 0, 0, 0));

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setTop(table);
        root.setCenter(buttonBox);
        root.setBottom(statusBar);


        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}