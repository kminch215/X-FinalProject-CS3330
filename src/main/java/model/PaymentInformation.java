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
	public String getCardNumber() {
        return cardNumber;
    }

	//specific methods storing for card information
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }
	
}
