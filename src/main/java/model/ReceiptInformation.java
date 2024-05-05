package model;

import java.util.ArrayList;

public class ReceiptInformation {

	private int receiptID = 0;
	private int userID;
	private int flightNumber;
	private ArrayList<SeatInformation> seats;
	private double totalPrice;
	
	//change this so that the orderTotal is calculated from the ArrayList
	public ReceiptInformation(int userID, int flightNumber, ArrayList<SeatInformation> seats) {
		super();
		this.receiptID = receiptID++;
		this.userID = userID;
		this.flightNumber = flightNumber;
		this.seats = seats;
		this.setTotalPrice(calculateTotal());
	}
	public int getReceiptID() {
		return receiptID;
	}
	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
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
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	@Override
	public String toString() {
		return "Flight Number: " + flightNumber + "               Order Price: " + calculateTotal();
	}
	
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