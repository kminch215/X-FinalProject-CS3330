import javax.swing.SwingUtilities;

import controller.FlightListController;
import controller.PaymentController;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				PaymentController paymentController = new PaymentController();
				
				paymentController.initialize();
			}
		});
		
	}

}