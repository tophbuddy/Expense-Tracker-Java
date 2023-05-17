package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements CategoryDaoInterface{

    private Connection connection;

    public CategoryDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String getCategories = "SELECT * FROM categories";

        try (PreparedStatement getCategoriesStmt = connection.prepareStatement(getCategories)) {
            try (ResultSet rs = getCategoriesStmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("category_name");
                    String subCategoryName = rs.getString("sub_category_name");

                    Category category = new Category(id, name, subCategoryName);
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        Category category = null;
        String getCategory = "SELECT * FROM categories WHERE id = ?";

        try (PreparedStatement getCategoryStmt = connection.prepareStatement(getCategory)) {
            getCategoryStmt.setInt(1, id);
            try (ResultSet rs = getCategoryStmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("category_name");
                    String subCategoryName = rs.getString("sub_category_name");
                    category = new Category(id, name, subCategoryName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
