package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.User;

import java.sql.Connection;
import java.util.Optional;

public interface UserDaoInterface {

    boolean createUser(User user);

    Optional<User> getUser(String username);

    boolean updateUser(User user);

    boolean deleteUser(String username);
}
