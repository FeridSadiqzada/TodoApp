package org.example.service;

import org.example.domain.Todo;
import org.example.repository.TodoRepository;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TodoService {

    private final TodoRepository repository;

  //   private TodoRepository todoRepository;

    private Scanner scanner = new Scanner(System.in);

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void addTask(Todo todo) {
            System.out.println("Enter id:");
            UUID id = UUID.fromString(scanner.nextLine());

            System.out.println("Enter title:");
            String title = scanner.nextLine();

            System.out.println("Enter description:");
            String description = scanner.nextLine();

            Todo newTodo = new Todo(id, title, description);
            repository.addTodo(newTodo);
        }
    public void deleteTask(Scanner scanner) {
        System.out.println("Enter the ID of the task you want to delete:");
        String idString = scanner.nextLine();
        UUID id = UUID.fromString(idString);

        repository.deleteTodo(id);
        System.out.println("Task deleted successfully.");

    }

       public void updateTask(Scanner scanner) {
            System.out.println("Enter the ID of the task you want to update:");
            String idString = scanner.nextLine();
            UUID id = UUID.fromString(idString);

            Todo existingTodo = repository.getTodoById(id).orElse(null);

            if (existingTodo != null) {
                System.out.println("Enter the new description:");
                String description = scanner.nextLine();

                System.out.println("Enter the new status:");
                String status = scanner.nextLine();

                Todo updatedTodo = new Todo(id, description, status);
                repository.updateTodo(id, updatedTodo);
                System.out.println("Task updated successfully.");
            } else {
                System.out.println("Task not found.");
            }
        }

    public List<Todo> readTasks() {

        return repository.readTasks();
    }
}