package org.example.service;
import org.example.Main;
import org.example.domain.Database;
import org.example.domain.Status;
import org.example.domain.Todo;
import org.example.domain.User;
import org.example.repository.TodoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
public class TodoService {
    private static UserService userService;
    private static  TodoRepository todoRepository;
    private Scanner scanner = new Scanner(System.in);

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void addTask() {


        System.out.println("Enter assignedTo:");
        String assignedTo = scanner.nextLine();
        if (Database.USERS.stream().anyMatch(u -> u.getUserName().equals(u.getUserName()))) {
        } else {
            System.out.println("bele user yoxdur");
        }
            System.out.println("Enter title:");
            String title = scanner.nextLine();

            System.out.println("Enter description:");
            String description = scanner.nextLine();

            Todo newTodo = new Todo(assignedTo, title, description);
            todoRepository.addTodo(newTodo);
        }
    public void deleteTask(Scanner scanner) {
        System.out.println(todoRepository.getTodoList());
        System.out.println("Enter the ID of the task you want to delete:");
        String idString = scanner.nextLine();
        UUID id = UUID.fromString(idString);

        todoRepository.deleteTodo(id);
        System.out.println("Task deleted successfully.");

    }

       public void updateTask(Scanner scanner) {
           System.out.println(todoRepository.getTodoList());
            System.out.println("Enter the ID of the task you want to update:");
            String idString = scanner.nextLine();
            UUID id = UUID.fromString(idString);

            Todo existingTodo = todoRepository.getTodoById(id).orElse(null);

            if (existingTodo != null) {
                System.out.println("Enter the new description:");
                String description = scanner.nextLine();

                System.out.println("Enter the new status:");
                String status = scanner.nextLine();

                Todo updatedTodo = new Todo(  description, status);
                todoRepository.updateTodo(id, updatedTodo);
                System.out.println("Task updated successfully.");
            } else {
                System.out.println("Task not found.");
            }
        }
    public List<Todo> readTasks() {
        List<Todo> tasks = todoRepository.readTasks();
        tasks.forEach(t->{
            System.out.println("id: "+ t.getId() +" assignedTo: " +t.getAssignedTo()+" Title: " +t.getTitle() + "," +  "Description: " + t.getDescription()+"  createdBy: "+ t.getCreatedBy());
        });
        return todoRepository.readTasks();
    }
}