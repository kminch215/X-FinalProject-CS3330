package model;

/**
 * Class to contain the information about the seats
 */
public abstract class SeatInformation {

	private int flightNumber;
	private int seatNumber;
	
	//parameterized constructor
	public SeatInformation(int flightNumber, int seatNumber) {
		super();
		this.flightNumber = flightNumber;
		this.seatNumber = seatNumber;
	}
	
	//getter for the flight number
	public int getFlightNumber() {
		return flightNumber;
	}
	
	//setter for the flight number
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	//getter for the seat number
	public int getSeatNumber() {
		return seatNumber;
	}
	
	//setter for the seat number
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public abstract String seatDescription();
}
