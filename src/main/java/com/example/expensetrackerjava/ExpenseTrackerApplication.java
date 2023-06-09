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
        primaryStage.setTitle("Expense Tracker Home");
        primaryStage.show();
    }

    public void showExpensePage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ExpensePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Expenses");
        primaryStage.show();
    }

    public void showLoginPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LoginForm.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Expense Tracker Login");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRegistrationPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/RegistrationForm.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Expense Tracker Account Registration");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAddExpensePage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/AddExpensePage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Add New Expense");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}