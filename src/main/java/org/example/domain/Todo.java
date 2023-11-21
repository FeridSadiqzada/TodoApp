package org.example.domain;

import java.util.UUID;

public class Todo {
    UUID id =UUID.randomUUID();
    private String title;
    private String description;
    private  String createdBy;
    private String assignedTo;
    private  String status;
    private  String priority;
    private String created;
    public Todo(){};
    public Todo( UUID id,String title,String description,String createdBy,String assignedTo,String status,String priority,String created){
        this.id = id;
        this.assignedTo=assignedTo;
        this.created=created;
        this.createdBy=createdBy;
        this.priority=priority;
        this.description=description;
        this.status=status;
        this.title=title;

    };

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

    public String getCreatedBy() {
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

    public void setCreated(String created) {
        this.created = created;
    }


}
