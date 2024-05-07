package model;

import java.util.ArrayList;

/**
 * Class that allows for an array of PaymentInformation to be implemented
 */
public class PaymentListModel {

	private ArrayList<PaymentInformation> paymentModel;

	//default constructor
	public PaymentListModel() {
		super();
		this.paymentModel = new ArrayList<PaymentInformation>();
	}

	//getter for the paymentModel
	public ArrayList<PaymentInformation> getPaymentModel() {
		return paymentModel;
	}

	//setter for the paymentModel
	public void setPaymentModel(ArrayList<PaymentInformation> paymentModel) {
		this.paymentModel = paymentModel;
	}
	
}

