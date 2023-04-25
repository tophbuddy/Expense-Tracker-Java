package com.example.expensetrackerjava.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 */
public class Expense {


    // Categories will be: Housing, Transportation, Food, Utilities, Clothing, Medical/Healthcare, Insurance,
    // Household Items/Supplies, Personal, Debt, Retirement, Education, Savings, Gifts/Donations, Entertainment
    // Each will have example sub-categories. Will have option to add subcategories

    // Using Simple JavaFX Properties for data binding and automatic UI updates when models change

    // need to add user variable for database storage

    private final SimpleObjectProperty<LocalDate> date;
    private final SimpleStringProperty category;
    private final SimpleStringProperty subCategory;
    private final SimpleStringProperty description;
    private final SimpleDoubleProperty amount;

    public Expense(LocalDate date, String category, String subCategory, String description, double amount) {
        this.date = new SimpleObjectProperty<>(date);
        this.category = new SimpleStringProperty(category);
        this.subCategory = new SimpleStringProperty(subCategory);
        this.description = new SimpleStringProperty(description);
        this.amount = new SimpleDoubleProperty(amount);
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public SimpleStringProperty subCategoryProperty() {
        return subCategory;
    }

    public String getSubCategory() {
        return subCategory.get();
    }

    public void setSubCategory(String subCategory) {
        this.subCategory.set(subCategory);
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public SimpleDoubleProperty amountProperty() {
        return amount;
    }

    public double getAmount() {
        return amount.get();
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "date=" + date +
                ", category=" + category +
                ", subCategory=" + subCategory +
                ", description=" + description +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(date, expense.date) && Objects.equals(category, expense.category) &&
                Objects.equals(subCategory, expense.subCategory) && Objects.equals(description, expense.description) &&
                Objects.equals(amount, expense.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, category, subCategory, description, amount);
    }
}
