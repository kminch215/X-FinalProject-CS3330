package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class uses a Singleton design pattern to allow access to the list of available seats.
 * @author Samantha Whitaker
 */
public class SeatListModel {

	private final static String seatInformationFile = "seatInformationFile.csv";	
	private static SeatListModel mInstance;
    private ArrayList<SeatInformation> seatModel = null;
	
    //singleton instance
	public static SeatListModel getInstance() {
        if(mInstance == null)
            mInstance = new SeatListModel();

        return mInstance;
    }
	
	//private default constructor
	 private SeatListModel() {
		seatModel = new ArrayList<SeatInformation>();
		initializeSeats();
      }

	 //getter for the seat model
	public ArrayList<SeatInformation> getSeatModel() {
		return seatModel;
	}

	//setter for the seat model
	public void setSeatModel(ArrayList<SeatInformation> seatModel) {
		this.seatModel = seatModel;
	}

	/**
	 * This method initializes the seats by reading them in from the provided file and creating a new seat 
	 * depending on whether the seat is of type Economy or First Class.
	 * @return boolean
	 * @author Samantha Whitaker
	 */
	public boolean initializeSeats() {
		SeatInformation seat = null;
    	try {
	        File file = new File(seatInformationFile);
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
	            int seatClass = Integer.parseInt(parts[0]);
	            int flightNumber = Integer.parseInt(parts[1]);
	            int seatNumber = Integer.parseInt(parts[2]);
	            
            	if(seatClass == 1) {
	            	seat = new FirstClassSeat(flightNumber, seatNumber, 1000.00);
	            }
	            else if(seatClass == 2) {
	            	seat = new EconomySeat(flightNumber, seatNumber, 300.00);
	            }
	            	            	            
	            seatModel.add(seat); 
	        }
	        scanner.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + seatInformationFile);
	        e.printStackTrace();
	        return false;
	    }
    	
    	return true;
	}
	
	/**
	 * This method adds the provided seat to the ArrayList of available seats.
	 * @param seat
	 * @return boolean
	 * @author Samantha Whitaker
	 */
	public boolean addSeat(SeatInformation seat) {
		if(!seatModel.contains(seat)) {
			seatModel.add(seat);
			return true;
		}
		return false;
	}
	
	
	/**
	 * This method will remove the seat passed to it from the instance of seatModel
	 * @param seat
	 * @return true if the removal was successful, false if it wasn't
	 * @author Kendra Minch
	 */
	static public boolean removeSeat(SeatInformation seatToRemove) {
		for(int i = 0; i < getInstance().getSeatModel().size()-1; i++) {
			if(getInstance().getSeatModel().get(i).equals(seatToRemove))
			{
				getInstance().getSeatModel().remove(i);
				return true;
			}
		}
		return false;
	}
}
