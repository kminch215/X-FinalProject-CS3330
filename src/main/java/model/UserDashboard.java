package model;

import java.util.ArrayList;

public class UserDashboard {

	private UserInformation user;
	private ArrayList<ReceiptInformation> purchaseHistory;
	
	public UserDashboard(UserInformation user) {
		super();
		this.user = user;
		purchaseHistory = new ArrayList<>();
		
	}
	
	public int getUserID() {
        return userID;
    }
    
    public void addPurchase(ReceiptInformation receipt) {
        purchaseHistory.add(receipt);
    }
    
    public ArrayList<ReceiptInformation> getPurchaseHistory() {
        return purchaseHistory;
    }
}
