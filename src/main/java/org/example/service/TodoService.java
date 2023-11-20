package org.example.service;

import org.example.domain.Todo;
import org.example.repository.TodoRepository;

import java.util.List;
import java.util.Scanner;

public class TodoService {
    private Scanner scanner = new Scanner(System.in);
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void addTask(Todo todo) {
        System.out.println("enter id");
       int  ch = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter title");
       int ch1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter description");
       int ch2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter status");
        int ch3 = scanner.nextInt();
        scanner.nextLine();

//        repository.addTask(todo);

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