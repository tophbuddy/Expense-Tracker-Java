package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.User;
import com.example.expensetrackerjava.repository.DatabaseConnection;
import com.example.expensetrackerjava.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao implements UserDaoInterface {

    @Override
    public boolean createUser(User user) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String insertUser = "INSERT INTO users (username, password, first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertUserStmt = connection.prepareStatement(insertUser);
            insertUserStmt.setString(1, user.getUsername());
            insertUserStmt.setString(2, user.getPassword());
            insertUserStmt.setString(3, user.getFirstName());
            insertUserStmt.setString(4, user.getLastName());
            insertUserStmt.setString(5, user.getEmail());
            insertUserStmt.setString(6, user.getPhone());

            int affectedRows = insertUserStmt.executeUpdate();
            return affectedRows > Constants.MIN_AFFECTED_ROWS;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<User> getUser(String username) {
        try (Connection connection = DatabaseConnection.getConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean updateUser(User user) {
        try (Connection connection = DatabaseConnection.getConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(String username) {
        try (Connection connection = DatabaseConnection.getConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
