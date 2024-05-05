package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import model.UserInformation;
import model.UserListModel;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {
    
    @Mock
    JOptionPane optionPane;

    private UserListModel userListModel;

    @Before
    public void setUp() {
        userListModel = new UserListModel();
    }

    @Test
    public void testSaveUser() {
        // Create a user
        UserInformation user = new UserInformation(1, "username", "password", "John", "Doe", "john@example.com");

        // Save user
        userListModel.saveUser(user);

        // Assert user is added to the list
        assertTrue(userListModel.getUserList().contains(user));
    }

    @Test
    public void testGetUserByUsername() {
        // Create a user
        UserInformation user = new UserInformation(1, "username", "password", "John", "Doe", "john@example.com");

        // Save user
        userListModel.saveUser(user);

        // Retrieve user by username
        UserInformation retrievedUser = userListModel.getUserByUsername("username");

        // Assert user is retrieved successfully
        assertNotNull(retrievedUser);
        assertEquals("username", retrievedUser.getUsername());
    }

    @Test
    public void testAuthenticateUser() {
        // Create a user
        UserInformation user = new UserInformation(1, "username", "password", "John", "Doe", "john@example.com");

        // Save user
        userListModel.saveUser(user);

        // Authenticate user with correct credentials
        UserInformation authenticatedUser = userListModel.authenticateUser("username", "password");

        // Assert authentication is successful
        assertNotNull(authenticatedUser);
        assertEquals("username", authenticatedUser.getUsername());

        // Authenticate user with incorrect credentials
        UserInformation wrongUser = userListModel.authenticateUser("username", "wrongPassword");

        // Assert authentication fails
        assertNull(wrongUser);
    }
}
