package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.SeatInformation;
import model.SeatListModel;
import view.SeatSelectionView;

/**
 * @author Samantha Whitaker
 */

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
	
	/**
	 * This method displays available seats for a given flight number to the user.
	 * @param seats
	 * @param flightNumber
	 */

	public void displaySeats(ArrayList<SeatInformation> seats, int flightNumber) {
		seatView.clearSeatTable();
		for(SeatInformation seat : seats) {
			if(seat.getFlightNumber() == flightNumber) {
				seatView.addSeatInformationToView(seat);
			}
		}
	}
	
	/**
	 * This method takes an int[] of user-selected seats and converts it into an ArrayList of type SeatInformation
	 * to be used in other methods.
	 * @param seats
	 * @return
	 */
	public ArrayList<SeatInformation> intArrayToArrayList(int[] seats){
		ArrayList<SeatInformation> convertedSeats = new ArrayList<>();
		ArrayList<SeatInformation> seatList = seatModel.getSeatModel();
		for(int seatNum : seats) {
			for(SeatInformation seat : seatList) {
				if(seat.getSeatNumber() == seatNum) {
					convertedSeats.add(seat);
					break;
				}
			}
		}
		return convertedSeats;
	}


	public class ActionListenerSelectSeat implements ActionListener {

		/**
		 * This method passes an int[] of user-selected seats to the PaymentController, prints the selected seats to console,
		 * and sets the SeatView to invisible.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			int[] selectedSeats = seatView.getSelectedSeatNumbers();
			if(selectedSeats.length == 0) {
		        JOptionPane.showMessageDialog(null, "No seat selected!");
		        return;
			}
			ArrayList<SeatInformation> seats = intArrayToArrayList(selectedSeats);
			PaymentController paymentController = new PaymentController(seats);
			
			seatView.setVisible(false);
		}	
	}
	
	public class ActionListenerBackToFlightList implements ActionListener {

		/**
		 * This method creates a new instance of the FlightListController and returns the user to the FlightView
		 * from the SeatSelectionView.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			FlightListController flightListController = new FlightListController();
//			flightListController.initiate();
			System.out.println("Returning to Flight View...");
			seatView.setVisible(false);
		}	
	}
	
}