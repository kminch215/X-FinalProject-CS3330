package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserDashboard {
	private static int userID;
    private static ArrayList<ReceiptInformation> purchaseHistory = new ArrayList<>();

    public UserDashboard(int userID) {
        UserDashboard.userID = userID;
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
        UserDashboard.purchaseHistory.add(receipt);
    }
}
