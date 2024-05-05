package view;

import javax.swing.*;

import controller.UserLoginController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton; 
    public UserLoginView() {
        setTitle("User Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel);
        usernameField = new JTextField();
        add(usernameField);
        
        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel);
        passwordField = new JPasswordField();
        add(passwordField);
        
        loginButton = new JButton("Login");
        add(loginButton);
        
        setVisible(true);
    }
    
    public JTextField getUsernameField() {
        return usernameField;
    }
    public void addActionListenerToLoginButton(ActionListener listener){
        loginButton.addActionListener(listener); 
    }
    
    public JPasswordField getPasswordField() {
        return passwordField;
    }
}
