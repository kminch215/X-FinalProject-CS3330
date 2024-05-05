package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListModelTest {
    private UserListModel userListModel;

    @BeforeEach
    void setUp() {
        userListModel = new UserListModel();
        UserInformation user1 = new UserInformation("testuser1", "password1", "John", "Doe", "john.doe@example.com");
        UserInformation user2 = new UserInformation("testuser2", "password2", "Jane", "Smith", "jane.smith@example.com");
        userListModel.saveUser(user1);
        userListModel.saveUser(user2);
    }

    @Test
    void testSaveUser() {
        assertEquals(2, userListModel.getUserList().size());
    }

    @Test
    void testGetUserByUsername() {
        UserInformation user = userListModel.getUserByUsername("testuser1");
        assertNotNull(user);
        assertEquals("testuser1", user.getUsername());
    }

    @Test
    void testAuthenticateUserSuccess() {
        UserInformation user = userListModel.authenticateUser("testuser1", "password1");
        assertNotNull(user);
        assertEquals("testuser1", user.getUsername());
    }

    @Test
    void testAuthenticateUserFail() {
        UserInformation user = userListModel.authenticateUser("testuser1", "wrongpassword");
        assertNull(user);
    }
}
