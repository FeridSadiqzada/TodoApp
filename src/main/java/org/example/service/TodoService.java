package org.example.service;

import org.example.domain.Todo;
import org.example.repository.TodoRepository;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TodoService {

    private TodoRepository todoRepository;

    //POST
    public Todo saveCourse(Todo todo) {
        System.out.println(todo.toString());
        return todoRepository.save(todo);
    }

    //Optional!
    public List<Todo> saveCourses(List<Todo> todos) {
        return todoRepository.saveAll(todos);
    }

    //GET
    public List<Todo> getTodos() {
        return todosRepository.findAll();
    }
    public Todo getTodoById(UUID id) {
        return todoRepository.findById(id).orElse(null);
    }
    public Todo getTodoByTitle(String title) {
        return todoRepository.findByName(title);
    }
    public List<Todo> getTodoForUser(String status) {
        return todoRepository.findAllByStatus(status);
    }

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
        System.out.println("updates");
        Todo updaterecord = TodoRepository.findById(todo.getId()).orElse(null);
        updaterecord.setTitle(todo.getName());
        updaterecord.setDescription(todo.getDescription());
        updaterecord.setStatus(todo.getStatus());
        return todoRepository.save(updaterecord);
    }

    public List<Todo> readTasks(UUID id) {
        todoRepository.deleteById(id);
        return id + " id -> record removed/completed";
//        return repository.readTasks();
    }
}