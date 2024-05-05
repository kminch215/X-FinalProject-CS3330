package view;

import controller.UserLoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    
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
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                // Pass the user input to the controller for login
                UserLoginController.getInstance().userLogin(username, password);
            }
        });
        add(loginButton);
        
        setVisible(true);
    }
    
    // Getter methods for testing
    public JTextField getUsernameField() {
        return usernameField;
    }
    
    public JPasswordField getPasswordField() {
        return passwordField;
    }
}
