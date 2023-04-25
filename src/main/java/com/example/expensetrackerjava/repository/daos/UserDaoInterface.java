package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.User;

import java.util.Optional;

public interface UserDaoInterface {

    boolean userCreated(User user);

    Optional<User> getUser(String username);

    boolean userUpdated(User user);

    boolean userDeleted(String username);
}
