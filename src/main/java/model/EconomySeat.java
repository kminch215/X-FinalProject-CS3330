package model;

public class EconomySeat extends SeatInformation{

	private double seatPrice;
	
	public EconomySeat(int flightNumber, int seatNumber, double seatPrice) {
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
		// TODO Auto-generated method stub
		
	}

}
