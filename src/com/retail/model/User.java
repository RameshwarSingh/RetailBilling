package com.retail.model;

import java.time.LocalDateTime;

/**
 *
 */
public class User {

    private int Id;

    private String name;

    private LocalDateTime registrationDate;

    private UserType userType;

    public enum UserType {
        CUSTOMER,
        EMPLOYEE,
        AFFILIATE
    }

    public User(int id, String name, LocalDateTime registrationDate, UserType userType) {
        Id = id;
        this.name = name;
        this.registrationDate = registrationDate;
        this.userType = userType;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public UserType getUserType() {
        return userType;
    }
}
