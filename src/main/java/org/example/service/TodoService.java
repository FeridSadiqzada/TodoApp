package org.example.service;

import org.example.domain.Todo;
import org.example.repository.TodoRepository;

import java.util.List;
import java.util.Scanner;

public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void addTask(Todo todo) {
        repository.addTask(todo);
    }

    public void deleteTask(Scanner scanner) {
        // Your deleteTask logic here
    }

    public void updateTask(Scanner scanner) {
        // Your updateTask logic here
    }

    public List<Todo> readTasks() {
        return repository.readTasks();
    }
}