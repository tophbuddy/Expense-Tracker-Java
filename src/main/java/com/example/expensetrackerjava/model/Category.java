package com.example.expensetrackerjava.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class Category {

    // Categories will be: Housing, Transportation, Food, Utilities, Clothing, Medical/Healthcare, Insurance,
    // Household Items/Supplies, Personal, Debt, Retirement, Education, Savings, Gifts/Donations, Entertainment
    // Each will have example sub-categories. Will have option to add subcategories

    private final SimpleIntegerProperty categoryId;
    private final SimpleStringProperty name;
    private final SimpleStringProperty subCategory;

    public Category(int categoryId, String name, String subCategory) {
        this.categoryId = new SimpleIntegerProperty(categoryId);
        this.name = new SimpleStringProperty(name);
        this.subCategory = new SimpleStringProperty(subCategory);
    }

    public int getCategoryId() {
        return categoryId.get();
    }

    public SimpleIntegerProperty categoryIdProperty() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId.set(categoryId);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSubCategory() {
        return subCategory.get();
    }

    public SimpleStringProperty subCategoryProperty() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory.set(subCategory);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name=" + name +
                ", subCategory=" + subCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) && Objects.equals(name, category.name) &&
                Objects.equals(subCategory, category.subCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, subCategory);
    }
}
