package view;

import java.util.Scanner;

public class UserLoginView {
    private Scanner scanner;
    
    public UserLoginView() {
        scanner = new Scanner(System.in);
    }
    
    public void displayLoginForm() {
        System.out.println("=== User Login ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        // Pass the user input to the controller for login
        UserLoginController.getInstance().userLogin(username, password);
    }
    
    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
