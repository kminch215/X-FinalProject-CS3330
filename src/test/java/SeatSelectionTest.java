import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.FlightListController;

class SeatSelectionTest {

	private FlightListController flightListController;

    @BeforeEach
    public void setUp() {
        flightListController = new FlightListController();
    }

    @Test
    public void testInitialization() {
        assertNotNull(flightListController);
    }
    

}
