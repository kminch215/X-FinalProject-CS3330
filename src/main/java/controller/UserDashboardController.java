package controller;

import model.ReceiptInformation;
import model.UserDashboard;
import view.UserDashboardView;

import javax.swing.*;
import java.util.ArrayList;

public class UserDashboardController {
    private UserDashboardView dashboardView;
    private UserDashboard dashboardModel;

    public UserDashboardController(UserDashboardView dashboardView, int userID) {
        this.dashboardView = dashboardView;
        this.dashboardModel = new UserDashboard(userID);
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
        JOptionPane.showMessageDialog(null, "Ticket Details:\n" +
                "Ticket ID: " + ticketID + "\n" +
                "Flight Name: " + dashboardModel.getFlightName(ticketID) + "\n" +
                "Date: " + dashboardModel.getFlightDate(ticketID) + "\n" +
                "Price: " + dashboardModel.getFlightPrice(ticketID));
    }

    public void cancelTicket(int ticketID) {
        dashboardModel.removeTicket(ticketID);
        JOptionPane.showMessageDialog(null, "Ticket with ID " + ticketID + " cancelled successfully.");
        displayDashboard();
    }
}
