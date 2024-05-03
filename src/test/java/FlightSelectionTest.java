import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import controller.FlightListController;
import model.FlightInformation;
import model.FlightListModel;

class FlightSelectionTest {

	private FlightListController flightListController;

    @BeforeEach
    public void setUp() {
        flightListController = new FlightListController();
    }

    @Test
    public void testInitialization() {
        assertNotNull(flightListController);
    }
    
    @Test
    public void testDisplayingFilteredFlights() {
    	FlightListModel flightModel = new FlightListModel();
        flightModel.initializeFlights();
        
        ArrayList<FlightInformation> expected = flightModel.getFlightModel(); // Get the expected list
        
        // Assuming displaySelectedFlights filters correctly and returns a list
        ArrayList<FlightInformation> actual = flightListController.displaySelectedFlights("all", "all");

        assertEquals(expected.size(), actual.size()); // First check if the sizes are equal

        for(int i = 0; i < expected.size(); i++) {
        	assertEquals(expected.get(i).getFlightNumber(), actual.get(i).getFlightNumber());
        	assertEquals(expected.get(i).getDepartureLocation(), actual.get(i).getDepartureLocation());
        	assertEquals(expected.get(i).getArrivalLocation(), actual.get(i).getArrivalLocation());
        	assertEquals(0, expected.get(i).getDate().compareTo(actual.get(i).getDate()));
        }
    }
}
