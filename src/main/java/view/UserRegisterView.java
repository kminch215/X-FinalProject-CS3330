package view;

import java.util.Scanner;

public class UserRegisterView {
    private Scanner scanner;
    
    public UserRegisterView() {
        scanner = new Scanner(System.in);
    }
    
    public void displayRegisterForm() {
        System.out.println("=== User Registration ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        // Pass the user input to the controller for registration
        UserRegisterController.getInstance().registerUser(username, password, firstName, lastName, email);
    }
}
