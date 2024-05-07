package view;

import javax.swing.*;

import controller.UserLoginController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * View for the user login
 */
public class UserLoginView extends JFrame {
	
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton; 
    
    //constructor to initialize the layout and visibility of the view
    public UserLoginView() {
        setTitle("User Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        
        //username label
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel);
        //username field
        usernameField = new JTextField();
        add(usernameField);
        
        //password label
        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel);
        //password field
        passwordField = new JPasswordField();
        add(passwordField);
        
        //login button
        loginButton = new JButton("Login");
        add(loginButton);
        
        setVisible(true);
    }
    
    //getter for the username field
    public JTextField getUsernameField() {
        return usernameField;
    }
    
    //action listener for when the login button is clicked
    public void addActionListenerToLoginButton(ActionListener listener){
        loginButton.addActionListener(listener); 
    }
    
    //getter for the password field
    public JPasswordField getPasswordField() {
        return passwordField;
    }
}
