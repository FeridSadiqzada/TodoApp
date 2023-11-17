package org.example;
import org.example.models.TodoApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {


    private static TodoApp todoList;

    public static void main(String[] args) {
        List<TodoApp> todoList = new ArrayList<>();
        ShowMethods();
        getFromUser();
    }


    public static void ShowMethods() {
        System.out.println("1: Add");
        System.out.println("2: Delete");
        System.out.println("3: Update");
        System.out.println("4: Read");
    }

    public static void getFromUser() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your operation: ");
            int opNumber = scanner.nextInt();

            switch (opNumber) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    deleteTask(scanner);
                    break;
                case 3:
                    updateTask(scanner);
                    break;
                case 4:
                    readTasks();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }

            // Close the scanner
            scanner.close();

        } catch (Exception e) {
            System.out.println("Invalid input!");
            getFromUser();
        }
    }

    private static void addTask(Scanner scanner) {

        TodoApp newTask = new TodoApp();
        newTask.setId(todoList.size() + 1);
        System.out.print("Enter Title: ");
        newTask.setTitle(scanner.next());
        System.out.print("Enter Description: ");
        newTask.setDescription(scanner.next());
        System.out.print("Enter CreatedBy: ");
        newTask.setCreatedBy(scanner.next());
        System.out.print("Enter AssignedTo: ");
        newTask.setAssignedTo(scanner.next());
        System.out.print("Enter Status: ");
        newTask.setStatus(scanner.next());
        System.out.print("Enter Priority: ");
        newTask.setPriority(scanner.next());
        System.out.print("Enter Created: ");
        newTask.setCreated(scanner.next());

        todoList.add(newTask);
        System.out.println("Task added successfully!");
    }

    private static void deleteTask(Scanner scanner) {
        readTasks();

        System.out.print("Enter the ID of the task to delete: ");
        int taskId = scanner.nextInt();

        todoList.removeIf(task -> task.getId() == taskId);

        System.out.println("Task deleted successfully!");
    }

    private static void updateTask(Scanner scanner) {
        readTasks();

        System.out.print("Enter the ID of the task to update: ");
        int taskId = scanner.nextInt();

        TodoApp taskToUpdate = todoList.stream()
                .filter(task -> task.getId() == taskId)
                .findFirst()
                .orElse(null);

        if (taskToUpdate != null) {
            System.out.print("Enter new Title: ");
            taskToUpdate.setTitle(scanner.next());
            System.out.print("Enter new Description: ");
            taskToUpdate.setDescription(scanner.next());

            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Task not found with ID: " + taskId);
        }
    }

    private static void readTasks() {
        if (todoList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Task List:");
            for (TodoApp task : todoList) {
                System.out.println(task);
            }
        }
    }
}


