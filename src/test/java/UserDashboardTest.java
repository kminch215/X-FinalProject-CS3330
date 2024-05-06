import controller.UserDashboardController;
import model.ReceiptInformation;
import model.UserDashboard;
import model.UserInformation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.UserDashboardView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDashboardTest {
	
	private UserDashboard dashboardModel;
	private UserDashboardController dashboardController;

	@BeforeEach
	void setUp() throws Exception {
		dashboardController = new UserDashboardController();
		dashboardModel = new UserDashboard(1); // with userID of 1
	}

	@Test
	void testInititalization() {
		assertNotNull(dashboardController);
	}
}
