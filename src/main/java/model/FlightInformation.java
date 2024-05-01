package model;

import java.sql.Date;

public class FlightInformation {

	private int flightNumber;
	private String departureLocation;
	private String arrivalLocation;
	private Date date;
	
	public FlightInformation(int flightNumber, String departureLocation, String arrivalLocation, Date date) {
		super();
		this.flightNumber = flightNumber;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.date = date;
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartureLocation() {
		return departureLocation;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}