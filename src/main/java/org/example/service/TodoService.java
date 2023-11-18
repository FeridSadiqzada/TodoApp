package org.example.service;

import org.example.repository.Todo;

import java.util.List;
import java.util.Scanner;

public class TodoService {
    private List<Todo> todoList;

    public TodoService(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public void addTask(Scanner scanner) {
        // Your addTask logic here
    }

    public void deleteTask(Scanner scanner) {
        // Your deleteTask logic here
    }

    public void updateTask(Scanner scanner) {
        // Your updateTask logic here
    }

    public void readTasks() {
        // Your readTasks logic here
    }
}
