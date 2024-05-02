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
	
}
