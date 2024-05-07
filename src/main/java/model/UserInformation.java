package model;

import javax.swing.*;

public class UserInformation {
    private int userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    //parameterized constructor
    public UserInformation(int userID, String username, String password, String firstName, String lastName, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //getter for the user ID
    public int getUserID() {
        return userID;
    }

    //setter for the user ID
    public void setUserID(int userID) {
        this.userID = userID;
    }

    //getter for the username
    public String getUsername() {
        return username;
    }

    //setter for the username
    public void setUsername(String username) {
        this.username = username;
    }

    //getter for the password
    public String getPassword() {

        return password;
    }

    //setter for the password
    public void setPassword(String password) {
        this.password = password;
    }

    //getter for the first name
    public String getFirstName() {
        return firstName;
    }

    //setter for the first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //getter for the last name
    public String getLastName() {
        return lastName;
    }

    //setter for the last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //getter for the email
    public String getEmail() {
        return email;
    }

    //setter for the email
    public void setEmail(String email) {
        this.email = email;
    }
}
