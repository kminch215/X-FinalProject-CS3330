package model;

public abstract class SeatInformation {

	private int flightNumber;
	private int seatNumber;
	
	public SeatInformation(int flightNumber, int seatNumber) {
		super();
		this.flightNumber = flightNumber;
		this.seatNumber = seatNumber;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public abstract String seatDescription();

}
