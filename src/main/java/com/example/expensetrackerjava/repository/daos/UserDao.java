package com.example.expensetrackerjava.repository.daos;

import com.example.expensetrackerjava.model.User;

import java.util.Optional;

public class UserDao implements UserDaoInterface{

    @Override
    public boolean userCreated(User user) {
        return false;
    }

    @Override
    public Optional<User> getUser(String username) {
        return Optional.empty();
    }

    @Override
    public boolean userUpdated(User user) {
        return false;
    }

    @Override
    public boolean userDeleted(String username) {
        return false;
    }
}
