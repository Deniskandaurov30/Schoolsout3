package services;

import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class UserService {

    private UserRepository userRepository;
    private Scanner scanner = new Scanner(System.in);

    public UserService() {
        this.userRepository = new UserRepository();

    }

    public void  getUserByLogin(){
        System.out.println("what is your login");
        String login = scanner.next();
        User user = userRepository.findUserByLogin(login);
        System.out.println(user);
    }

    public void getAllUsers(){
        List<User> users = userRepository.getAllUsers();
        for (User user: users){
            System.out.println(user);
        }
    }

    public void insertUser(){
        System.out.println("give me the name of the user");
        String name = scanner.next();
        User user = new User();
        userRepository.createUser(user);



    }

    public void updateUser(){
        getAllUsers();
        System.out.println("Choose the login of which user to change");
        String login = scanner.next();
        User user = userRepository.findUserByLogin(login);

        System.out.println("type in the new login if u don't want to change anything press '0'. ");
        String newUser = scanner.next();
        if (user != null) user.setLogin(login);

    }

    public void deleteUser(){
        getAllUsers();
        System.out.println("Choose the login of the user u would like to delete");
        String login = scanner.next();
        User user = userRepository.findUserByLogin(login);
        userRepository.deleteUser(user);
    }
}
