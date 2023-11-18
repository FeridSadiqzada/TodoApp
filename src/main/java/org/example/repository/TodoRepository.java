package org.example.repository;

import org.example.domain.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TodoRepository {
    private List<Todo> todoList = new ArrayList<>();


    public void addTask(Todo todo) {
        todoList.add(todo);
    }

    public void deleteTask(UUID id) {
        // Your deleteTask logic here
    }

    public void updateTask(UUID id, Todo todo) {
        // Your updateTask logic here
    }

    public List<Todo> readTasks() {
        return todoList;
    }
}
