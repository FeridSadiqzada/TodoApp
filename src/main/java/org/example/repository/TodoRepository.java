package org.example.repository;
import org.example.domain.Todo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class TodoRepository   {

    private final List<Todo> todoList = new ArrayList<>();

    public void addTodo(Todo todo) {
        todoList.add(todo);
    }

    public void deleteTodo(UUID id) {

       }
    public void updateTodo(UUID uuid, Todo todo) {

    }
    public List<Todo> readTasks() {
        return todoList;
    }
}