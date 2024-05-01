package model;

import java.util.ArrayList;

public class ReceiptInformation {

	private int receiptID;
	private int userID;
	private int flightNumber;
	private ArrayList<SeatInformation> seats;
	
	//change this so that the orderTotal is calculated from the ArrayList
	public ReceiptInformation(int userID, int flightNumber, ArrayList<SeatInformation> seats) {
		super();
		this.userID = userID;
		this.flightNumber = flightNumber;
		this.seats = seats;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public ArrayList<SeatInformation> getSeats() {
		return seats;
	}
	public void setSeats(ArrayList<SeatInformation> seats) {
		this.seats = seats;
	}
	
	public double calculateTotal() {
		double total = 0.0;
		for(SeatInformation seat : seats) {
			
		}
		return total;
	}
	
	
}
