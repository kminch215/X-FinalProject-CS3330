package view;

import javax.swing.*;

import controller.UserRegisterController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View for the registation window
 */
public class UserRegisterView extends JFrame {
	
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JButton registerButton;

    //constructor to format and set up the view for user login
    public UserRegisterView() {
        setTitle("User Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        
        //label for the username 
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel);
        usernameField = new JTextField();
        add(usernameField);
        
        //label for the password
        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel);
        passwordField = new JPasswordField();
        add(passwordField);
        
        //label for the first name
        JLabel firstNameLabel = new JLabel("First Name:");
        add(firstNameLabel);
        firstNameField = new JTextField();
        add(firstNameField);
        
        //label for the last name
        JLabel lastNameLabel = new JLabel("Last Name:");
        add(lastNameLabel);
        lastNameField = new JTextField();
        add(lastNameField);
        
        //label for the email
        JLabel emailLabel = new JLabel("Email:");
        add(emailLabel);
        emailField = new JTextField();
        add(emailField);
        
        //button for registering user
        registerButton = new JButton("Register");
        add(registerButton);
    }

    /**
     * Action listener for when the user clicks the register button
     * @param listener
     */
    public void addActionListenerToRegisterButton(ActionListener listener){
        registerButton.addActionListener(listener); 
    }
    
    // Getter methods for testing
    public JTextField getUsernameField() {
        return usernameField;
    }
    
    //getter for the password field
    public JPasswordField getPasswordField() {

        return passwordField;
    }
    
    //getter for the first name field
    public JTextField getFirstNameField() {
        return firstNameField;
    }
    
    //getter for the last name field
    public JTextField getLastNameField() {
        return lastNameField;
    }
    
    //getter for the email field
    public JTextField getEmailField() {
        return emailField;
    }
}
