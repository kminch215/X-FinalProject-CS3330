package controller;

import java.util.ArrayList;

import model.ReceiptInformation;
import model.ReceiptListModel;
import model.SeatInformation;
import model.SeatListModel;
import view.ReceiptView;

public class ReceiptController {

	private ReceiptView receiptView;
	private ReceiptListModel receiptModel;
	
	public ReceiptController() {
		super();
		this.receiptView = new ReceiptView();
		this.receiptModel = new ReceiptListModel();
		
		displayReceipts(receiptModel.getReceiptList());
		receiptView.setVisible(true);
	}
	
	public void displayReceipts(ArrayList<ReceiptInformation> receipts) {
//		UserInformation user = new UserInformation(username, age);
//		userModel.getUserList().add(user);
//		
//		userListView.getUserList().addElement(user);
		for(ReceiptInformation receipt : receipts) {
//			receiptView.addReceiptInformationToView(receipt);
		}
	}
	
	public void bookFlight() {
		
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
}