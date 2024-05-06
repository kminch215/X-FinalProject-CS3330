import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PaymentController;
import controller.ReceiptController;
import model.EconomySeat;
import model.FirstClassSeat;
import model.ReceiptInformation;
import model.SeatInformation;
import model.UserDashboard;

class ReceiptTest {
	
	private UserDashboard userDashboard;
	private ReceiptController receiptController;
	private ArrayList<SeatInformation> seats;

	@BeforeEach
	void setUp() throws Exception {
		userDashboard = new UserDashboard(0);
		receiptController = new ReceiptController();
		seats = new ArrayList<>();
    	seats.add(new EconomySeat(1, 1, 300.0));
    	seats.add(new EconomySeat(1, 1, 300.0));
    	seats.add(new FirstClassSeat(1, 1, 900.0));
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
}
