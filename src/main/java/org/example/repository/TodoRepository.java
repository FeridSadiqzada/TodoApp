package org.example.repository;
import org.example.domain.Todo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@SuppressWarnings("ALL")

public class TodoRepository   {
    private final static List<Todo> todoList = new ArrayList<>();

    public static List<Todo> getTodoList() {
        return todoList;
    }
    private final List<Todo> subTodoList = new ArrayList<>();

    public List<Todo> getSubTodoLis() {
        return subTodoList;
    }


    public void addTodo(Todo todo) {
       getTodoList().add(todo);
       getSubTodoLis().add(todo);
    }
    public void deleteTodo(UUID id) {
        getTodoList().removeIf(todo -> todo.getId().equals(id));
       }
    public static void deleteTodoSF(UUID id) {
        for (Todo todo : getTodoList()) {
            if (todo.getId().equals(id)) {
                todo.setStatus("D");
                break;
            }
        }
       }

    public static String getStatusById(UUID uuid) {
        for (Todo todo : getTodoList()) {
            if (todo.getId().equals(uuid)) {
                return todo.getStatus();
            }
        }
        return "Not Found";
    }

    public void updateTodo(UUID id, Todo updatedTodo) {
        getTodoById(id).ifPresentOrElse(
                todo -> {

                    todo.setDescription(updatedTodo.getDescription());
                    todo.setStatus(updatedTodo.getStatus());
                    todo.setStatus(updatedTodo.getStatus());
                },
                () -> {
                    System.out.println("Todo with ID " + id + " not found.");
                }
        );
    }
    public List<Todo> readTasks() {
        return getTodoList();
    }
    public Optional<Todo> getTodoById(UUID id) {
        return getTodoList().stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst();
    }
}