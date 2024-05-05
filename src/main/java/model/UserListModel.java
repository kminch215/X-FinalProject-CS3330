package model;

import javax.swing.*;
import java.util.ArrayList;

public class UserListModel {
    private ArrayList<UserInformation> userList;

    public UserListModel() {
        this.userList = new ArrayList<>();
    }

    public ArrayList<UserInformation> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserInformation> userList) {
        this.userList = userList;
    }

    public void saveUser(UserInformation user) {
        System.out.println("Saving New User!");

        System.out.println("Location 3" + user.getPassword());
        userList.add(user);
    }

    public UserInformation getUserByUsername(String username) {
        for (UserInformation user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public UserInformation authenticateUser(String username, String password) {
        System.out.println("Checkibng to see if user exists...");
        System.out.println(username);
        System.out.println(password);
        for (UserInformation user : this.userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // If Successful
            }
        }
        System.out.println("No User Found, here is a list of valid users:");
        for(UserInformation i : this.userList){
            System.out.println("-------------");
            System.out.println("Username: " + i.getUsername());
            System.out.println("Password:" + i.getPassword() );
            System.out.println("-------------");
        }
        return null; // If Fail
    }
}
