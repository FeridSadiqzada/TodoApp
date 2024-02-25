package org.example.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@SuppressWarnings("ALL")
@Getter
public class User {
    UUID id;
    private String userName;
    private String password;
@Builder
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.id = UUID.randomUUID();
    }

}
