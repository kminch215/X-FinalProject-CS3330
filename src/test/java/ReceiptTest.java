import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PaymentController;
import controller.ReceiptController;

class ReceiptTest {
	
	private ReceiptController receiptController;

	@BeforeEach
	void setUp() throws Exception {
		receiptController = new ReceiptController();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

    @Test
    public void testInitialization() {
        assertNotNull(receiptController);
    }
}
