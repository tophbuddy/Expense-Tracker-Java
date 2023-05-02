package com.example.expensetrackerjava.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 */
public class Expense {

    // Using Simple JavaFX Properties for data binding and automatic UI updates when models change

    // need to add user variable for database storage

    private final SimpleIntegerProperty expenseId;
    private final SimpleObjectProperty<LocalDate> date;
    private final SimpleObjectProperty<Category> category;
    private final SimpleStringProperty description;
    private final SimpleDoubleProperty amount;
    private final SimpleIntegerProperty userId;

    public Expense(int expenseId, LocalDate date, Category category, String description, double amount, int userId) {
        this.expenseId = new SimpleIntegerProperty(expenseId);
        this.date = new SimpleObjectProperty<>(date);
        this.category = new SimpleObjectProperty<>(category);
        this.description = new SimpleStringProperty(description);
        this.amount = new SimpleDoubleProperty(amount);
        this.userId = new SimpleIntegerProperty(userId);
    }

    public Expense(LocalDate date, Category category, String description, double amount) {
        this.expenseId = new SimpleIntegerProperty(0);
        this.date = new SimpleObjectProperty<>(date);
        this.category = new SimpleObjectProperty<>(category);
        this.description = new SimpleStringProperty(description);
        this.amount = new SimpleDoubleProperty(amount);
        this.userId = new SimpleIntegerProperty(0);
    }

    public Expense() {
        this.expenseId = new SimpleIntegerProperty(0);
        this.date = new SimpleObjectProperty<LocalDate>(null);
        this.category = new SimpleObjectProperty<Category>(null);
        this.description = new SimpleStringProperty("");
        this.amount = new SimpleDoubleProperty(0.0);
        this.userId = new SimpleIntegerProperty(0);
    }

    public int getExpenseId() {
        return expenseId.get();
    }

    public SimpleIntegerProperty expenseIdProperty() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId.set(expenseId);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public Category getCategory() {
        return category.get();
    }

    public SimpleObjectProperty<Category> categoryProperty() {
        return category;
    }

    public void setCategory(Category category) {
        this.category.set(category);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public int getUserId() {
        return userId.get();
    }

    public SimpleIntegerProperty userIdProperty() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId.set(userId);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", date=" + date +
                ", category=" + category +
                ", description=" + description +
                ", amount=" + amount +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(expenseId, expense.expenseId) && Objects.equals(date, expense.date) &&
                Objects.equals(category, expense.category) && Objects.equals(description, expense.description) &&
                Objects.equals(amount, expense.amount) && Objects.equals(userId, expense.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId, date, category, description, amount, userId);
    }
}
