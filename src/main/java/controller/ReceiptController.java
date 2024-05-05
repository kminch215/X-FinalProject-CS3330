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
	
	public void displayReceipts() {
		for(ReceiptInformation receipt : UserDashboard.getPurchaseHistory()) {
			receiptView.getReceiptList().addElement(receipt);
		}
	}
	
	public void cancelBooking(ReceiptInformation receipt) {
		if(receiptModel.getReceiptList().contains(receipt)) {
			ArrayList<SeatInformation> seats = receipt.getSeats();
			for(SeatInformation seat : seats) {
				SeatListModel.getInstance().addSeat(seat);
			}
			receipt.setTotalPrice(0.0);
		}
	}
	
	public void bookAdditionalSeat(ReceiptInformation receipt) {
		int flightNo = receipt.getFlightNumber();
		SeatSelectionController seatController = new SeatSelectionController(flightNo);
		receiptView.setVisible(false);
		
	}
	
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
	
	public class ActionListenerToUserDashboard implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			receiptView.setVisible(false);
			UserDashboardController userDashboardController = new UserDashboardController();
		}
		
	}
}