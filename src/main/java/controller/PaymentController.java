package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.PaymentInformation;
import model.PaymentListModel;

import model.ReceiptInformation;
import model.SeatInformation;
import model.SeatListModel;
import model.UserDashboard;
import view.PaymentView;

/**
 * Payment controller to handle the functionality between the view and the controller
 */
public class PaymentController {

    private PaymentView paymentView;
    private PaymentListModel paymentModel;
    private ArrayList<SeatInformation> seats;

    /**
     * Constructor that takes in a seat list so that the payment controller knows how much the payment needs
     * to be. Also sets up the model and the view along with setting the view to visible.
     * 
     * @param seats
     */
    public PaymentController(ArrayList<SeatInformation> seats) {
        this.paymentView = new PaymentView();
        this.paymentModel = new PaymentListModel();
        this.seats = seats;
        this.paymentView.setVisible(true);

        this.paymentView.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateAndProcessPayment();
            }
        });
    }

    /**
     * This handles all the error handling for the payment process. Ensures that the credit card, CVV, and the 
     * card expiration date is valid
     */
    public void validateAndProcessPayment() {
        String cardNumber = paymentView.getCardNumberField().getText();
        String cvvNumber = paymentView.getCvvField().getText();
        String expirationMonth = paymentView.getExpirationMonthField().getText();
        String expirationYear = paymentView.getExpirationYearField().getText();

        if (!isValidCardNumber(cardNumber)) {
            JOptionPane.showMessageDialog(null, "Invalid card number. Please enter 16 digits.");
            return;
        }

        if (!isValidCVV(cvvNumber)) {
            JOptionPane.showMessageDialog(null, "Invalid CVV. Please enter 3 digits.");
            return;
        }

        if (!isValidExpirationMonth(expirationMonth)) {
            JOptionPane.showMessageDialog(null, "Invalid month. Please enter a number between 01 and 12.");
            return;
        }

        if (!isValidExpirationYear(expirationYear)) {
            JOptionPane.showMessageDialog(null, "Invalid year. Please enter a 2-digit year between 19 and 29.");
            return;
        }

        // If all validations pass, process payment or any other actions here
        processPayment(cardNumber, cvvNumber, expirationMonth, expirationYear);
    }

    //Methods that will check the strings to make sure they are valid
    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{16}");
    }

    private boolean isValidCVV(String cvvNumber) {
        return cvvNumber.matches("\\d{3}");
    }

    private boolean isValidExpirationMonth(String month) {
        return month.matches("^(0?[1-9]|1[012])$");
    }

    private boolean isValidExpirationYear(String year) {
        return year.matches("^(1[9]|[2-9][0-9])$");
    }

    /**
     * This will finish processing the payment by creating new payment information, creating a receipt to be
     * stored in the UserDashboard paymentHistory ArrayList. This method will also call the removeSeat method which
     * will remove the seats that just were bought from the SeatListModel. Finally, it will remove the payment view
     * and will display the receipt controller.
     * 
     * @param cardNumber
     * @param cvvNumber
     * @param expirationMonth
     * @param expirationYear
     */
    private void processPayment(String cardNumber, String cvvNumber, String expirationMonth, String expirationYear) {
    	PaymentInformation newPayment = new PaymentInformation(1, Long.parseLong(cardNumber));
    	paymentModel.getPaymentModel().add(newPayment);
        JOptionPane.showMessageDialog(null, "Payment Successful!");
        ReceiptInformation receipt = new ReceiptInformation(UserDashboard.getUserID(), seats.get(0).getFlightNumber(), seats);
        UserDashboard.addReceipt(receipt); //This is not adding the receipt to the receipt model
        for(SeatInformation seat : seats) {
        	SeatListModel.removeSeat(seat);
        }
        
        paymentView.setVisible(false);
        ReceiptController receiptController = new ReceiptController();
    }
    
    //for later
    public String hash(String cardNumber) {
        if (cardNumber.length() >= 4) {
            String lastFourDigits = cardNumber.substring(cardNumber.length() - 4);
            String maskedDigits = cardNumber.substring(0, cardNumber.length() - 4).replaceAll("\\d", "X");
            return maskedDigits + lastFourDigits;
        } else {
            // Handle cases where the card number is less than four digits
            return "Invalid card number";
        }
    }

	public PaymentView getPaymentView() {
		return paymentView;
	}

	public void setPaymentView(PaymentView paymentView) {
		this.paymentView = paymentView;
	}
}
