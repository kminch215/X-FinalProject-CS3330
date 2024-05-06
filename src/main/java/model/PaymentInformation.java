package model;

/**
 * Class that sets up the information stored for payment
 */
public class PaymentInformation {

	private int userID;
	private Long creditCardNo;
	
	//parameterized constructor
	public PaymentInformation(int userID, Long creditCardNo) {
		super();
		this.userID = userID;
		this.creditCardNo = creditCardNo;
	}
	
	//getter for the user ID
	public int getUserID() {
		return userID;
	}
	
	//setter for the user ID
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	//getter for the credit card number
	public Long getCreditCardNo() {
		return creditCardNo;
	}
	
	//setter for the credit card number
	public void setCreditCardNo(Long creditCardNo) {
		this.creditCardNo = creditCardNo;
	}
}