package org.example.domain;

import java.util.Scanner;
import java.util.UUID;

public class Todo {
    UUID id =UUID.randomUUID();
    private String title;
    private String description;
    private  UUID createdBy;
    private  UUID assignedTo;
    private  String status;
    private  String priority;
    private String created;
    public Todo(UUID id, String description, String status){};
    public Todo( UUID id,String title,String description,
                 UUID createdBy,
                 UUID assignedTo,String status,String priority,String created){
        this.id = id;
        this.assignedTo=assignedTo;
        this.created=created;
        this.createdBy=createdBy;
        this.priority=priority;
        this.description=description;
        this.status=status;
        this.title=title;

    };

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UUID assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCreated() {
        return created;
    }
    public String isCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                '}';
    }
}
