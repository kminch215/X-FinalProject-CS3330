package test;

import controller.UserRegisterController;
import org.junit.jupiter.api.Test;
import view.UserRegisterView;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        UserRegisterView registerView = new UserRegisterView();
        UserRegisterController controller = new UserRegisterController();

        registerView.getUsernameField().setText("testuser");
        registerView.getPasswordField().setText("password");
        registerView.getFirstNameField().setText("John");
        registerView.getLastNameField().setText("Doe");
        registerView.getEmailField().setText("test@example.com");

        controller.registerUser("testuser", "password", "John", "Doe", "test@example.com");

        // Assert that user is registered successfully
        JOptionPane pane = (JOptionPane) SwingUtilities.getAncestorOfClass(JOptionPane.class, registerView);
        assertNotNull(pane);
        assertEquals(JOptionPane.INFORMATION_MESSAGE, pane.getMessageType());
        assertEquals("User registered successfully!", pane.getMessage());
    }

    @Test
    void testEmptyFieldsUserRegistration() {
        UserRegisterView registerView = new UserRegisterView();
        UserRegisterController controller = new UserRegisterController();

        registerView.getUsernameField().setText("");
        registerView.getPasswordField().setText("");
        registerView.getFirstNameField().setText("");
        registerView.getLastNameField().setText("");
        registerView.getEmailField().setText("");

        controller.registerUser("", "", "", "", "");

        // Assert that error message is displayed for empty fields
        JOptionPane pane = (JOptionPane) SwingUtilities.getAncestorOfClass(JOptionPane.class, registerView);
        assertNotNull(pane);
        assertEquals(JOptionPane.ERROR_MESSAGE, pane.getMessageType());
        assertEquals("Invalid input. Please fill all fields.", pane.getMessage());
    }

    // Add more test cases for invalid input data
}
