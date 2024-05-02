package controller;

import model.UserListModel;
import view.UserRegisterView;

public class UserRegisterController {

	private UserRegisterView registerView;
	private UserListModel userModel;
	private static UserRegisterController instance;
	
	public UserRegisterController() {
		super();
		this.registerView = new UserRegisterView();
		this.userModel = new UserListModel();
	}

	public static UserRegisterController getInstance() {
        if (instance == null) {
            instance = new UserRegisterController();
        }
        return instance;
    }

	public void registerUser(String username, String password, String firstName, String lastName, String email) {
        if (validateInput(username, password, firstName, lastName, email)) {
            // Generate a unique user ID
            int userID = generateUserID();
            
            // Create a new user
            UserInformation newUser = new UserInformation(username, password, firstName, lastName, email, userID);
            
            // Save the user
            userModel.saveUser(newUser);
            
            // Notify user of a successful registration
            registerView.displaySuccessMessage("User registered successfully!");
        } else {
            registerView.displayErrorMessage("Invalid input. Please fill all fields.");
        }
    }
    
    private boolean validateInput(String username, String password, String firstName, String lastName, String email) {
        return !username.isEmpty() && !password.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty();
    }
    
    private int generateUserID() {
        return (int) (Math.random() * 1000); 
    }
}
