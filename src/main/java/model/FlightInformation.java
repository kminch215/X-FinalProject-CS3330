package model;

import java.sql.Date;

/**
 * Class for the all the information needed pertaining to the flight
 * 
 * @author Kendra Minch
 */
public class FlightInformation {

	private int flightNumber;
	private String departureLocation;
	private String arrivalLocation;
	private Date date;
	
	/**
	 * Parameterized constructor to create a flight object
	 * 
	 * @param flightNumber
	 * @param departureLocation
	 * @param arrivalLocation
	 * @param date
	 * @author Kendra Minch
	 */
	public FlightInformation(int flightNumber, String departureLocation, String arrivalLocation, Date date) {
		super();
		this.flightNumber = flightNumber;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.date = date;
	}
	
	/**
	 * Getter for the flight number
	 * 
	 * @return integer representing the flight number
	 */
	public int getFlightNumber() {
		return flightNumber;
	}
	
	/**
	 * Getter for the flight departure location
	 * 
	 * @return String representing the departure location
	 */
	public String getDepartureLocation() {
		return departureLocation;
	}
	
	/**
	 * Getter for the flight arrival location
	 * 
	 * @return String representing the arrival location
	 */
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	
	/**
	 * Getter for the flight date
	 * 
	 * @return a date of type Date
	 */
	public Date getDate() {
		return date;
	}


}