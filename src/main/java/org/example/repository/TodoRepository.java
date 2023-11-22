package org.example.repository;
import org.example.domain.Todo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public class TodoRepository   {
    private final List<Todo> todoList = new ArrayList<>();

    public void addTodo(Todo todo) {
        todoList.add(todo);
    }

    public void deleteTodo(UUID id) {
        todoList.removeIf(todo -> todo.getId().equals(id));

       }
    public void updateTodo(UUID id, Todo updatedTodo) {
        getTodoById(id).ifPresentOrElse(
                todo -> {
                    todo.setDescription(updatedTodo.getDescription());
                    todo.setCreated(updatedTodo.isCreated());
                },
                () -> {
                    System.out.println("Todo with ID " + id + " not found.");
                }
        );
    }
    public List<Todo> readTasks() {
        return todoList;
    }
    public Optional<Todo> getTodoById(UUID id) {
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst();
    }
}