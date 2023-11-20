package org.example.repository;
import org.example.domain.Todo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static jdk.internal.org.jline.utils.ShutdownHooks.tasks;


public class TodoRepository  {
    private final List<Todo> todoList = new ArrayList<>();


    public void addTask(Todo todo) {
        todoList.add(todo);
    }

    public void deleteTask(UUID id) {
        if (tasks.containsKey(id)) {
            Todo deletedTask = tasks.remove(id);
            System.out.println("Task deleted: " + deletedTask);
        } else {
            System.out.println( " not found. No task deleted.");
        }    }

    public void updateTask(UUID id, Todo todo) {
        if (tasks.containsKey(id)) {
            tasks.put(id, updatedTodo);
            System.out.println("Task updated: " + updatedTodo);
        } else {
            System.out.println(" not found. No task updated.");
        }
    }

    public List<Todo> readTasks() {
        return todoList;
    }
}