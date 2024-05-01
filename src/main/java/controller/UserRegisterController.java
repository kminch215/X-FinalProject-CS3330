package controller;

import model.UserListModel;
import view.UserRegisterView;

public class UserRegisterController {

	private UserRegisterView registerView;
	private UserListModel registerModel;
	
	public UserRegisterController() {
		super();
		this.registerView = new UserRegisterView();
		this.registerModel = new UserListModel();
	}
}
