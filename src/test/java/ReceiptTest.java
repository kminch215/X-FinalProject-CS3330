import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PaymentController;
import controller.ReceiptController;
import controller.SeatSelectionController;
import model.EconomySeat;
import model.FirstClassSeat;
import model.ReceiptInformation;
import model.ReceiptListModel;
import model.SeatInformation;
import model.SeatListModel;
import model.UserDashboard;

/**
 * @author Samantha Whitaker
 * This is the JUnit test file for all Receipt files
 */
class ReceiptTest {
	
	private UserDashboard userDashboard;
	private ReceiptController receiptController;
	private ReceiptListModel receiptListModel;
	private ArrayList<SeatInformation> seats;

	@BeforeEach
	void setUp() throws Exception {
		userDashboard = new UserDashboard(0);
		receiptController = new ReceiptController();
		receiptListModel = receiptController.getReceiptModel();
		seats = new ArrayList<>();
    	seats.add(new EconomySeat(1, 1, 300.0));
    	seats.add(new EconomySeat(1, 2, 300.0));
    	seats.add(new FirstClassSeat(1, 3, 900.0));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

    @Test
    public void testInitialization() {
        assertNotNull(receiptController);
    }
    
    @Test
    public void testCalculateTotal() {
    	ReceiptInformation receipt = new ReceiptInformation(1, 1, seats);
    	double total = receipt.calculateTotal();
    	
    	assertEquals(1500.0, total, 0.01);
    }
    
    @Test 
    public void testGetAndSetUserID() {
    	ReceiptInformation receipt = new ReceiptInformation(1, 1, seats);
    	receipt.setUserID(2);
    	int userID = receipt.getUserID();
    	
    	assertEquals(2, userID);
    }
    
    @Test 
    public void testGetAndSetReceiptID() {
    	ReceiptInformation receipt = new ReceiptInformation(1, 1, seats);
    	receipt.setReceiptID(3);;
    	int receiptID = receipt.getReceiptID();
    	
    	assertEquals(3, receiptID);
    }
    
    @Test 
    public void testGetTotalPrice() {
    	ReceiptInformation receipt = new ReceiptInformation(1, 1, seats);
    	receipt.setTotalPrice(120.0);
    	double total = receipt.getTotalPrice();
    	
    	assertEquals(120.0, total, 0.01);
    }
    
    @Test 
    public void testToString() {
    	ReceiptInformation receipt = new ReceiptInformation(1, 1, seats);
    	String expected = "Flight Number: " + 1 + "               Order Price: " + 1500.00;
    	
    	assertEquals(expected, receipt.toString());
    }
    
    @Test 
    public void testCancelSelectedSeat() {
    	ArrayList<SeatInformation> localSeats = new ArrayList<>();
    	ReceiptInformation receipt = new ReceiptInformation(1, 1, localSeats);
    	receiptListModel.getReceiptList().add(receipt);

    	SeatInformation availableSeat = new EconomySeat(1, 4, 300.0);
    	SeatInformation seatToRemove = new EconomySeat(1, 5, 300.0);
    	
    	SeatListModel seatListModel = SeatListModel.getInstance();
    	seatListModel.addSeat(availableSeat);
    	receipt.getSeats().add(seatToRemove);
    	
    	receiptController.cancelSelectedSeat(receipt, seatToRemove);

    	// check that seat was removed from receipt
    	assertFalse(receipt.getSeats().contains(seatToRemove));
    	// check that seat is added back to available seats list
    	assertTrue(seatListModel.getSeatModel().contains(seatToRemove));
    	// check that total price is updated
    	assertEquals(0.0, receipt.getTotalPrice(), 0.01);
    	
    }
    
    @Test
    public void testCancelBooking() {
    	ArrayList<SeatInformation> localSeats = new ArrayList<>();
    	ReceiptInformation receipt = new ReceiptInformation(1, 1, localSeats);

    	receiptListModel.getReceiptList().add(receipt);
    	SeatInformation seat1 = new EconomySeat(1, 4, 300.0);
    	SeatInformation seat2 = new EconomySeat(1, 5, 300.0);
    	
    	receipt.getSeats().add(seat1);
    	receipt.getSeats().add(seat2);
    	
    	receiptController.cancelBooking(receipt);
    	
    	// check that seats are added back to the available seat list
    	assertTrue(SeatListModel.getInstance().getSeatModel().contains(seat1));
    	assertTrue(SeatListModel.getInstance().getSeatModel().contains(seat1));
    	// check that total price is updated to zero
    	assertEquals(0.0, receipt.getTotalPrice(), 0.01);
    }
    
    @Test
    public void testBookAdditionalSeat() {
    	ArrayList<SeatInformation> localSeats = new ArrayList<>();
    	ReceiptInformation receipt = new ReceiptInformation(1, 1, localSeats);

    	receiptController.getReceiptModel().getReceiptList().add(receipt);
    	SeatListModel seatListModel = SeatListModel.getInstance();
    	
    	receiptController.bookAdditionalSeat(receipt);
    	
    	// check that receipt view is invisible
    	assertFalse(receiptController.getReceiptView().isVisible());
    }
}
