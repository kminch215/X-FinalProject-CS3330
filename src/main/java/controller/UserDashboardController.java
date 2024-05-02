package controller;

import model.UserListModel;
import view.UserLoginView;

public class UserLoginController {
	
	private UserLoginView loginView;
	private UserListModel loginModel;
	private UserInformation currentUser;
	private static UserLoginController instance;
	
	
	public UserLoginController() {
		super();
		this.loginView = new UserLoginView();
		this.loginModel = new UserListModel();
	}

	public static UserLoginController getInstance() {
        if (instance == null) {
            instance = new UserLoginController();
        }
        return instance;
    }
    
    public void userLogin(String username, String password) {
        if (validateInput(username, password)) {
            UserInformation user = loginModel.authenticateUser(username, password);
            if (user != null) {
                // Login successful
                currentUser = user;
                loginView.displaySuccessMessage("Login successful.");
            } else {
                // Login failed
                loginView.displayErrorMessage("Invalid username or password.");
            }
        } else {
            loginView.displayErrorMessage("Invalid input. Please provide username and password.");
        }
    }
    
    public void logout() {
        currentUser = null;
        // Redirect to login page
    }
    
    private boolean validateInput(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }
    
    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    public UserInformation getCurrentUser() {
        return currentUser;
    }
	
}
