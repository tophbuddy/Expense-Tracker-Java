package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.User;
import com.example.expensetrackerjava.repository.DatabaseConnection;
import com.example.expensetrackerjava.utils.Constants;

import java.sql.*;
import java.util.Optional;

public class UserDao implements UserDaoInterface {

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean createUser(User user) {
        String insertUser = "INSERT INTO users (username, password, first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
        boolean isUserCreated = false;

        try (PreparedStatement insertUserStmt = connection.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS)) {
            insertUserStmt.setString(1, user.getUsername());
            insertUserStmt.setString(2, user.getPassword());
            insertUserStmt.setString(3, user.getFirstName());
            insertUserStmt.setString(4, user.getLastName());
            insertUserStmt.setString(5, user.getEmail());
            insertUserStmt.setString(6, user.getPhone());

            int affectedRows = insertUserStmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("User creation failed, no rows in the database affected");
            }

            try (ResultSet rs = insertUserStmt.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setUserId(rs.getInt(1));
                    isUserCreated = true;
                } else {
                    throw new SQLException("User creation failed, unable to obtain ID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return isUserCreated;
    }

    @Override
    public Optional<User> getUser(String username, String password) {
        String selectUser = "SELECT * FROM users WHERE username = ? AND password = ?";
        User user = null;

        try (PreparedStatement selectUserStmt = connection.prepareStatement(selectUser)) {
            selectUserStmt.setString(1, username);
            selectUserStmt.setString(2, password);

            ResultSet resultSet = selectUserStmt.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");

                user = new User(userId, username, password, firstName, lastName, email, phoneNumber);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public boolean updateUser(User user) {
        String updateUserInfo = "UPDATE users SET password = ?, first_name = ?, last_name = ?, email = ?, phone_number = ? WHERE user_id = ?";
        try (PreparedStatement updateUserStmt = connection.prepareStatement(updateUserInfo)) {
            updateUserStmt.setString(1, user.getPassword());
            updateUserStmt.setString(2, user.getFirstName());
            updateUserStmt.setString(3, user.getLastName());
            updateUserStmt.setString(4, user.getEmail());
            updateUserStmt.setString(5, user.getPhone());
            updateUserStmt.setInt(6, user.getUserId());

            int affectedRows = updateUserStmt.executeUpdate();
            return affectedRows > Constants.MIN_AFFECTED_ROWS;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        String deleteUser = "DELETE FROM users WHERE user_id = ? ";
        try (PreparedStatement deleteUserStmt = connection.prepareStatement(deleteUser)) {
            deleteUserStmt.setInt(1, id);

            int affectedRows = deleteUserStmt.executeUpdate();
            return affectedRows > Constants.MIN_AFFECTED_ROWS;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
