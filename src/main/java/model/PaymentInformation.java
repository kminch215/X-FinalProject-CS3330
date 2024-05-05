package model;

public class PaymentInformation {

	private int userID;
	private Long creditCardNo;
	
	public PaymentInformation(int userID, Long creditCardNo) {
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
	public Long getCreditCardNo() {
		return creditCardNo;
	}
	public void setCreditCardNo(Long creditCardNo) {
		this.creditCardNo = creditCardNo;
	}	
	
}
