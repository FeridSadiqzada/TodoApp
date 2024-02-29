package org.example.service;

import org.example.domain.Database;
import org.example.domain.Status;
import org.example.domain.Todo;
import org.example.domain.User;
import org.example.repository.TodoRepository;

import java.util.*;

@SuppressWarnings("ALL")

public class TodoService {
//    TODO:bunlari final elemek lazimdiki gelecekde kimse bunlara yeni object assign ede bilmesin
//    TODO:cunki bu hisse realda dependecy injection vasitesi ile inject edilecek elnen new edilmiyecek
    private final TodoRepository todoRepository;
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService;

    public TodoService(TodoRepository todoRepository, UserService userService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
    }

    public UUID getUserIdByEmail(String email) {
        return userService.getUserIdByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found for email: " + email));
    }




    //String userIdstr= userId.toString();
    public void addTask() {
        List<UUID> uuids = userService.getAllUserIds();
        List<String> emails = userService.getEmailsByUserIds(uuids);

        System.out.println("task or subtask?");
        String tasks = scanner.nextLine();
       // String mail;
        try {

            if (tasks.equals("task") ) {
//                System.out.println("Enter user email:");
//                String email = scanner.nextLine();
                //UUID userId = getUserIdByEmail(email);
                for (int i = 0; i < uuids.size(); i++) {
                    UUID uuid = uuids.get(i);
                    String emailfor = emails.get(i);
                    System.out.printf("User ID: %s, Email: %s\n", uuid, emailfor);
                }
                System.out.println("Taski assign elemek istediyiniz id ni daxil edin");
                String uuidstring = scanner.nextLine();
                UUID assignedTo = UUID.fromString(uuidstring);

                if (uuids.contains(assignedTo)){
                } else {
                    System.out.println("bele user yoxdur");
                }
                String username = userService.getUsernameById(assignedTo);
                String status = todoRepository.getStatusById(assignedTo);
                System.out.println("Enter title:");
                String title = scanner.nextLine();

                System.out.println("Enter description:");
                String description = scanner.nextLine();

                Todo newTodo = Todo.builder()
                        .assignedTo(assignedTo.toString())
                        .title(title)
                        .description(description)
                        .createdBy(username)
                        .status("Active")
                        .build();

                todoRepository.addTodo(newTodo);
            } else if (tasks.equals("subtask")) {
                System.out.println(todoRepository.getTodoList());
                System.out.println("subtask yaratmaq istediyinizin idsini daxil edin");
                String taskId =scanner.nextLine();
                if (TodoRepository.getTodoList().stream().anyMatch(u -> u.getAssignedTo().equals(taskId)))
                    {
                } else {
                    System.out.println("bele task yoxdur");
                }
                System.out.println("Enter title:");
                String title = scanner.nextLine();

                System.out.println("Enter description:");
                String description = scanner.nextLine();

                Todo newTodo = Todo.builder().build();
                todoRepository.addTodo(newTodo);
           }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status. Please enter task or subtask.");
        }
          }
    public void deleteTask(Scanner scanner) {
        System.out.println(todoRepository.getTodoList());
        System.out.println("Enter the ID of the task you want to delete:");
        String idString = scanner.nextLine();
        UUID id = UUID.fromString(idString);

        todoRepository.deleteTodoSF(id);
        System.out.println("Task deleted successfully.");
    }
       public void updateTask(Scanner scanner) {
           System.out.println(todoRepository.getTodoList());
           System.out.println("Enter the ID of the task you want to update:");
           String idString = scanner.nextLine();
           UUID id = UUID.fromString(idString);
           Todo existingTodo = todoRepository.getTodoById(id).orElse(null);

           if (existingTodo != null) {
               String upchoice;

               do {
                   System.out.println("1. Description");
                   System.out.println("2. Status ");
                   System.out.println("0. Exit");

                   System.out.print("Enter your choice: ");
                   upchoice = scanner.nextLine().trim();

                   switch (upchoice) {
                       case "1":
                           System.out.println("Enter the new description:");
                           String description = scanner.nextLine();
                           Todo updatedDescription = Todo.builder().build();
                           todoRepository.updateTodo(id, updatedDescription);
                           System.out.println("Task updated successfully.");
                           break;
                       case "2":
                           System.out.println("Enter the new status (PROGRESS, COMPLETED, HOLD):");
                           String statuss = scanner.nextLine();
                           try {
                               Status status = Status.valueOf(statuss.toUpperCase());

                               if (status.equals(Status.PROGRESS) || status.equals(Status.COMPLETED) || status.equals(Status.HOLD)) {
                                   Todo updatedStatus = Todo.builder().build();
                                   todoRepository.updateTodo(id, updatedStatus);
                                   System.out.println("Task updated successfully.");
                               }
                           } catch (IllegalArgumentException e) {
                               System.out.println("Invalid status. Please enter PROGRESS, COMPLETED, or HOLD.");
                           }
                           break;
                       case "0":
                           System.out.println("Exiting!");
                           break;
                       default:
                           System.out.println("Invalid choice. Please try again.");
                   }
                   System.out.println("-----------------------");
               } while (!upchoice.equals("0"));


           } else {
               System.out.println("Task not found.");
           }

       }
           public List<Todo> readTasks () {
               List<Todo> tasks = todoRepository.readTasks();
               tasks.forEach(t -> {
                   System.out.println("id: " + t.getId() + " assignedTo: " + t.getAssignedTo() + " Title: " + t.getTitle() + "," + "Description: " + t.getDescription() + "  createdBy: " + t.getCreatedBy() + " status: " + t.getStatus());
               });
               return todoRepository.readTasks();
           }
       }