import javax.swing.SwingUtilities;

import controller.FlightListController;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				FlightListController flightController = new FlightListController();
				flightController.initiate();
			}
		});
		
	}

}
