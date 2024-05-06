
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.SeatSelectionController;
import model.EconomySeat;
import model.FirstClassSeat;
import model.SeatInformation;
import model.SeatListModel;
import view.SeatSelectionView;

class SeatSelectionTest {
	private SeatSelectionController seatSelectionController;
	private SeatSelectionView seatSelectionView;
	private SeatListModel seatListModel;
	private JTable seatTable;
	private DefaultTableModel model;

	@BeforeEach
	void setUp() throws Exception {
		seatSelectionController = new SeatSelectionController(2);
		seatSelectionView = new SeatSelectionView();
		seatTable = seatSelectionView.getSeatTable();
		seatListModel = SeatListModel.getInstance();
		model = seatSelectionView.getModel();
		model.setRowCount(6);
		Object[][] rowData = {
				{1, "First Class", 1000.0},
				{2, "Economy", 300.0},
				{3, "Economy", 300.0},
				{4, "First Class", 1000.0},
				{5, "First Class", 1000.0},
				{6, "Economy", 300.0}
		};
		for(int i=0; i<6; i++) {
			model.setValueAt(rowData[i][0], i, 0);
			model.setValueAt(rowData[i][1], i, 1);
			model.setValueAt(rowData[i][2], i, 2);
		}
	}

	
    @Test
    public void testInitialization() {
        assertNotNull(seatSelectionController);
    }


	@Test
	void testGetSelectedSeatNumbers() {
		seatTable.addRowSelectionInterval(0, 0);
		seatTable.addRowSelectionInterval(2, 2);
		seatTable.addRowSelectionInterval(4, 4);
		
		int[] expected = {1,3,5};
		
		assertArrayEquals(expected, seatSelectionView.getSelectedSeatNumbers());		
	}
	
	@Test
	public void testAddSeatTrue() {
		ArrayList<SeatInformation> seatList = SeatListModel.getInstance().getSeatModel();
		int initialSize = seatList.size();
		SeatInformation newSeat = new EconomySeat(1, 10, 300.0);
		SeatListModel.getInstance().addSeat(newSeat);
		
		// tests if newSeat was successfully added to seatList
		assertEquals(initialSize + 1, SeatListModel.getInstance().getSeatModel().size());
	}
	
	@Test
	public void testAddSeatFalse() {
		ArrayList<SeatInformation> seatList = SeatListModel.getInstance().getSeatModel();
		int initialSize = seatList.size();
		SeatInformation existingSeat = seatList.get(0);
		SeatListModel.getInstance().addSeat(existingSeat);
		
		// tests if existingSeat was NOT successfully added to seatList
		assertEquals(initialSize, SeatListModel.getInstance().getSeatModel().size());
	}
	
	@Test
	public void testSetEconomySeatPrice() {
		EconomySeat econSeat = new EconomySeat(1, 10, 200.00);
		econSeat.setSeatPrice(300.00);
		
		assertEquals(300.00, econSeat.getSeatPrice());
	}
	
	@Test
	public void testSetFirstClassSeatPrice() {
		FirstClassSeat FCSeat = new FirstClassSeat(1, 10, 900.00);
		FCSeat.setSeatPrice(1000.00);
		
		assertEquals(1000.00, FCSeat.getSeatPrice());
	}
	
	@Test
	public void testSeatDescription() {
		SeatInformation seat = new EconomySeat(1, 10, 200.00);
		SeatInformation seat1 = new FirstClassSeat(1, 10, 900.00);

		assertEquals("This is an Economy Seat", seat.seatDescription());
		assertEquals("This is a First Class Seat", seat1.seatDescription());

	}
	
	@Test
	public void testSetFlightNumber() {
		FirstClassSeat FCSeat = new FirstClassSeat(1, 10, 900.00);
		FCSeat.setFlightNumber(2);
		
		assertEquals(2, FCSeat.getFlightNumber());
	}
	
	@Test
	public void testSetSeatNumber() {
		FirstClassSeat FCSeat = new FirstClassSeat(1, 10, 900.00);
		FCSeat.setSeatNumber(5);
		
		assertEquals(5, FCSeat.getSeatNumber());
	}
	
//	@Test
//	public void testIntArrayToArrayList() {
//		ArrayList<SeatInformation> seatList = new ArrayList<>();
//		seatList.add(new EconomySeat(1, 1, 300.0));
//		seatList.add(new EconomySeat(1, 4, 300.0));
//		seatList.add(new FirstClassSeat(1, 3, 900.0));
//		seatList.add(new EconomySeat(1, 2, 300.0));
//		seatListModel.addSeat(new EconomySeat(1, 1, 300.0));
//		seatListModel.addSeat(new EconomySeat(1, 4, 300.0));
//		seatListModel.addSeat(new FirstClassSeat(1, 3, 900.0));
//		seatListModel.addSeat(new EconomySeat(1, 2, 300.0));
//
//		int[] seats = {1,4};
//		ArrayList<SeatInformation> expected = new ArrayList<>();
//		expected.add(new EconomySeat(1, 1, 300.0));
//		expected.add(new EconomySeat(1, 4, 300.0));
//
//		ArrayList<SeatInformation> actual = seatSelectionController.intArrayToArrayList(seats);
//		assertEquals(expected, actual);
//	}

}
