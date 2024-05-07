package controller;

import model.UserDashboard;
import model.UserInformation;
import model.UserListModel;
import view.UserLoginView;
import controller.UserLoginController;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Login Controller is in charge of controlling the login operations
 */
public class UserLoginController {
	
    private UserLoginView loginView;
    private UserListModel loginModel;
    private UserInformation currentUser;
    private UserLoginController userLoginController;

    /**
     * Constructor that will take in a user list model
     * @param userListModel
     */
    public UserLoginController(UserListModel userListModel) {
        this.loginView = new UserLoginView();
        this.loginModel = userListModel; 

        loginView.addActionListenerToLoginButton(new ActionListenerLoginButton());
    }

    public UserLoginController getInstance() {
        return this.userLoginController;
    }

    /**
     * This method will login the user after the login button is pressed. It will then confirm that the
     * login was successful or not successful.
     * 
     * @param username
     * @param password
     */
    public void userLogin(String username, String password) {
        if (validateInput(username, password)) {
            UserInformation user = loginModel.authenticateUser(username, password);
            if (user != null) {
                // Login successful
                currentUser = user;
                UserDashboard userDashboard = new UserDashboard(user.getUserID());
                //Hide Login View -> User Dashboard 
                loginView.setVisible(false);    
    
                UserDashboardController userDashboardController = new UserDashboardController();
//                FlightListController flightController = new FlightListController();
                

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

    /**
     * Validates that the username and the password are not empty
     * @param username
     * @param password
     * @return true if the strings are not empty, false if they are empty
     */
    private boolean validateInput(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    //get the current user
    public UserInformation getCurrentUser() {
        return currentUser;
    }
    public void initiate(){
        loginView.setVisible(true);
    }

    /**
     * Internal class that is an action listener that will be executed when the user presses the login button
     */
    public class ActionListenerLoginButton implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String userName = loginView.getUsernameField().getText();
            String password = new String(loginView.getPasswordField().getPassword());
            userLogin(userName, password);
        }
    }
}
