package africa.semicolon.callerapp;

import africa.semicolon.callerapp.controllers.UserController;
import africa.semicolon.callerapp.dtos.requests.AddContactRequest;
import africa.semicolon.callerapp.dtos.requests.RegisterRequest;
import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;
@SpringBootApplication
public class MainApp {

        private static Scanner scanner = new Scanner(System.in);
        private static UserController userController = new UserController();

    public static void main(String[] args) {


//            SpringApplication.run(Main.class, args);
        new SpringApplicationBuilder(MainApp.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
            displayMainMenu();
        }

        private static  void displayMainMenu(){

            String mainMenuPrompt = """
                Welcome to Not Fake TruCaller
                
                1 --> Create a new account
                2 -->  add contact to a  user
                3 --> Find contact belonging to user
                
                """;

//        System.out.println(mainMenuPrompt);
            String userIput = input(mainMenuPrompt);
            switch (userIput.charAt(0)) {
                case '1' -> createAccount();
                case '2' -> addContactToUser();
                case '3' -> findContactsBelongingTo();
            }
        }
        private static void createAccount() {
            RegisterRequest request = new RegisterRequest();

            request.setUsername(input("username"));
            request.setEmail(input("email"));
            request.setPassword(input("password"));
            userController.registerUSer(request);
            displayMainMenu();
        }
        public static String input(String prompt){
            System.out.println(prompt);
            return scanner.nextLine();
        }
        private static void findContactsBelongingTo() {
            var contacts = userController.findContactsBelongingTo(input("Enter your email address"));
            for (var contact : contacts) {
                System.out.println(contact.toString());
            }
            contacts.forEach(contact -> System.out.println(contact.toString()));
            displayMainMenu();
        }
        private static void addContactToUser(){
            AddContactRequest contactRequest = new AddContactRequest();
            contactRequest.setFirstName(input("First Name"));
            contactRequest.setLastName(input("Last Name"));
            contactRequest.setEmail(input("email"));
            contactRequest.setPhoneNumber(input("phone"));
            contactRequest.setUserEmail(input("user_email"));

            userController.addContact(contactRequest);
            displayMainMenu();
        }

//    }
    }



