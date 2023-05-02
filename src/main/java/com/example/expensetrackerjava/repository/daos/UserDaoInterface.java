package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.User;

import java.sql.Connection;
import java.util.Optional;

public interface UserDaoInterface {

    boolean createUser(User user);

    Optional<User> getUser(String username, String password);

    boolean updateUser(User user);

    boolean deleteUser(int id);
}
