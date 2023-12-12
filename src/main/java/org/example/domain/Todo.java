package org.example.domain;

import java.util.UUID;

import static org.example.domain.Session.currentUserName;

public class Todo {

    UUID id;
    private String projectİD;

    private String title;
    private String description;
    private String createdBy;
    private String assignedTo;
    private Status status;
    private String priority;
    private String created;

    public Todo(String description, Status status) {
        this.description=description;
        this.status=status;
    }
    public Todo(String updatedDescription){
        this.description=updatedDescription;
    }
    public Todo(Status updateStatsu){
        this.status=updateStatsu;
    }
    public Todo(String assignedTo,String title, String description) {
        this.title = title;
        this.description = description;
        this.id = UUID.randomUUID();
        this.assignedTo=assignedTo;
        this.createdBy=currentUserName;
    };
    public Todo(String title, String description, String createdBy, String assignedTo, Status status, String priority, String created) {
        this.id = UUID.randomUUID();
        this.assignedTo = assignedTo;
        this.created = created;
        this.createdBy = createdBy;
        this.priority = priority;
        this.description = description;
        this.status = status;
        this.title = title;
    };
//   public Todo(String createdBy){
//       this.createdBy=currentUserName;
//   }
    public Todo(String description, String status) {
    }

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

    public String  getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
