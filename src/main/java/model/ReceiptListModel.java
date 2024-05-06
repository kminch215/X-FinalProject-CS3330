package model;

import java.util.ArrayList;

/**
 * This helps to maintain the group of receipts by using an array list
 */
public class ReceiptListModel {

	private ArrayList<ReceiptInformation> receiptList;

	//default constructor
	public ReceiptListModel() {
		super();
		this.receiptList = new ArrayList<ReceiptInformation>();
	}

	//getter for the receiptList
	public ArrayList<ReceiptInformation> getReceiptList() {
		return receiptList;
	}

	//setter for the receiptList
	public void setReceiptList(ArrayList<ReceiptInformation> receiptList) {
		this.receiptList = receiptList;
	}
	
}
