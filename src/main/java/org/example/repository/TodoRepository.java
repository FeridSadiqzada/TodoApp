package org.example.repository;
import org.example.domain.Todo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class TodoRepository extends JpaRepository<Todo, String>  {

    Todo findByTitle(String title);

    List<Todo> findAllByTitle(String title);

    private final List<Todo> todoList = new ArrayList<>();


    public void addTodo(Todo todo) {
        todoList.add(todo);
    }

    public void deleteTodo(UUID id) {
        if (todo.containsKey(id)) {
            Todo deletedTask = todo.remove(id);
            System.out.println("Task deleted: " + deletedTask);
        } else {
            System.out.println( " not found. No task deleted.");
        }
       }

    public void updateTodo(UUID uuid, Todo todo) {
        if (todo.containsKey(id)) {
            todo.put(id, updatedTodo);
            System.out.println("Task updated: " + updatedTodo);
        } else {
            System.out.println(" not found. No task updated.");
        }

    }
    public List<Todo> readTodo() {
        return todoList;
    }
}