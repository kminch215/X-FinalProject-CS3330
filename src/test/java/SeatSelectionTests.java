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

class SeatSelectionTests {
	private SeatSelectionController seatSelectionController;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testSeatSelectionController() {
//		fail("Not yet implemented");
//	}

	@Test
	void testDisplaySeats() {
		SeatListModel model = model.getInstance();
		ArrayList<SeatInformation> expected = model.getInstance().getSeatModel();
//		ArrayList<SeatInformation> actual = seatSelectionController.displaySeats("all", "all");
		
		
		
	}

}
