package model;

public class FirstClassSeat extends SeatInformation {

	private double seatPrice;
	
	public FirstClassSeat(int flightNumber, int seatNumber, double seatPrice) {
		super(flightNumber, seatNumber);
		this.seatPrice = seatPrice;
	}
	

	public double getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}

	@Override
	void seatDescription() {
		
		
	}

}
