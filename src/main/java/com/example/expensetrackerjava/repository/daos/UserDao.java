package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.User;
import com.example.expensetrackerjava.repository.DatabaseConnection;
import com.example.expensetrackerjava.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDao implements UserDaoInterface {

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean createUser(User user) {
        String insertUser = "INSERT INTO users (username, password, first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertUserStmt = connection.prepareStatement(insertUser)) {
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
        String selectUser = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement selectUserStmt = connection.prepareStatement(selectUser)) {
            selectUserStmt.setString(1, username);

            ResultSet resultSet = selectUserStmt.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean updateUser(User user) {
        String updateUserInfo = "UPDATE users SET password = ?, first_name = ?, last_name = ?, email = ?, phone_number = ?";
        try (PreparedStatement selectUserStmt = connection.prepareStatement(updateUserInfo)) {
            selectUserStmt.setString(1, user.getPassword());
            selectUserStmt.setString(2, user.getFirstName());
            selectUserStmt.setString(3, user.getLastName());
            selectUserStmt.setString(4, user.getEmail());
            selectUserStmt.setString(5, user.getPhone());

            int affectedRows = selectUserStmt.executeUpdate();
            return affectedRows > Constants.MIN_AFFECTED_ROWS;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(String username) {
        String deleteUser = "DELETE FROM users WHERE username = ?";
        try (PreparedStatement deleteUserStmt = connection.prepareStatement(deleteUser)) {
            deleteUserStmt.setString(1, username);

            int affectedRows = deleteUserStmt.executeUpdate();
            return affectedRows > Constants.MIN_AFFECTED_ROWS;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
