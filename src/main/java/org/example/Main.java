package org.example;
import org.example.controller.TodoController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.domain.Todo;
import org.example.repository.TodoRepository;
import org.example.service.TodoService;
import org.example.service.UserService;


public class Main {
    //    List<Todo> todoList = new ArrayList<>();
    TodoRepository repository = new TodoRepository();
    TodoService todoService = new TodoService(repository);
    UserService userService=new UserService();
    TodoController todoController = new TodoController(todoService);

    public static void main(String[] args) {
        new Main().userService.loging();
        new Main().todoController.run();
    }


}