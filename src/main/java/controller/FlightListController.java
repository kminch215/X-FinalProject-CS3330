package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

import model.FlightInformation;
import model.FlightListModel;
import view.FlightListView;

/**
 * This class is the Controller class for all of the flight displaying and modeling operations.
 * @author Kendra Minch
 */
public class FlightListController {

	private FlightListView flightView;
	private FlightListModel flightModel;
	
	/**
	 * Default constructor that is responsible for setting the flightModel and the FlightView.
	 * This constructor also is in charge of telling the model to initialize the data along with
	 * displaying this loaded data to the view.
	 * 
	 * @author Kendra Minch
	 */
	public FlightListController() {
		super();
		this.flightView = new FlightListView();
		this.flightModel = new FlightListModel();
		//initializing the flightModel with the flights in the csv file
		flightModel.initializeFlights();
		//setting the flightView to visible so the window appears
		flightView.setVisible(true);
		//loads the flights into the flightTable using the flightModel
		displayFlights(flightModel.getFlightModel());
		//adding the filtering options to the flightView drop downs
		addDepartureAndArrivalFilterOptions();
		
		//adding the action listeners to the two actions that can be performed in the flightView
		flightView.addActionListenerToSelectFlightButton(new ActionListenerSelectFlight());
		flightView.addActionListenerToFilterButton(new ActionListenerFilterFlight());
	}
	
	/**
	 * This method will add the filtering options to the departure and arrival drop down in the flightView.
	 * First it will add the all filtering option which will allow the user to retrieve all the arrival and
	 * departing flights in the model. Next, it goes through the flightModel and retrieves all the possible
	 * arrival and departure locations to then add them to the filtering drop downs.
	 * 
	 * @author Kendra Minch
	 */
	public void addDepartureAndArrivalFilterOptions() {
		flightView.addDepartureFilterItems("all");
		flightView.addArrivalFilterItems("all");
		for(FlightInformation flight : flightModel.getFlightModel()) {
			flightView.addDepartureFilterItems(flight.getDepartureLocation());
			flightView.addArrivalFilterItems(flight.getArrivalLocation());
		}
	}
	
	/**
	 * This method will display the flights that are passed to it in the ArrayList. This could be the 
	 * original flightModel, or it could an ArrayList of the filtered flights.
	 * 
	 * @param flights
	 * @author Kendra Minch
	 */
	public void displayFlights(ArrayList<FlightInformation> flights) {
		//clear all the flights out of the table
		flightView.clearFlightTable();
		for(FlightInformation flight : flights) {
			//add each of the flights that are stored in the flights ArrayList
			flightView.addFlightInformationToView(flight);
		}
	}
	
	/**
	 * This method will be called when the filter button is clicked (see action listener below) and it will
	 * be passed the parameters that are within the drop down boxes when that event is called. These strings will
	 * be compared to the full flightModel to check for any flights that fit the requirements specified in the
	 * filter. The method will then return this ArrayList, which can then be used to manipulate the flightView.
	 * 
	 * @param departure
	 * @param arrival
	 * @return filtered list of flights
	 * @author Kendra Minch
	 */
	public ArrayList<FlightInformation> getFilteredFlights(String departure, String arrival) {
		ArrayList<FlightInformation> filteredFlights = new ArrayList<FlightInformation>();
		//if both departure and arrival have "all" selected, get every flight in the model
		if(departure.equals("all") && arrival.equals("all")) {
			for(FlightInformation flight : flightModel.getFlightModel()) {
				filteredFlights.add(flight);
			}
			return filteredFlights;
		}
		//if only the departure is "all", get all the flights that match the arrival location in the model
		else if (departure.equals("all")) {
			for(FlightInformation flight : flightModel.getFlightModel()) {
				if(flight.getArrivalLocation().equals(arrival))
				{
					filteredFlights.add(flight);
				}
			}
			return filteredFlights;
		}
		//if only the arrival is "all", get all the flights that match the departure location in the model
		else if (arrival.equals("all")) {
			for(FlightInformation flight : flightModel.getFlightModel()) {
				if(flight.getDepartureLocation().equals(departure))
				{
					filteredFlights.add(flight);
				}
			}
			return filteredFlights;
		}
		//else case where both the departure and arrival location are set to particular cities
		for(FlightInformation flight : flightModel.getFlightModel()) {
			if(flight.getDepartureLocation().equals(departure) && flight.getArrivalLocation().equals(arrival))
			{
				filteredFlights.add(flight);
			}
		}
		return filteredFlights;
	}
	
	/**
	 * Internal class that is used for when the user selects the "Select Flight" button in the flightView.
	 * 
	 * @author Kendra Minch
	 */
	public class ActionListenerSelectFlight implements ActionListener {

		/**
		 * Method that is invoked for when the action is performed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//confirm that the flightView has a flight selected to get
			if(flightView.getSelectedFlightNumber() == -1) {
		        JOptionPane.showMessageDialog(null, "No flight selected!");
		        //if not return
		        return;
			}
			//if so, initialize the SeatSelectionController and then set the flightView to invisible
			SeatSelectionController seatController = new SeatSelectionController(flightView.getSelectedFlightNumber());
			flightView.setVisible(false);
		}
		
	}
	
	/**
	 * Internal class that is used for when the user selects the "Filter" button in the flightView.
	 * 
	 * @author Kendra Minch
	 */
	public class ActionListenerFilterFlight implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//get the two values in the flightView drop downs
			String departure = flightView.getSelectedDeparture();
			String arrival = flightView.getSelectedArrival();
			
			//get the filtered flights according to the departure and arrival selections
			ArrayList<FlightInformation> filteredFlights = getFilteredFlights(departure, arrival);
			//if the ArrayList is empty, display a message to the user
			if(filteredFlights.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No flights match this filter combination!");
		        return;
			}
			//if not, display the filtered flights
			displayFlights(filteredFlights);
		}
		
	}
}