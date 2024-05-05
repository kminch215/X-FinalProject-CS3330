package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserDashboard {
	private static int userID;
    private static ArrayList<ReceiptInformation> purchaseHistory;

    // Private constructor to prevent instantiation from outside
    public UserDashboard(int userID) {
        UserDashboard.userID = userID;
        UserDashboard.purchaseHistory = new ArrayList<>();
    }
    public static void setUserID(int userID) {
    	UserDashboard.userID = userID;
    }
    public static int getUserID() {
        return userID;
    }
    public static ArrayList<ReceiptInformation> getPurchaseHistory() {
        return purchaseHistory;
    }

    // Method to add a single receipt to the purchase history
    public static void addReceipt(ReceiptInformation receipt) {
        purchaseHistory.add(receipt);
    }
    
    public void setPurchaseHistory(ArrayList<ReceiptInformation> purchaseHistory) {
        UserDashboard.purchaseHistory = purchaseHistory;
    }

    public String getFlightName(int ticketID) {
        for (ReceiptInformation receipt : purchaseHistory) {
            if (receipt.getReceiptID() == ticketID) {
                return "Flight Name: " + receipt.getFlightNumber();
            }
        }
        return "Flight Name not found for Ticket ID " + ticketID;
    }

    public double getFlightPrice(int ticketID) {
        for (ReceiptInformation receipt : purchaseHistory) {
            if (receipt.getReceiptID() == ticketID) {
                return receipt.calculateTotal();
            }
        }
        return 0.0; // Default price if not found
    }

    public void removeTicket(int ticketID) {
        for (ReceiptInformation receipt : purchaseHistory) {
            if (receipt.getReceiptID() == ticketID) {
                purchaseHistory.remove(receipt);
                return;
            }
        }
        System.out.println("Ticket with ID " + ticketID + " not found.");
    } 
    
    public List<String> getCurrentTickets() {
        List<String> currentTickets = new ArrayList<>();
        for (ReceiptInformation receipt : purchaseHistory) {
            currentTickets.add(formatTicketInformation(receipt));
        }
        return currentTickets;
    }

    public List<String> getTicketHistory() {
        List<String> ticketHistory = new ArrayList<>();
        for (ReceiptInformation receipt : purchaseHistory) {
            ticketHistory.add(formatTicketHistory(receipt));
        }
        return ticketHistory;
    }

    private String formatTicketInformation(ReceiptInformation receipt) {
        return "Ticket ID: " + receipt.getReceiptID() + ", Flight: " + receipt.getFlightNumber();
    }

    private String formatTicketHistory(ReceiptInformation receipt) {
        return "Ticket ID: " + receipt.getReceiptID() + ", Purchase Date: " + ", Total Price: " + receipt.calculateTotal();
    }

}
