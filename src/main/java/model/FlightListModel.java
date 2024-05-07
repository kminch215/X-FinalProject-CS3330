package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The FlightListModel class is a model class that will store the data needed to be manipulated by the 
 * FlightListController and displayed to the user using the FlightListView.
 * 
 * @author Kendra Minch
 */
public class FlightListModel {

	private ArrayList<FlightInformation> flightModel;
	private final static String flightInformationFile = "flightInformationFile.csv";


	/**
    * Constructs a new FlightListModel with an empty list of flights.
    * 
    * @author Kendra Minch
    */
	public FlightListModel() {
		super();
		this.flightModel = new ArrayList<FlightInformation>();
	}

	/**
	 * Retrieves the list of flights.
	 *
	 * @return The list of flights.
	 * @author Kendra Minch
	 */
	public ArrayList<FlightInformation> getFlightModel() {
		return flightModel;
	}
	

    /**
     * Initializes the list of flights by reading data from a CSV file.
     *
     * @return true if initialization is successful, false otherwise.
     * @author Kendra Minch
     */
	public boolean initializeFlights() {
		FlightInformation flight = null;
    	try {
	        File file = new File(flightInformationFile);
	        Scanner scanner = new Scanner(file);
            // Skip the header if present
	        if (scanner.hasNextLine()) {
	            scanner.nextLine();
	        }

	        // Read the data
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            //split it with commas because it is a CSV
	            String[] parts = line.split(",");

	            // Access each part of the CSV row
	            int flightNumber = Integer.parseInt(parts[0]);
	            String departureLocation = parts[1];
	            String arrivalLocation = parts[2];
	            Date date = Date.valueOf(parts[3]);
	            	            
	            //initialize the new flight object with the data that is read
	            flight = new FlightInformation(flightNumber, departureLocation, arrivalLocation, date);
	            
	            //add the flight just initialized to the flightModel
	            flightModel.add(flight);
	        }
	        //close the scanner
	        scanner.close();
	        //if the file is not thrown then catch the exception
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + flightInformationFile);
	        e.printStackTrace();
	        //returns false if the file could not have been read
	        return false;
	    }
    	
    	//return true when the file has been read
    	return true;
	}
	
}
