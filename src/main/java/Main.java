import javax.swing.SwingUtilities;

import controller.UserRegisterController;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				UserRegisterController registerController = new UserRegisterController();
			}
		});	
	}
}
