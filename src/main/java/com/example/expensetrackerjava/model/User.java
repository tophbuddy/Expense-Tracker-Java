package com.example.expensetrackerjava.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

public class User {
    private final SimpleIntegerProperty userId;
    private final SimpleStringProperty username;
    private final SimpleStringProperty password;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;
    private final SimpleStringProperty phone;

    public User(int userId, String username, String password, String firstName, String lastName, String email, String phone) {
        this.userId = new SimpleIntegerProperty(userId);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
    }

    public User() {
        this.userId = new SimpleIntegerProperty(0);
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.firstName = new SimpleStringProperty("");
        this.lastName = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.phone = new SimpleStringProperty("");
    }

    public User(String username, String password, String firstName, String lastName, String email, String phone) {
        this.userId = new SimpleIntegerProperty(0);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
    }

    public int getUserId() {
        return userId.get();
    }

    public SimpleIntegerProperty userIdProperty() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId.set(userId);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username=" + username +
                ", password=" + password +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", phone=" + phone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, firstName, lastName, email, phone);
    }
}
