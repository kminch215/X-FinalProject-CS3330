package model;

import java.util.ArrayList;

public class UserDashboard {

    private static int userID;
    private static ArrayList<ReceiptInformation> purchaseHistory;

    // Private constructor to prevent instantiation from outside
    public UserDashboard(int userID) {
        UserDashboard.userID = userID;
        UserDashboard.purchaseHistory = new ArrayList<>();
    }

    public static int getUser() {
        return userID;
    }

    public static ArrayList<ReceiptInformation> getPurchaseHistory() {
        return purchaseHistory;
    }

    // Method to add a single receipt to the purchase history
    public static void addReceipt(ReceiptInformation receipt) {
        purchaseHistory.add(receipt);
    }
    
}
