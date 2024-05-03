
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.SeatSelectionController;
import model.SeatInformation;
import model.SeatListModel;

class SeatSelectionTest {
	private SeatSelectionController seatSelectionController;

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}

	@BeforeEach
	void setUp() throws Exception {
		seatSelectionController = new SeatSelectionController(2);
	}

//	@AfterEach
//	void tearDown() throws Exception {
//	}
	
    @Test
    public void testInitialization() {
        assertNotNull(seatSelectionController);
    }

//	@Test
//	void testSeatSelectionController() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testDisplaySeats() {
//		ArrayList<SeatInformation> expected = SeatListModel.getInstance().getSeatModel();
////		ArrayList<SeatInformation> actual = seatSelectionController.displaySeats(expected, 1);
//			
//	}

}
