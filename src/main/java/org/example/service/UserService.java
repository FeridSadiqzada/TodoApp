package org.example.service;
import org.example.Main;
import org.example.domain.Constants;
import org.example.domain.Session;
import org.example.domain.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressWarnings("ALL")

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
    private Map<String, User> userCredentials = new HashMap<>();




    public boolean isValidEmail(String email) {
        final Pattern pattern = Pattern.compile(Constants.EMAIL_REGEX);

        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean register(String email, String password) {
        if (!isValidEmail(email)) {
            return false;
        }
        if (userCredentials.containsKey(email)) {
            return false; // E-posta zaten kayıtlı
        }

        userCredentials.put(email, new User(email, password));
        return true;
    }

    public boolean authenticate(String email, String password) {
        if (!isValidEmail(email)) {
            return false;
        }
        User user = userCredentials.get(email);
        return user != null && user.getPassword().equals(password);
    }


    public void logUp() {
//try {
//
//    System.out.println("Enter your Username");
//    String username = scanner.nextLine();
//    System.out.println("Enter your Password");
//    String password = scanner.nextLine();
//
//    if (Database.USERS.stream().noneMatch(u -> u.getUserName().equals(username)&& u.getPassword().equals(password))) {
//        User user = new User(username,password);
//        Database.USERS.add(user);
//        System.out.println("yeni hesab yarandi");
//    } else
//        System.out.println("artik var");
//}catch (Exception e){
//e.printStackTrace();
        System.out.print("Kayıt için e-posta giriniz: ");
        String email = scanner.nextLine();
        System.out.print("Şifre giriniz: ");
        String password = scanner.nextLine();

        if (register(email, password)) {
            System.out.println("Kayıt başarılı. Giriş yapabilirsiniz.");
        } else {
            System.out.println("Kayıt başarısız. E-posta zaten kullanımda veya geçersiz.");
        }
    }

    public void logIn() {
//        System.out.println("enter your username");
//        String username = scanner.nextLine().trim();
//        Session.setCurrentUserName(username);
//        System.out.println("enter your password");
//        String password = scanner.nextLine().trim();
//        Database.USERS.stream().forEach(System.out::println);
//        if (Database.USERS.stream().anyMatch(u -> u.getUserName().equals(username) && u.getPassword().equals(password))) {
//            System.out.println("hesaba daxil oldunuz");
//           // new Main().todoController.run();
//            new Main().projectService.manageProjects();
//
//
//        } else {
//            System.out.println("bele hesab yoxdur");
//        }



        System.out.print("E-posta giriniz: ");
        String email = scanner.nextLine();
        System.out.print("Şifre giriniz: ");
        String password = scanner.nextLine();

        if (authenticate(email, password)) {
            System.out.println("Giriş başarılı.");
//             new Main().todoController.run();
            new Main().projectService.manageProjects();
        } else {
            System.out.println("Yanlış kullanıcı adı veya şifre.");
        }


    }
}