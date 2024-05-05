package controller;

import model.UserInformation;
import model.UserListModel;
import view.UserLoginView;

import javax.swing.*;

public class UserLoginController {
    private UserLoginView loginView;
    private UserListModel loginModel;
    private UserInformation currentUser;
    private static UserLoginController instance;

    public UserLoginController() {
        this.loginView = new UserLoginView();
        this.loginModel = new UserListModel();
    }

    public static UserLoginController getInstance() {
        if (instance == null) {
            instance = new UserLoginController();
        }
        return instance;
    }

    public void userLogin(String username, String password) {
        if (validateInput(username, password)) {
            UserInformation user = loginModel.authenticateUser(username, password);
            if (user != null) {
                // Login successful
                currentUser = user;
                JOptionPane.showMessageDialog(null, "Login successful.");
            } else {
                // Login failed
                JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input. Please provide username and password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void logout() {
        currentUser = null;
        // Redirect to login page
    }

    private boolean validateInput(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public UserInformation getCurrentUser() {
        return currentUser;
    }
}
