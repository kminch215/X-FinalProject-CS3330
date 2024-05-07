package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will contain the information regarding the user that is currently being logged in
 */
public class UserDashboard {
	private static int userID;
    private static ArrayList<ReceiptInformation> purchaseHistory = new ArrayList<>();

    //parameterized constructor
    public UserDashboard(int userID) {
        UserDashboard.userID = userID;
    }
    
    //setter for the user ID
    public static void setUserID(int userID) {
    	UserDashboard.userID = userID;
    }
    
    //geter for the user ID
    public static int getUserID() {
        return userID;
    }
    
    //getter for the purchase history
    public static ArrayList<ReceiptInformation> getPurchaseHistory() {
        return purchaseHistory;
    }

    // Method to add a single receipt to the purchase history
    public static void addReceipt(ReceiptInformation receipt) {
        UserDashboard.purchaseHistory.add(receipt);
    }
}
