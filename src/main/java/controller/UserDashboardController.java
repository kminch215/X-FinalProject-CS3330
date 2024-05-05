package controller;

import model.ReceiptInformation;
import model.UserDashboard;
import view.UserDashboardView;
import model.UserInformation;
import model.UserListModel;

import javax.swing.*;
import java.util.ArrayList;

public class UserDashboardController {
    private UserDashboardView dashboardView;
    private UserDashboard dashboardModel;
    private UserListModel userListModel;

    public UserDashboardController() {
        this.dashboardView = new UserDashboardView(); 
        this.dashboardModel = new UserDashboard(UserDashboard.getUserID());
        this.dashboardView.setVisible(true);
    }

    public void displayDashboard() {
        loadUserData();

        // Display user dashboard
        dashboardView.displayUserProfile(UserDashboard.getUserID());
        dashboardView.displayCurrentTickets(dashboardModel.getCurrentTickets());
        dashboardView.displayTicketHistory(dashboardModel.getTicketHistory());
    }

    private void loadUserData() {
        ArrayList<ReceiptInformation> purchaseHistory = new ArrayList<>();
        dashboardModel.setPurchaseHistory(purchaseHistory);
    }

    public void updateProfile(String firstName, String lastName, String email) {
        // Update user profile information
        for(UserInformation user : userListModel.getUserList()) {
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setEmail(email);
        }
    }

    public void viewTicketDetails(int ticketID) {
        JOptionPane.showMessageDialog(null, "Ticket Details:\n" +
                "Ticket ID: " + ticketID + "\n" +
                "Flight Name: " + dashboardModel.getFlightName(ticketID) + "\n" +
                "Price: " + dashboardModel.getFlightPrice(ticketID));
    }

    public void cancelTicket(int ticketID) {
        dashboardModel.removeTicket(ticketID);
        JOptionPane.showMessageDialog(null, "Ticket with ID " + ticketID + " cancelled successfully.");
        displayDashboard();
    }
}
