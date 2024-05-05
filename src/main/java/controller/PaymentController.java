package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import model.PaymentListModel;
import view.PaymentView;

public class PaymentController {

    private PaymentView paymentView;

    public PaymentController(int[] seats) {
        this.paymentView = new PaymentView();
        this.paymentView.setVisible(true);

        this.paymentView.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateAndProcessPayment();
            }
        });
    }

    private void validateAndProcessPayment() {
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

    private void processPayment(String cardNumber, String cvvNumber, String expirationMonth, String expirationYear) {
        System.out.println("Payment processed successfully!");
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
}
