package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.Expense;

import java.time.LocalDate;
import java.util.List;

public class ExpenseDao implements ExpenseDaoInterface{

    @Override
    public boolean createExpense(Expense expense) {
        return false;
    }

    @Override
    public Expense getExpense(int expenseId) {
        return null;
    }

    @Override
    public List<Expense> getAllExpenses(int userId) {
        return null;
    }

    @Override
    public boolean updateExpense(Expense expense) {
        return false;
    }

    @Override
    public boolean deleteExpense(int expenseId) {
        return false;
    }

    @Override
    public List<Expense> searchExpenses(int userId, LocalDate startDate, LocalDate endDate, String category, String keyword) {
        return null;
    }
}
