package model;

public class PaymentInformation {

	private int userID;
	private int creditCardNo;
	
	public PaymentInformation(int userID, int creditCardNo) {
		super();
		this.userID = userID;
		this.creditCardNo = creditCardNo;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCreditCardNo() {
		return creditCardNo;
	}
	public void setCreditCardNo(int creditCardNo) {
		this.creditCardNo = creditCardNo;
	}	
	
}
