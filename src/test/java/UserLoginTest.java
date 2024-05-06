import model.UserInformation;
import model.UserListModel;
import controller.UserLoginController;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserLoginTest {
    private UserListModel userListModel;
    private UserLoginController userLoginController;


    public void setUp() {
        // Initialize UserListModel and UserLoginController before each test
        userListModel = new UserListModel();
        userLoginController = new UserLoginController(userListModel);
    }

    @Test
    public void testValidLogin() {
        // Add a user to model
        userListModel.saveUser(new UserInformation(1, "testuser", "password", "John", "Doe", "john@example.com"));
        
        // Attempt login with valid credentials
        userLoginController.userLogin("testuser", "password");
        
        // Check if the user is logged in
        assertTrue(userLoginController.isLoggedIn());
    }

    @Test
    public void testInvalidLogin() {
        // Attempt login with invalid credentials
        userLoginController.userLogin("invaliduser", "invalidpassword");
        
        // Check if the user is not logged in
        assertFalse(userLoginController.isLoggedIn());
    }

    @Test
    public void testEmptyUsernameAndPassword() {
        // Attempt login with null values
        userLoginController.userLogin("", "");
        
        // Check if the user is not logged in
        assertFalse(userLoginController.isLoggedIn());
    }

    @Test
    public void testLogout() {
        // Login first
        testValidLogin();
        
        // Logout
        userLoginController.logout();
        
        // Check if the user is logged out
        assertFalse(userLoginController.isLoggedIn());
    }

    @Test
    public void testUsernameNotFound() {
        // Attempt login with username that does not exist
        userLoginController.userLogin("nonexistentuser", "password");
        
        // Check if the user is not logged in
        assertFalse(userLoginController.isLoggedIn());
    }
}
