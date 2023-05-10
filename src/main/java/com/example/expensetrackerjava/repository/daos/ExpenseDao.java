package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.Category;
import com.example.expensetrackerjava.model.Expense;
import com.example.expensetrackerjava.repository.DatabaseConnection;
import com.example.expensetrackerjava.utils.Constants;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao implements ExpenseDaoInterface {

    private Connection connection;

    public ExpenseDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean createExpense(Expense expense) {
        String insertExpense = "INSERT INTO expenses (user_id, title, date, description, category_id, amount) VALUES (?, ?, ?, ?, ?)";
        boolean isExpenseCreated = false;

        try (PreparedStatement insertExpenseStatement = connection.prepareStatement(insertExpense, Statement.RETURN_GENERATED_KEYS)){
            insertExpenseStatement.setInt(1, expense.getUserId());
            insertExpenseStatement.setString(2, expense.getTitle());
            insertExpenseStatement.setDate(3, Date.valueOf(expense.getDate()));
            insertExpenseStatement.setString(4, expense.getDescription());
            insertExpenseStatement.setInt(5, expense.getCategory().getCategoryId());
            insertExpenseStatement.setDouble(6, expense.getAmount());

            int affectedRows = insertExpenseStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return isExpenseCreated;
    }

    @Override
    public Expense getExpense(int expenseId) {
        String getExpense = "SELECT * FROM expenses WHERE id = ?";
        Expense expense = null;

        try (PreparedStatement getExpenseStmt = connection.prepareStatement(getExpense)) {
            getExpenseStmt.setInt(1, expenseId);

            try (ResultSet rs = getExpenseStmt.executeQuery();) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    int categoryId = rs.getInt("category_id");
                    String title = rs.getString("title");
                    LocalDate date = rs.getDate("date").toLocalDate();
                    String description = rs.getString("description");
                    double amount = rs.getDouble("amount");

                    Category category = getCategoryById(categoryId);
                    expense = new Expense(expenseId, title, date, category, description, amount, userId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expense;
    }

    @Override
    public List<Expense> getAllExpenses(int userId) {
        List<Expense> expenses = new ArrayList<>();
        String getExpenses = "SELECT * FROM expenses WHERE user_id = ? ORDER BY date";
        try (PreparedStatement getExpensesStmt = connection.prepareStatement(getExpenses)) {
            getExpensesStmt.setInt(1, userId);
            ResultSet rs = getExpensesStmt.executeQuery();

            while (rs.next()) {
                int expenseId = rs.getInt("id");
                String title = rs.getString("title");
                LocalDate date = rs.getDate("date").toLocalDate();
                String description = rs.getString("description");
                int categoryId = rs.getInt("category_id");
                double amount = rs.getDouble("amount");
                int resultUserId = rs.getInt("user_id");

                Category category = getCategoryById(categoryId);
                Expense expense = new Expense(expenseId, title, date, category,description, amount, resultUserId);
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public boolean updateExpense(Expense expense) {
        String updateExpense = "UPDATE expenses SET title = ?, date = ?, description = ?, category_id = ?, amount = ?";
        try (PreparedStatement updateExpenseStmt = connection.prepareStatement(updateExpense)) {
            updateExpenseStmt.setString(1, expense.getTitle());
            updateExpenseStmt.setDate(2, Date.valueOf(expense.getDate()));
            updateExpenseStmt.setString(3, expense.getDescription());
            updateExpenseStmt.setInt(4, expense.getCategory().getCategoryId());
            updateExpenseStmt.setDouble(5, expense.getAmount());

            int affectedRows = updateExpenseStmt.executeUpdate();
            return affectedRows > Constants.MIN_AFFECTED_ROWS;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteExpense(int expenseId) {
        String deleteExpense = "DELETE FROM expenses WHERE id = ?";

        try (PreparedStatement deleteExpenseStmt = connection.prepareStatement(deleteExpense)) {
            deleteExpenseStmt.setInt(1, expenseId);

            int affectedRows = deleteExpenseStmt.executeUpdate();
            return affectedRows > Constants.MIN_AFFECTED_ROWS;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Expense> searchExpenses(int userId, String title, LocalDate startDate, LocalDate endDate,
                                        String category, String keyword) {
        return null;
    }

    private Category getCategoryById(int categoryId) {
        Category category = null;
        String getCategory = "SELECT * FROM categories WHERE id = ?";
        try (PreparedStatement getCategoryStmt = connection.prepareStatement(getCategory)) {
            getCategoryStmt.setInt(1, categoryId);
            try (ResultSet rs = getCategoryStmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String categoryName = rs.getString("category_name");
                    String subCategoryName = rs.getString("sub_category_name");
                    category = new Category(id, categoryName, subCategoryName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }
}
