package org.example.service;

import org.example.Main;
import org.example.controller.TodoController;
import org.example.repository.ProjectRepository;
import org.example.service.ProjectService;
import org.example.domain.Database;
import org.example.domain.Session;
import org.example.domain.User;

import java.util.Scanner;

public class UserService {



    private final Scanner scanner = new Scanner(System.in);
  private static Session session;
    public void loging() {
        String choice;
        do {
            System.out.println("1.log in");
            System.out.println("2. log up");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    this.logIn();
                    break;
                case "2":
                    this.logUp();
                    break;
                case "0":
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("-----------------------");
        } while (!choice.equals("0"));
    }

    public void logUp() {
try {

    System.out.println("Enter your Username");
    String username = scanner.nextLine();
    System.out.println("Enter your Password");
    String password = scanner.nextLine();

    if (Database.USERS.stream().noneMatch(u -> u.getUserName().equals(username)&& u.getPassword().equals(password))) {
        User user = new User(username,password);
        Database.USERS.add(user);
        System.out.println("yeni hesab yarandi");
    } else
        System.out.println("artik var");
}catch (Exception e){
e.printStackTrace();
}
    }
    public void logIn() {
        System.out.println("enter your username");
        String username = scanner.nextLine().trim();
        Session.setCurrentUserName(username);
        System.out.println("enter your password");
        String password = scanner.nextLine().trim();
        Database.USERS.stream().forEach(System.out::println);
        if (Database.USERS.stream().anyMatch(u -> u.getUserName().equals(username) && u.getPassword().equals(password))) {
            System.out.println("hesaba daxil oldunuz");
           // new Main().todoController.run();
            new Main().projectService.manageProjects();


        } else {
            System.out.println("bele hesab yoxdur");
        }
    }
}