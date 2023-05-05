package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.Expense;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseDaoInterface {
    boolean createExpense(Expense expense);
    Expense getExpense(int expenseId);
    List<Expense> getAllExpenses(int userId);
    boolean updateExpense(Expense expense);
    boolean deleteExpense(int expenseId);
    List<Expense> searchExpenses(int userId, String title, LocalDate startDate, LocalDate endDate, String category, String keyword);
}
