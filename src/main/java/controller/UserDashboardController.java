package controller;

import model.UserDashboard;
import view.UserDashboardView;

public class UserDashboardController {

	private UserDashboardView dashboardView;
	private UserDashboard dashboardModel;
	
	public UserDashboardController() {
		super();
		this.dashboardView = new UserDashboardView();
		this.dashboardModel = new UserDashboard(user.getUserID());
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
    
    public void updateProfile(String firstName, String lastName, String email) {
        // Update user profile information
        dashboardModel.getCurrentUser().setFirstName(firstName);
        dashboardModel.getCurrentUser().setLastName(lastName);
        dashboardModel.getCurrentUser().setEmail(email);
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

