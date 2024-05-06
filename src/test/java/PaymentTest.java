import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PaymentController;
import model.PaymentInformation;
import model.PaymentListModel;
import model.ReceiptInformation;
import model.SeatInformation;

/**
 * @author Samantha Whitaker
 */

class PaymentTest {
    private PaymentListModel paymentListModel;
    private PaymentController paymentController;
	private ArrayList<SeatInformation> seats;


    @BeforeEach
    public void setUp() {
		seats = new ArrayList<>();
    	paymentListModel = new PaymentListModel();
    	paymentController = new PaymentController(seats);
    }
    
    @Test
    public void testInitialization() {
        assertNotNull(paymentController);
    }
    
    @Test
    public void testHash() {
    	// Test case 1: valid credit card number
    	String hashedCardNumber = paymentController.hash("1234123412341234");
    	assertEquals("XXXXXXXXXXXX1234", hashedCardNumber);
    	
    	// Test case 2: invalid credit card number
    	String invalidHashedCard = paymentController.hash("123");
    	assertEquals("Invalid card number", invalidHashedCard);
    }
    
    @Test 
    public void testGetAndSetUserID() {
    	PaymentInformation payment = new PaymentInformation(1, null);
    	payment.setUserID(2);
    	int userID = payment.getUserID();
    	
    	assertEquals(2, userID);
    }

}
