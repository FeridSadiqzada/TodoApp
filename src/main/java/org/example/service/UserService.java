package org.example.service;
import org.example.Main;
import org.example.domain.Constants;
import org.example.domain.Session;
import org.example.domain.User;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")

public class UserService {
    UUID id = UUID.randomUUID();
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
                    this.logIn(id);
                    break;
                case "2":
                    this.logUp(id);
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
    public static Map<String, User> userCredentials = new HashMap<>();


    public UUID returnId(UUID id){
        return id;
    }

    public boolean isValidEmail(String email) {
        final Pattern pattern = Pattern.compile(Constants.EMAIL_REGEX);

        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean register(String email, String password,String userName,UUID id) {
        if (!isValidEmail(email)) {
            return false;
        }
        if (userCredentials.containsKey(email)) {
            return false; // E-posta zaten kayıtlı
        }

        userCredentials.put(email,new User(password, userName,id,email));
        return true;
    }

    public UUID authenticateAndGetId(String email, String password) {
        if (!isValidEmail(email)) {
            return null; // Invalid email format
        }
        User user = userCredentials.get(email);
        if (user != null && user.getPassword().equals(password)) {
            return user.getId(); // Return the user's ID on successful authentication
        }
        return null; //
    }
    public static Optional<UUID> getUserIdByEmail(String email) {
        if (email == null || !userCredentials.containsKey(email)) {
            return Optional.empty(); // User not found or email is null
        }
        return Optional.ofNullable(userCredentials.get(email).getId());
    }
    public static String getUsernameById(UUID uuid) {
        if (uuid == null || !userCredentials.containsKey(uuid)) {
            return "Input boş və ya id yanlışdır"; // User not found or email is null
        }
        return userCredentials.get(uuid).getUserName();
    }

    public static String StatusById(UUID uuid) {
        if (uuid == null || !userCredentials.containsKey(uuid)) {
            return "Input boş və ya id yanlışdır"; // User not found or email is null
        }
        return userCredentials.get(uuid).getUserName();
    }



    public static List<UUID> getAllUserIds() {
        // Check if the userCredentials map is not null or empty
        if (userCredentials == null || userCredentials.isEmpty()) {
            return Collections.emptyList(); // Return an empty list if no users are found
        }
        // Use a stream to collect all user IDs from the userCredentials map
        return userCredentials.values().stream()
                .map(user -> user.getId()) // Convert each user to their UUID
                .filter(Objects::nonNull) // Filter out any null IDs
                .collect(Collectors.toList()); // Collect the IDs into a List
    }

    public List<String> getEmailsByUserIds(List<UUID> uuids) {
        List<String> emails = new ArrayList<>();

        if (uuids == null || uuids.isEmpty()) {
            return emails;
        }


        for (Map.Entry<String, User> entry : userCredentials.entrySet()) {
            String email = entry.getKey();
            User user = entry.getValue();

            if (uuids.contains(user.getId())) {
                emails.add(email);
            }
        }

        return emails;
    }


    public void logUp(UUID id) {
        System.out.print("Kayıt için e-posta giriniz: ");
        String email = scanner.nextLine();
        System.out.print("Kayıt için username giriniz: ");
        String userName = scanner.nextLine();
        System.out.print("Şifre giriniz: ");
        String password = scanner.nextLine();


        if (register(email, password,userName,id)) {
            System.out.println("Kayıt başarılı. Giriş yapabilirsiniz.");
        } else {
            System.out.println("Kayıt başarısız. E-posta zaten kullanımda veya geçersiz.");
        }
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
    }

    public void logIn(UUID id) {
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

        UUID userId = authenticateAndGetId(email, password);
        if (userId != null) {
            System.out.println("Giriş başarılı.");
            System.out.println("User ID: " + userId);
            new Main().todoController.run();
            // Proceed with logged-in user operations
        } else {
            System.out.println("Yanlış kullanıcı adı veya şifre.");
        }







    }
}