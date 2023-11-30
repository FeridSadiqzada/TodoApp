package org.example.domain;

import java.util.UUID;

public class User {
    UUID id;
    private String userName;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.id=UUID.randomUUID();
    }

    private String password;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
