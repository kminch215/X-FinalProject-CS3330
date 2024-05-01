package controller;

import model.ReceiptListModel;
import view.ReceiptView;

public class ReceiptController {

	private ReceiptView receiptView;
	private ReceiptListModel receiptModel;
	
	public ReceiptController() {
		super();
		this.receiptView = new ReceiptView();
		this.receiptModel = new ReceiptListModel();
	}
	
}
