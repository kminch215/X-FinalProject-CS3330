package model;

import java.util.ArrayList;

public class ReceiptListModel {

	private ArrayList<ReceiptInformation> receiptList;

	public ReceiptListModel() {
		super();
		this.receiptList = new ArrayList<ReceiptInformation>();
	}

	public ArrayList<ReceiptInformation> getReceiptList() {
		return receiptList;
	}

	public void setReceiptList(ArrayList<ReceiptInformation> receiptList) {
		this.receiptList = receiptList;
	}
	
}
