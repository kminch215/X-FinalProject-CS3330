import model.UserInformation;
import model.UserListModel;
import view.UserRegisterView;
import controller.UserRegisterController;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.UserRegisterController;

public class UserRegisterTest {

    @Test
    public void testValidRegistration() {
        UserRegisterController registerController = UserRegisterController.getInstance();
        
        // Perform a valid registration
        registerController.registerUser("testuser", "password", "John", "Doe", "john.doe@example.com");
        
        // Assuming registration is successful, the user list should not be empty
        assertFalse(registerController.getUserModel().getUserList().isEmpty());
    }

    @Test
    public void testEmptyFields() {
        UserRegisterController registerController = UserRegisterController.getInstance();
        
        // Perform registration with empty fields
        registerController.registerUser("", "", "", "", "");
        
        // The user list should remain empty as the registration should fail due to empty fields
        assertTrue(registerController.getUserModel().getUserList().isEmpty());
    }

    @Test
    public void testDuplicateUsername() {
        UserRegisterController registerController = UserRegisterController.getInstance();
        
        // Register a user with a specific username
        registerController.registerUser("testuser", "password", "John", "Doe", "john.doe@example.com");
        
        // Attempt to register another user with the same username
        registerController.registerUser("testuser", "password123", "Jane", "Doe", "jane.doe@example.com");
        
        // The user list size should be 1 since the second registration should fail due to duplicate username
        assertEquals(1, registerController.getUserModel().getUserList().size());
    }
}
