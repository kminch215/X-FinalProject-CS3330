package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.FlightListController.ActionListenerSelectFlight;
import model.ReceiptInformation;
import model.ReceiptListModel;
import model.SeatInformation;
import model.SeatListModel;
import model.UserDashboard;
import view.ReceiptView;

public class ReceiptController {

	private ReceiptView receiptView;
	private ReceiptListModel receiptModel;
	
	public ReceiptController() {
		super();
		this.receiptView = new ReceiptView();
		this.receiptModel = new ReceiptListModel();
		receiptView.addActionListenerToSelectUserDashboardButton(new ActionListenerToUserDashboard());
		receiptView.setVisible(true);
		
		displayReceipts();
		receiptView.setVisible(true);
	}
	
	/**
	 * This will display all the receipts that the user has in the receiptView 
	 * 
	 * @author Kendra Minch
	 */
	public void displayReceipts() {
		System.out.println("UserID " + UserDashboard.getUserID());
		for(ReceiptInformation receipt : UserDashboard.getPurchaseHistory()) {
			receiptView.getReceiptList().addElement(receipt);
		}
	}
	
	/**
	 * @author Samantha Whitaker
	 * This method takes a user's receipt and cancels the booking by adding the seats the available seats list
	 * and zeroing out the total payment amount of that receipt.
	 * @param receipt
	 */
	public void cancelBooking(ReceiptInformation receipt) {
		if(receiptModel.getReceiptList().contains(receipt)) {
			ArrayList<SeatInformation> seats = receipt.getSeats();
			for(SeatInformation seat : seats) {
				SeatListModel.getInstance().addSeat(seat);
			}
			receipt.setTotalPrice(0.0);
		}
	}
	
	/**
	 * @author Samantha Whitaker
	 * This method allows a user to book an additional seat.
	 * @param receipt
	 */
	public void bookAdditionalSeat(ReceiptInformation receipt) {
		int flightNo = receipt.getFlightNumber();
		SeatSelectionController seatController = new SeatSelectionController(flightNo);
		receiptView.setVisible(false);
		
	}
	
	/**
	 * @author Samantha Whitaker
	 * This method cancels the passed seat by removing it from the receipt, calculating and saving the new total price, 
	 * and adding the seat back to the list of available seats. 
	 * @param receipt
	 * @param seat
	 */
	public void cancelSelectedSeat(ReceiptInformation receipt, SeatInformation seat) {
		if(receiptModel.getReceiptList().contains(receipt)) {
			ArrayList<SeatInformation> seats = receipt.getSeats();
			if(seats.contains(seat)) {
				seats.remove(seat);
				receipt.setSeats(seats);
				double newTotal = receipt.calculateTotal();
				receipt.setTotalPrice(newTotal);
				// add seat back to list of available seats
				SeatListModel.getInstance().addSeat(seat);
			}	
		}
	}
	
	/**
	 * Action listener that takes the user to the User Dashboard whenever the they click the "To User Dashboard" 
	 * button.
	 * 
	 * @author Kendra Minch
	 */
	public class ActionListenerToUserDashboard implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			receiptView.setVisible(false);
			UserDashboardController userDashboardController = new UserDashboardController();
		}
		
	}

	//getters for the receipt model
	public ReceiptListModel getReceiptModel() {
		return receiptModel;
	}

	public ReceiptView getReceiptView() {
		return receiptView;
	}
}