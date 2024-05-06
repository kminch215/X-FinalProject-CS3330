package model;

/**
 * Class that allows for a first class seat to be created. Extends SeatInformation
 */
public class FirstClassSeat extends SeatInformation {

	private double seatPrice;
	
	//parameterized constructor
	public FirstClassSeat(int flightNumber, int seatNumber, double seatPrice) {
		super(flightNumber, seatNumber);
		this.seatPrice = seatPrice;
	}
	
	//getter for the seat price
	public double getSeatPrice() {
		return seatPrice;
	}

	//setter for the seat price
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	@Override
	public String seatDescription() {
		String description = "This is a First Class Seat";
		return description;
		
	}

}
