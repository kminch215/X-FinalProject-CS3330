package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import model.FlightInformation;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class FlightListView extends JFrame {

	private JPanel contentPanel;
	private JTable flightTable;
    private JButton selectFlight;
    private DefaultTableModel model;
    private JLabel flightSelectorLabel;
    private JLabel filterFlights;
    private JLabel departureLabel;
    private JComboBox<String> departureDropDown;
    private JLabel arrivalLabel;
    private JComboBox<String> arrivalDropDown;
    private JButton filterButton;

	
	public FlightListView() {
		setTitle("Flight List View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		getContentPane().setLayout(null);
		
		//Create header for the view
		flightSelectorLabel = new JLabel("Flight Selector");
		flightSelectorLabel.setLocation(0, 0);
		flightSelectorLabel.setSize(484, 20);
        flightSelectorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        flightSelectorLabel.setFont(new Font("Sitka Heading", Font.BOLD, 16));
        
        //Create the filter componenets
        filterFlights = new JLabel("Filter by: ");
        filterFlights.setFont(new Font("Sitka Heading", Font.BOLD, 12));
        filterFlights.setBounds(20, 31, 60, 20);
        flightSelectorLabel.setFont(new Font("Sitka Heading", Font.BOLD, 10));
        
        departureLabel = new JLabel("Departure");
        departureLabel.setFont(new Font("Sitka Small", Font.BOLD, 7));
        departureLabel.setBounds(90, 31, 48, 18);
        
        departureDropDown = new JComboBox<>();
        departureDropDown.setBounds(134, 29, 73, 20);
        
        arrivalLabel = new JLabel("Arrival");
        arrivalLabel.setFont(new Font("Sitka Small", Font.BOLD, 7));
        arrivalLabel.setBounds(217, 31, 35, 18);
        
        arrivalDropDown = new JComboBox<>();
        arrivalDropDown.setBounds(245, 29, 73, 20);
        
        filterButton = new JButton("Filter");
        filterButton.setBounds(368, 31, 73, 20);
		
		// Create table model for flights
		model = new DefaultTableModel();
        flightTable = new JTable(model);

        // Add columns to the table model
        model.addColumn("Flight Number");
        model.addColumn("Departure");
        model.addColumn("Arrival");
        
        //setting the formatting of the table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        flightTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
     
        selectFlight = new JButton("Select Flight");
        selectFlight.setLocation(0, 331);
        selectFlight.setSize(500, 30);
        
        // Add components to the frame
        JScrollPane scrollPane = new JScrollPane(flightTable);
        scrollPane.setSize(440, 250);
        scrollPane.setLocation(20, 60);
        contentPanel.add(flightSelectorLabel);
        contentPanel.add(filterFlights);
        contentPanel.add(departureLabel);
        contentPanel.add(departureDropDown);
        contentPanel.add(arrivalLabel);
        contentPanel.add(arrivalDropDown);
        contentPanel.add(filterButton);
        contentPanel.add(scrollPane);
        contentPanel.add(selectFlight);
	}
	
	public void addDepartureFilterItems(String departure) {
		departureDropDown.addItem(departure);
	}
	
	public void addArrivalFilterItems(String arrival) {
		arrivalDropDown.addItem(arrival);
	}
	
	public void addFlightInformationToView(FlightInformation flight) {
		model.addRow(new Object[] {flight.getFlightNumber(), flight.getDepartureLocation(), flight.getArrivalLocation()});
	}
	
	public void addActionListenerToSelectFlightButton(ActionListener listener) {
		selectFlight.addActionListener(listener);
	}
	
	public void addActionListenerToFilterButton(ActionListener listener) {
		filterButton.addActionListener(listener);
	}
	
	public int getSelectedFlightNumber() {
		int rowNumber = flightTable.getSelectedRow();
		return (int) model.getValueAt(rowNumber, 0);
	}
	
	public void clearFlightTable() {
		model.setRowCount(0);
		return;
	}
	
	public String getSelectedDeparture() {
		if(departureDropDown.getSelectedIndex() != -1)
			return (String)departureDropDown.getSelectedItem();
		return "no selection";
	}
	
	public String getSelectedArrival() {
		if(arrivalDropDown.getSelectedIndex() != -1)
			return (String)arrivalDropDown.getSelectedItem();
		return "no selection";
	}
}

