package model;

import java.sql.Date;

public class FlightInformation {

	private int flightNumber;
	private String departureLocation;
	private String arrivalLocation;
	private Date date;
	
	//parameterized constructor
	public FlightInformation(int flightNumber, String departureLocation, String arrivalLocation, Date date) {
		super();
		this.flightNumber = flightNumber;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.date = date;
	}
	//getter for the flight number
	public int getFlightNumber() {
		return flightNumber;
	}
	//getter for the departure location
	public String getDepartureLocation() {
		return departureLocation;
	}
	//getter for the arrival location
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	//getter for the date
	public Date getDate() {
		return date;
	}


}