
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.SeatSelectionController;
import model.EconomySeat;
import model.SeatInformation;
import model.SeatListModel;
import view.SeatSelectionView;

class SeatSelectionTest {
	private SeatSelectionController seatSelectionController;
	private SeatSelectionView seatSelectionView;
	private JTable seatTable;
	private DefaultTableModel model;

	@BeforeEach
	void setUp() throws Exception {
		seatSelectionController = new SeatSelectionController(2);
		seatSelectionView = new SeatSelectionView();
		seatTable = seatSelectionView.getSeatTable();
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

}
