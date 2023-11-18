package org.example.controller;

import org.example.service.TodoService;

import java.util.Scanner;

public class TodoController {
    private TodoService todoService;
    private Scanner scanner = new Scanner(System.in);

    public TodoController(TodoService todoService) {
        this.todoService = todoService;

    }

    public void run() {
        int choice;
        do {
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Update Task");
            System.out.println("4. Read Tasks");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    todoService.addTask(scanner);
                    break;
                case 2:
                    todoService.deleteTask(scanner);
                    break;
                case 3:
                    todoService.updateTask(scanner);
                    break;
                case 4:
                    todoService.readTasks();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}

