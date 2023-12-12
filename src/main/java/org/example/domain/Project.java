package org.example.domain;

import java.util.UUID;

public class Project {

    UUID id;
    String description;
    String title;
    String createdAt;

    public Project(UUID id, String title) {
        this.id=id;
        this.title=title;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
