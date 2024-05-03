package controller;

import model.PaymentListModel;
import view.PaymentView;

public class PaymentController {

	private PaymentView paymentView;
	private PaymentListModel paymentModel;
	
	public PaymentController(int[] selectedSeats) {
		super();
		this.paymentView = new PaymentView();
		this.paymentModel = new PaymentListModel();
	}
	
}
