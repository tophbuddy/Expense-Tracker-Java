package com.example.expensetrackerjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExpenseTrackerApplication extends Application {

    private static ExpenseTrackerApplication instance;
    private Stage primaryStage;

    public ExpenseTrackerApplication() {
        instance = this;
    }

    public static ExpenseTrackerApplication getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        showHomePage();
    }

    public void showHomePage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HomePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Expense Tracker");
        primaryStage.show();
    }

    public void showExpensePage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ExpensePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Expense Tracker");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}