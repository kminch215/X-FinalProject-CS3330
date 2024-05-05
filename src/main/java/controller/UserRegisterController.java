package controller;

import model.UserInformation;
import model.UserListModel;
import view.UserRegisterView;

import javax.swing.*;

public class UserRegisterController {
    private UserRegisterView registerView;
    private UserListModel userModel;
    private static UserRegisterController instance;

    public UserRegisterController() {
        this.registerView = new UserRegisterView();
        this.userModel = new UserListModel();
    }

    public static UserRegisterController getInstance() {
        if (instance == null) {
            instance = new UserRegisterController();
        }
        return instance;
    }

    public void registerUser(String username, String password, String firstName, String lastName, String email) {
        if (validateInput(username, password, firstName, lastName, email)) {
            // Generate a unique user ID
            int userID = generateUserID();

            // Create a new user
            UserInformation newUser = new UserInformation(userID, password, firstName, lastName, email, username);

            // Save the user
            userModel.saveUser(newUser);

            // Notify user of a successful registration
            JOptionPane.showMessageDialog(null, "User registered successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input. Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateInput(String username, String password, String firstName, String lastName, String email) {
        return !username.isEmpty() && !password.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty();
    }

    private int generateUserID() {
        return (int) (Math.random() * 1000);
    }
}
