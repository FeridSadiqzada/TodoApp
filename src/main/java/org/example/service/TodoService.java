package org.example.service;

import org.example.domain.Todo;
import org.example.repository.TodoRepository;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TodoService {

    private TodoRepository todoRepository;

    private Scanner scanner = new Scanner(System.in);
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void addTask(Todo todo) {


        System.out.println("enter id");
        String  ch = scanner.nextLine();
        scanner.nextLine();
        System.out.println("enter title");
        String ch1 = scanner.nextLine();
        scanner.nextLine();
        System.out.println("enter description");
        String ch2 = scanner.nextLine();
        scanner.nextLine();
        System.out.println("enter status");
        String ch3 = scanner.nextLine();
        scanner.nextLine();

//        repository.addTask(todo);

    }

    public void deleteTask(Scanner scanner) {
        // Your deleteTask logic here
    }

    public void updateTask(Scanner scanner) {

    }

    public List<Todo> readTasks(UUID id) {
//
        return repository.readTasks();
    }
}