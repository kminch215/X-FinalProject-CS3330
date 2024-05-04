package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightListModel {

	private ArrayList<FlightInformation> flightModel;
	private final static String flightInformationFile = "flightInformationFile.csv";

	public FlightListModel() {
		super();
		this.flightModel = new ArrayList<FlightInformation>();
	}

	public ArrayList<FlightInformation> getFlightModel() {
		return flightModel;
	}
	
	public boolean initializeFlights() {
		FlightInformation flight = null;
    	try {
	        File file = new File(flightInformationFile);
	        Scanner scanner = new Scanner(file);
            // Skip the header if present
	        if (scanner.hasNextLine()) {
	            scanner.nextLine(); // Assuming the first line is a header, if not remove this line
	        }

	        // Read the data
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] parts = line.split(","); // Assuming the CSV is comma-separated

	            // Access each part of the CSV row
	            int flightNumber = Integer.parseInt(parts[0]);
	            String departureLocation = parts[1];
	            String arrivalLocation = parts[2];
	            Date date = Date.valueOf(parts[3]);
	            
	            // Do something with the data, for example, print it
	            System.out.println("FlightNumber: " + flightNumber + ", Departure: " + departureLocation + ", Arrival: " + arrivalLocation + ", Date: " + date);
	            
	            flight = new FlightInformation(flightNumber, departureLocation, arrivalLocation, date);
	            
	            flightModel.add(flight);
	        }
	        scanner.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + flightInformationFile);
	        e.printStackTrace();
	        return false;
	    }
    	
    	return true;
	}
	
}
