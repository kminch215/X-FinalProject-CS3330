package model;

import java.util.ArrayList;

public class PaymentListModel {

	private ArrayList<PaymentInformation> paymentModel;

	public PaymentListModel() {
		super();
		this.paymentModel = new ArrayList<PaymentInformation>();
	}

	public ArrayList<PaymentInformation> getPaymentModel() {
		return paymentModel;
	}

	public void setPaymentModel(ArrayList<PaymentInformation> paymentModel) {
		this.paymentModel = paymentModel;
	}
	
}

