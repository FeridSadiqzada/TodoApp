package org.example;
import org.example.controller.TodoController;
import org.example.repository.TodoRepository;
import org.example.service.TodoService;



public class Main {
    public static void main(String[] args) {
        new Main().todoController.run();
    }
    TodoRepository repository = new TodoRepository();
    TodoService todoService = new TodoService(repository);
    TodoController todoController = new TodoController(todoService);




}