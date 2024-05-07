package model;

import java.util.ArrayList;

/**
 * Information that is needed to be attached to each receipt
 */
public class ReceiptInformation {

	private int receiptID = 0;
	private int userID;
	private int flightNumber;
	private ArrayList<SeatInformation> seats;
	private double totalPrice;
	
	//parameterized constructor
	public ReceiptInformation(int userID, int flightNumber, ArrayList<SeatInformation> seats) {
		super();
		this.receiptID = receiptID++;
		this.userID = userID;
		this.flightNumber = flightNumber;
		this.seats = seats;
		this.setTotalPrice(calculateTotal());
	}
	
	//getter for the receipt ID
	public int getReceiptID() {
		return receiptID;
	}
	
	//setter for the receipt ID
	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}
	
	//getter for the user ID
	public int getUserID() {
		return userID;
	}
	
	//setter for the user ID
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	//getter for the flight number
	public int getFlightNumber() {
		return flightNumber;
	}
	
	//getter for the arraylist of seats
	public ArrayList<SeatInformation> getSeats() {
		return seats;
	}
	
	//setter for the arraylist of seats
	public void setSeats(ArrayList<SeatInformation> seats) {
		this.seats = seats;
	}
	
	//getter for the total price
	public double getTotalPrice() {
		return totalPrice;
	}
	
	//setter for the total price
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * toString() to display the format for the receipt list view
	 */
	@Override
	public String toString() {
		return "Flight Number: " + flightNumber + "               Order Price: " + calculateTotal();
	}
	
	/**
	 * Used to calculate the total based on the seat array that was passed to the ReceiptInfromation class
	 * @return a double representing the total for the purchase
	 */
	public double calculateTotal() {
		double total = 0.0;
		for(SeatInformation seat : seats) {
			if(seat instanceof EconomySeat) {
				EconomySeat econSeat = (EconomySeat)seat;
				total += econSeat.getSeatPrice();
			}
			if(seat instanceof FirstClassSeat) {
				FirstClassSeat FCseat = (FirstClassSeat)seat;
				total += FCseat.getSeatPrice();
			}
		}
		return total;
	}
}