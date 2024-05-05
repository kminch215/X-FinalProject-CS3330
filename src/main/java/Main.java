import javax.swing.SwingUtilities;

import controller.FlightListController;
import controller.UserRegisterController;
import model.UserInformation;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
//				UserInformation user = new UserInformation(0, "username", "password", "fname", "lname", "email");
				UserRegisterController registerController = new UserRegisterController();
			}
		});
		
	}

}
