package org.example;
import org.example.controller.TodoController;
import org.example.repository.TodoRepository;
import org.example.service.TodoService;
import org.example.service.UserService;


public class Main {
    TodoRepository repository = new TodoRepository();
    TodoService todoService = new TodoService(repository);
    UserService userService=new UserService();
    public TodoController todoController = new TodoController(todoService);

    public static void main(String[] args) {
        new Main().userService.loging();

    }


}