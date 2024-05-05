package controller;

import model.UserInformation;
import model.UserListModel;
import view.UserLoginView;
import controller.UserLoginController;
import javafx.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//TODO: Add current user into dashboard


public class UserLoginController {
    private UserLoginView loginView;
    private UserListModel loginModel;
    private UserInformation currentUser;
    private UserLoginController userLoginController;

    public UserLoginController(UserListModel userListModel) {
        this.loginView = new UserLoginView();
        this.loginModel = userListModel; 

        loginView.addActionListenerToLoginButton(new ActionListenerLoginButton());
    }

    public UserLoginController getInstance() {
        return this.userLoginController;
    }

    public void userLogin(String username, String password) {
        if (validateInput(username, password)) {
            UserInformation user = loginModel.authenticateUser(username, password);
            if (user != null) {
                // Login successful
                currentUser = user;
                //Hide Login View -> User Dashboard 
                loginView.setVisible(false);    
    
                UserDashboardController userDashboardController = new UserDashboardController(user);

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
    public void initiate(){
        loginView.setVisible(true);
    }

    public class ActionListenerLoginButton implements ActionListener {
        

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String userName = loginView.getUsernameField().getText();
            String password = new String(loginView.getPasswordField().getPassword());
            userLogin(userName, password);
        }
    }
}
