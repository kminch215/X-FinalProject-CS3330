package model;

import java.util.ArrayList;

public class UserListModel {

	private ArrayList<UserInformation> userList;

	public UserListModel() {
		super();
		this.userList = new ArrayList<UserInformation>();
	}

	public ArrayList<UserInformation> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserInformation> userList) {
		this.userList = userList;
	}

	public void saveUser(UserInformation user) {
        	userList.add(user);
        	System.out.println("User registered successfully!");
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
        	for (UserInformation user : userList) {
            	if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                	return user; // If Successful
            	}
        }
        return null; // If Fail
    }
	
}
