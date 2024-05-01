import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import controller.FlightListController;
import model.FlightInformation;
import model.FlightListModel;

class SeatSelectionTest {

	private static FlightListController flightListController;

    @BeforeEach
    public void setUp() {
        flightListController = new FlightListController();
    }

    @Test
    public void testInitialization() {
        assertNotNull(flightListController);
    }
    
    @ParameterizedTest
    @MethodSource("provideInputsForTestDisplayingFilteredFlights")
    public void testDisplayingFilteredFlights(ArrayList<FlightInformation> expected, ArrayList<FlightInformation> actual) {
        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getFlightNumber(), actual.get(i).getFlightNumber());
            assertEquals(expected.get(i).getDepartureLocation(), actual.get(i).getDepartureLocation());
            assertEquals(expected.get(i).getArrivalLocation(), actual.get(i).getArrivalLocation());
            assertEquals(0, expected.get(i).getDate().compareTo(actual.get(i).getDate()));
        }
    }

    private static Stream<Arguments> provideInputsForTestDisplayingFilteredFlights() {
        FlightListModel flightModel = new FlightListModel();
        flightModel.initializeFlights();
        ArrayList<FlightInformation> actual1 = flightListController.displaySelectedFlights("all", "all");
        ArrayList<FlightInformation> actual2 = flightListController.displaySelectedFlights("St. Louis", "all");
        ArrayList<FlightInformation> actual3 = flightListController.displaySelectedFlights("all", "Phoenix");
        ArrayList<FlightInformation> actual4 = flightListController.displaySelectedFlights("Boston", "Kansas City");
        
        LocalDate date2 = LocalDate.of(2024, 8, 24);
        LocalDate date3 = LocalDate.of(2024, 7, 6);
        LocalDate date4 = LocalDate.of(2024, 12, 13);
        
        ArrayList<FlightInformation> expected1 = flightModel.getFlightModel();
        ArrayList<FlightInformation> expected2 = new ArrayList<FlightInformation>();
        expected2.add(new FlightInformation(1, "St. Louis", "Destin", Date.valueOf(date2)));
        ArrayList<FlightInformation> expected3 = new ArrayList<FlightInformation>();
        expected3.add(new FlightInformation(2, "Los Angeles", "Phoenix", Date.valueOf(date3)));
        ArrayList<FlightInformation> expected4 = new ArrayList<FlightInformation>();
        expected4.add(new FlightInformation(4, "Boston", "Kansas City", Date.valueOf(date4)));

        return Stream.of(
                Arguments.of(expected1, actual1),
                Arguments.of(expected2, actual2),
                Arguments.of(expected3, actual3),
                Arguments.of(expected4, actual4)
        );
    }
}
