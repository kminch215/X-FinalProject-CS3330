package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

import model.FlightInformation;
import model.FlightListModel;
import view.FlightListView;

public class FlightListController {

	private FlightListView flightView;
	private FlightListModel flightModel;
	
	public FlightListController() {
		super();
		this.flightView = new FlightListView();
		this.flightModel = new FlightListModel();
		flightModel.initializeFlights();
		displayFlights(flightModel.getFlightModel());
		addDepartureAndArrivalFilterOptions();
		flightView.addActionListenerToSelectFlightButton(new ActionListenerSelectFlight());
		flightView.addActionListenerToFilterButton(new ActionListenerFilterFlight());
	}
	
	public void addDepartureAndArrivalFilterOptions() {
		flightView.addDepartureFilterItems("all");
		flightView.addArrivalFilterItems("all");
		for(FlightInformation flight : flightModel.getFlightModel()) {
			flightView.addDepartureFilterItems(flight.getDepartureLocation());
			flightView.addArrivalFilterItems(flight.getArrivalLocation());
		}
	}
	
	public void displayFlights(ArrayList<FlightInformation> flights) {
		flightView.clearFlightTable();
		for(FlightInformation flight : flights) {
			flightView.addFlightInformationToView(flight);
		}
	}
	
	public ArrayList<FlightInformation> getFilteredFlights(String departure, String arrival) {
		ArrayList<FlightInformation> filteredFlights = new ArrayList<FlightInformation>();
		if(departure.equals("all") && arrival.equals("all")) {
			for(FlightInformation flight : flightModel.getFlightModel()) {
				filteredFlights.add(flight);
			}
			return filteredFlights;
		}
		else if (departure.equals("all")) {
			for(FlightInformation flight : flightModel.getFlightModel()) {
				if(flight.getArrivalLocation().equals(arrival))
				{
					filteredFlights.add(flight);
				}
			}
			return filteredFlights;
		}
		else if (arrival.equals("all")) {
			for(FlightInformation flight : flightModel.getFlightModel()) {
				if(flight.getDepartureLocation().equals(departure))
				{
					filteredFlights.add(flight);
				}
			}
			return filteredFlights;
		}
		for(FlightInformation flight : flightModel.getFlightModel()) {
			if(flight.getDepartureLocation().equals(departure) && flight.getArrivalLocation().equals(arrival))
			{
				filteredFlights.add(flight);
			}
		}
		return filteredFlights;
	}
	
	public class ActionListenerSelectFlight implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(flightView.getSelectedFlightNumber() == -1) {
		        JOptionPane.showMessageDialog(null, "No flight selected!");
		        return;
			}
			SeatSelectionController seatController = new SeatSelectionController(flightView.getSelectedFlightNumber());
			System.out.println("Moving to seat view for: " + flightView.getSelectedFlightNumber());
			flightView.setVisible(false);
		}
		
	}
	
	public class ActionListenerFilterFlight implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String departure = flightView.getSelectedDeparture();
			String arrival = flightView.getSelectedArrival();
			
			ArrayList<FlightInformation> filteredFlights = getFilteredFlights(departure, arrival);
			if(filteredFlights.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No flights match this filter combination!");
		        return;
			}
			displayFlights(filteredFlights);
		}
		
	}

	public void initiate() {
		flightView.setVisible(true);
	}
	
}