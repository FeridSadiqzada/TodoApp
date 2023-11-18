package org.example;
import org.example.controller.TodoController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.domain.Todo;
import org.example.service.TodoService;



public class Main {
    List<Todo> todoList = new ArrayList<>();

    TodoService todoService = new TodoService(todoList);
    TodoController todoController = new TodoController(todoService, new Scanner(System.in));

    public static void main(String[] args) {
        new Main().todoController.run();
    }


}


