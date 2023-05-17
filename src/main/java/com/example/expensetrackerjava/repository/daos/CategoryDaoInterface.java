package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.Category;

import java.util.List;

public interface CategoryDaoInterface {

    List<Category> getAllCategories();
    Category getCategoryById(int id);

}
