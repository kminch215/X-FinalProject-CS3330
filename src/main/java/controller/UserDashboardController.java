package controller;

import model.ReceiptInformation;
import model.UserDashboard;
import model.UserInformation; // Added import statement for UserInformation
import view.UserDashboardView;

import javax.swing.*;
import java.util.ArrayList;

public class UserDashboardController {
    private UserDashboardView dashboardView;
    private UserDashboard dashboardModel;

    // Constructor updated to accept UserInformation parameter
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

    // Removed updateProfile method due to conflict

    public void viewTicketDetails(int ticketID) {
        JOptionPane.showMessageDialog(null, "Ticket Details:\n" +
                "Ticket ID: " + ticketID + "\n" +
                "Flight Name: " + dashboardModel.getFlightName(ticketID) + "\n" +
                "Date: " + dashboardModel.getFlightDate(ticketID) + "\n" +
                "Price: " + dashboardModel.getFlightPrice(ticketID));
    }

    public void cancelTicket(int ticketID) {
        dashboardModel.removeTicket(ticketID);
        System.out.println("Ticket with ID " + ticketID + " cancelled successfully.");
        displayDashboard();
    }
}
