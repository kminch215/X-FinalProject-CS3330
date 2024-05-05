import controller.UserDashboardController;
import model.ReceiptInformation;
import model.UserDashboard;
import model.UserInformation;
import org.junit.jupiter.api.Test;
import view.UserDashboardView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDashboardTest {
    @Test
    void testUserDashboard() {
        UserInformation user = new UserInformation(1, "username", "password", "John", "Doe", "john@example.com");
        UserDashboard dashboard = new UserDashboard(user);
        assertEquals(1, dashboard.getUserID());
        
        ReceiptInformation receipt = new ReceiptInformation(1, "Product 1", 100.0);
        dashboard.addPurchase(receipt);
        assertEquals(1, dashboard.getPurchaseHistory().size());
    }

    @Test
    void testUserDashboardView() {
        UserDashboardView dashboardView = new UserDashboardView();
        dashboardView.displayUserProfile(1);
        assertEquals("User Profile for UserID: 1", dashboardView.getUserIDLabel().getText());

        List<String> tickets = new ArrayList<>();
        tickets.add("Ticket 1");
        tickets.add("Ticket 2");
        dashboardView.displayCurrentTickets(tickets);
        assertTrue(dashboardView.getCurrentTicketsLabel().getText().contains("Ticket 1"));
        assertTrue(dashboardView.getCurrentTicketsLabel().getText().contains("Ticket 2"));

        List<String> history = new ArrayList<>();
        history.add("Event 1");
        history.add("Event 2");
        dashboardView.displayTicketHistory(history);
        assertTrue(dashboardView.getTicketHistoryLabel().getText().contains("Event 1"));
        assertTrue(dashboardView.getTicketHistoryLabel().getText().contains("Event 2"));
    }

    @Test
    void testUserDashboardController() {
        UserDashboardView dashboardView = new UserDashboardView();
        UserInformation user = new UserInformation(1, "username", "password", "John", "Doe", "john@example.com");
        UserDashboardController controller = new UserDashboardController(dashboardView, user.getUserID());
        controller.displayDashboard();
        // Additional test cases can be added for other methods in UserDashboardController
    }
}
