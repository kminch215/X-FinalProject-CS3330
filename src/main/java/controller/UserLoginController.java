package controller;

import model.UserListModel;
import view.UserLoginView;

public class UserLoginController {
	
	private UserLoginView loginView;
	private UserListModel loginModel;
	
	
	public UserLoginController() {
		super();
		this.loginView = new UserLoginView();
		this.loginModel = new UserListModel();
	}

	 
}
