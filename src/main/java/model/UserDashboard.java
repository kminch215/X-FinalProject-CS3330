package model;

import java.util.ArrayList;

public class UserDashboard {

	private UserInformation user;
	private ArrayList<ReceiptInformation> purchaseHistory;
	
	public UserDashboard(UserInformation user) {
		super();
		this.user = user;
		//this.purchaseHistory = purchaseHistory;
		//use another class to load the purchaseHistory from another method
	}
	
	
}
