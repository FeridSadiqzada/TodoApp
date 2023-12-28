package org.example.domain;

import java.util.UUID;

public class User {
    UUID id;
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.id=UUID.randomUUID();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
