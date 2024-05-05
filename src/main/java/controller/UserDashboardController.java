package controller;

// UserDashboardController.java
public class UserDashboardController {
    private UserDashboardView dashboardView;
    private UserDashboard dashboardModel;
    
    public UserDashboardController(UserInformation user) {
        this.dashboardModel = new UserDashboard(user.getUserID());
        dashboardView = new UserDashboardView();
    }
    
    public void displayDashboard() {
        loadUserData();
        
        // Display user dashboard
        dashboardView.displayUserProfile(dashboardModel.getUserID());
        dashboardView.displayCurrentTickets();
        dashboardView.displayTicketHistory();
    }
    
    private void loadUserData() {
        ArrayList<ReceiptInformation> purchaseHistory = new ArrayList<>();
        dashboardModel.setPurchaseHistory(purchaseHistory);
    }
    
    public void viewTicketDetails(int ticketID) {
        System.out.println("Ticket Details:");
        System.out.println("Ticket ID: " + ticketID);
        System.out.println("Flight Name: " + dashboardModel.getFlightName(ticketID));
        System.out.println("Date: " + dashboardModel.getFlightDate(ticketID));
        System.out.println("Price: " + dashboardModel.getFlightPrice(ticketID));
    }
    
    public void cancelTicket(int ticketID) {
        dashboardModel.removeTicket(ticketID);
        System.out.println("Ticket with ID " + ticketID + " cancelled successfully.");
        displayDashboard();
    }
    
}
