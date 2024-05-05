package test;

import controller.UserLoginController;
import model.UserInformation;
import model.UserListModel;
import org.junit.jupiter.api.Test;
import view.UserLoginView;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoginTest {

    @Test
    void testUserLoginSuccess() {
        UserListModel userModel = new UserListModel();
        userModel.saveUser(new UserInformation("user", "password", "John", "Doe", "john@example.com"));

        UserLoginView loginView = new UserLoginView();
        JTextField usernameField = loginView.getUsernameField();
        JTextField passwordField = loginView.getPasswordField();

        usernameField.setText("user");
        passwordField.setText("password");

        UserLoginController.getInstance().userLogin(usernameField.getText(), new String(passwordField.getPassword()));

        assertTrue(UserLoginController.getInstance().isLoggedIn());
        assertNotNull(UserLoginController.getInstance().getCurrentUser());
    }

    @Test
    void testUserLoginFailure() {
        UserLoginView loginView = new UserLoginView();
        JTextField usernameField = loginView.getUsernameField();
        JTextField passwordField = loginView.getPasswordField();

        usernameField.setText("invaliduser");
        passwordField.setText("invalidpassword");

        UserLoginController.getInstance().userLogin(usernameField.getText(), new String(passwordField.getPassword()));

        assertFalse(UserLoginController.getInstance().isLoggedIn());
        assertNull(UserLoginController.getInstance().getCurrentUser());
    }

    // Add more test cases as needed
}
