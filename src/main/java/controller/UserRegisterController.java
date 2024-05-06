package controller;

import model.UserInformation;
import model.UserListModel;
import view.UserRegisterView;
import controller.UserLoginController;

import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Controller in charge of connecting the userModel and registerView for registering the customer with the Flight
 * Reservation System
 */
public class UserRegisterController {
	
    private UserRegisterView registerView;
    private UserListModel userModel;
    private static UserRegisterController instance;

    //default constructor
    public UserRegisterController() {
        this.registerView = new UserRegisterView();
        this.userModel = new UserListModel();

        ActionListener actionListenerRegisterButton = new ActionListenerRegisterButton();
        registerView.addActionListenerToRegisterButton(actionListenerRegisterButton);
        registerView.setVisible(true);

    }

    public static UserRegisterController getInstance() {
        if (instance == null) {
            instance = new UserRegisterController();
        }
        return instance;
    }

    //getter for the user model
    public UserListModel getUserModel() {
        return userModel;
    }
    
    /**
     * This method will register the user after the registration button is pressed. It will then confirm that the
     * registration was successful or not successful.
     * 
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     */
    public void registerUser(String username, String password, String firstName, String lastName, String email) {
        if (validateInput(username, password, firstName, lastName, email)) {
            // Generate a unique user ID
            int userID = generateUserID();

            // Create a new user
            UserInformation newUser = new UserInformation(userID, username, password, firstName, lastName, email);

            // Save the user
            userModel.saveUser(newUser);

            registerView.setVisible(false);
            UserLoginController userLoginController = new UserLoginController(userModel);
            //sets user login page visible
            userLoginController.initiate();

            // Notify user of a successful registration
            JOptionPane.showMessageDialog(null, "User registered successfully!");
                
            registerView.setVisible(false);
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid input. Please fill all fields.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method will check to ensure that the fields are not empty
     * 
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @return true if the fields are all filled, false if one or more of the fields are empty
     */
    private boolean validateInput(String username, String password, String firstName, String lastName, String email) {
        return !username.isEmpty() && !password.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty()
                && !email.isEmpty();
    }

    //generates random userID
    private int generateUserID() {
        return (int) (Math.random() * 1000);
    }

    //used to initialize the registerView
    public void initiate() {
        registerView.setVisible(true);
    }

    /**
     * Internal class that is an action listener that will be executed when the user presses the register button
     */
    public class ActionListenerRegisterButton implements ActionListener{
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String userName = registerView.getUsernameField().getText();
            String password = new String(registerView.getPasswordField().getPassword());
            String firstName = registerView.getFirstNameField().getText();
            String lastName = registerView.getLastNameField().getText();
            String email = registerView.getEmailField().getText();
            registerUser(userName, password, firstName, lastName, email);
        }
    }
}
