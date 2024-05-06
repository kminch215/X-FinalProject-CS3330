package model;

/**
 * Class that allows for a economy seat to be created. Extends SeatInformation
 */
public class EconomySeat extends SeatInformation{

	private double seatPrice;
	
	//parameterized constructor
	public EconomySeat(int flightNumber, int seatNumber, double seatPrice) {
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
		String description = "This is an Economy Seat";
		return description;
	}

}
