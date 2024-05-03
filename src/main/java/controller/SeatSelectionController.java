package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.SeatInformation;
import model.SeatListModel;
import view.SeatSelectionView;

public class SeatSelectionController {

	private SeatSelectionView seatView;
	private SeatListModel seatModel;
	
	public SeatSelectionController(int flightNumber) {
		super();
		this.seatView = new SeatSelectionView();
		this.seatModel = SeatListModel.getInstance();
//		seatModel.initializeSeats();
		displaySeats(seatModel.getSeatModel(), flightNumber);
		seatView.setVisible(true);
		seatView.addActionListenerToSelectSeatButton(new ActionListenerSelectSeat());
		seatView.addActionListenerToBackButton(new ActionListenerBackToFlightList());


	}
	
	public void displaySeats(ArrayList<SeatInformation> seats, int flightNumber) {
		seatView.clearSeatTable();
		for(SeatInformation seat : seats) {
			if(seat.getFlightNumber() == flightNumber) {
				seatView.addSeatInformationToView(seat);
			}
		}
	}
	
	public class ActionListenerSelectSeat implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(seatView.getSelectedSeatNumber() == -1) {
		        JOptionPane.showMessageDialog(null, "No seat selected!");
		        return;
			}
			PaymentController paymentController = new PaymentController();
			System.out.println("Selected Seat(s): " + seatView.getSelectedSeatNumber());
			System.out.println("Moving to payment view...");
			seatView.setVisible(false);
		}	
	}
	
	public class ActionListenerBackToFlightList implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			FlightListController flightListController = new FlightListController();
			flightListController.initiate();
			System.out.println("Returning to Flight View...");
			seatView.setVisible(false);
		}	
	}
	
}