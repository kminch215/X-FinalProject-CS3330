package model;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Uses to maintain a list of the registered users
 */
public class UserListModel {
    private static ArrayList<UserInformation> userList;

    //default constructor
    public UserListModel() {
        UserListModel.userList = new ArrayList<>();
    }

    //getter for the user list
    public ArrayList<UserInformation> getUserList() {
        return userList;
    }

    //saves the user to the userList
    public void saveUser(UserInformation user) {
        userList.add(user);
    }

    //getter for the user based on the username
    public UserInformation getUserByUsername(String username) {
        for (UserInformation user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Will check if the user us authorized or not
     * @param username
     * @param password
     * @return if the user is valid, it will return the UserInformation, and if it is not valid, return null
     */
    public UserInformation authenticateUser(String username, String password) {
        for (UserInformation user : this.userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // If Successful
            }
        }
        System.out.println("No User Found, please try again");

        return null; // If Fail
    }
}
