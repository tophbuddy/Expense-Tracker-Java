package com.example.expensetrackerjava.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 */
public class Expense {


    // Categories will be: Housing, Transportation, Food, Utilities, Clothing, Medical/Healthcare, Insurance,
    // Household Items/Supplies, Personal, Debt, Retirement, Education, Savings, Gifts/Donations, Entertainment
    // Each will have example sub-categories. Will have option to add subcategories

    private LocalDate date;
    private String category;
    private String subCategory;
    private String description;
    private double amount;

    public Expense(LocalDate date, String category, String subCategory, String description, double amount) {
        this.date = date;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "date=" + date +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Double.compare(expense.amount, amount) == 0 && Objects.equals(date, expense.date) &&
                Objects.equals(category, expense.category) && Objects.equals(subCategory, expense.subCategory) &&
                Objects.equals(description, expense.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, category, subCategory, description, amount);
    }
}
