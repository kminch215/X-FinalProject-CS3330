package view;

import javax.swing.*;

import controller.UserRegisterController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegisterView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JButton registerButton;

    public UserRegisterView() {
        setTitle("User Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel);
        usernameField = new JTextField();
        add(usernameField);
        
        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel);
        passwordField = new JPasswordField();
        add(passwordField);
        
        JLabel firstNameLabel = new JLabel("First Name:");
        add(firstNameLabel);
        firstNameField = new JTextField();
        add(firstNameField);
        
        JLabel lastNameLabel = new JLabel("Last Name:");
        add(lastNameLabel);
        lastNameField = new JTextField();
        add(lastNameField);
        
        JLabel emailLabel = new JLabel("Email:");
        add(emailLabel);
        emailField = new JTextField();
        add(emailField);
        
        registerButton = new JButton("Register");
        add(registerButton);
    }

    public void addActionListenerToRegisterButton(ActionListener listener){
        registerButton.addActionListener(listener); 
    }
    // Getter methods for testing
    public JTextField getUsernameField() {
        return usernameField;
    }
    
    public JPasswordField getPasswordField() {

        return passwordField;
    }
    
    public JTextField getFirstNameField() {
        return firstNameField;
    }
    
    public JTextField getLastNameField() {
        return lastNameField;
    }
    
    public JTextField getEmailField() {
        return emailField;
    }
}
