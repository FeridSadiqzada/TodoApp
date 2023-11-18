package org.example.repository;
import org.example.controller.TodoController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.example.service.TodoService;



public class Main {
            List<Todo> todoList = new ArrayList<>();

            TodoService todoService = new TodoService(todoList);
    TodoController todoController = new TodoController(todoService, new Scanner(System.in));

        todoController.run();

}


