package controller;

import model.UserInformation;
import model.UserListModel;
import view.UserRegisterView;
import controller.UserLoginController;

import java.awt.event.ActionListener;

import javax.swing.*;

public class UserRegisterController {
    private UserRegisterView registerView;
    private UserListModel userModel;
    private static UserRegisterController instance;

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

    
    public void registerUser(String username, String password, String firstName, String lastName, String email) {


        if (validateInput(username, password, firstName, lastName, email)) {
            // Generate a unique user ID
            int userID = generateUserID();

            // Create a new user
            UserInformation newUser = new UserInformation(userID, username, password, firstName, lastName, email);
            System.out.println("Location 2" + password);

            // Save the user
            userModel.saveUser(newUser);

            registerView.setVisible(false);
            UserLoginController userLoginController = new UserLoginController(userModel);
            //sets user login page visible
            userLoginController.initiate();

            // Notify user of a successful registration
            JOptionPane.showMessageDialog(null, "User registered successfully!");
                
            registerView.setVisible(false);
            System.out.println("Exiting Register View");
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid input. Please fill all fields.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateInput(String username, String password, String firstName, String lastName, String email) {
        return !username.isEmpty() && !password.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty()
                && !email.isEmpty();
    }

    private int generateUserID() {
        return (int) (Math.random() * 1000);
    }

    public void initiate() {
        registerView.setVisible(true);
    }

    public class ActionListenerRegisterButton implements ActionListener{
        

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String userName = registerView.getUsernameField().getText();
            String password = new String(registerView.getPasswordField().getPassword());
            String firstName = registerView.getFirstNameField().getText();
            String lastName = registerView.getLastNameField().getText();
            String email = registerView.getEmailField().getText();
            System.out.println("Location 1" + password);
            registerUser(userName, password, firstName, lastName, email);
        }
    }
}
