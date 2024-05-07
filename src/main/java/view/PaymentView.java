package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;

public class PaymentView extends JFrame {

    private JPanel contentPanel;
    private JTextArea cardNumberField;
    private JTextArea expirationMonthField;
    private JTextArea expirationYearField;
    private JTextArea cvvField;
    private JButton submitbutton;

    //constructor for setting up the payment view
    public PaymentView() {
        setTitle("Payment List View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);

        contentPanel = new JPanel();
        setContentPane(contentPanel);
        getContentPane().setLayout(null);

        //creation of the submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(363, 311, 89, 23);
        contentPanel.add(submitButton);
        submitbutton = submitButton;

        //creates the credit card input area
        JTextArea textArea = new JTextArea();
        textArea.setBounds(47, 86, 379, 22);
        contentPanel.add(textArea);
        cardNumberField = textArea;

        //creates the month field
        JTextArea mmTextArea = new JTextArea();
        mmTextArea.setText("MM");
        mmTextArea.setToolTipText("");
        mmTextArea.setBounds(47, 145, 41, 22);
        contentPanel.add(mmTextArea);
        expirationMonthField = mmTextArea;

        //creates the year field
        JTextArea yyTextArea = new JTextArea();
        yyTextArea.setText("YY");
        yyTextArea.setBounds(112, 145, 41, 22);
        contentPanel.add(yyTextArea);
        expirationYearField = yyTextArea;

        //creates the CVV field
        JTextArea cvvTextArea = new JTextArea();
        cvvTextArea.setBounds(348, 145, 78, 22);
        contentPanel.add(cvvTextArea);
        cvvField = cvvTextArea;

        //label for the credit card field
        JLabel cardNumberLabel = new JLabel("Card Number");
        cardNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cardNumberLabel.setBounds(47, 61, 78, 14);
        contentPanel.add(cardNumberLabel);

        //label for the CVV field
        JLabel cvvLabel = new JLabel("CVV");
        cvvLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cvvLabel.setBounds(309, 149, 29, 14);
        contentPanel.add(cvvLabel);

        //label for the expiration date field
        JLabel expirationLabel = new JLabel("Expiration Date");
        expirationLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        expirationLabel.setBounds(47, 120, 89, 14);
        contentPanel.add(expirationLabel);
    }

    //gets the card number
    public JTextArea getCardNumberField() {
        return cardNumberField;
    }

    //gets the expiration date month
    public JTextArea getExpirationMonthField() {
        return expirationMonthField;
    }

    //gets the expiration date year
    public JTextArea getExpirationYearField() {
        return expirationYearField;
    }

    //gets the CVV
    public JTextArea getCvvField() {
        return cvvField;
    }
    
    //getter for the submit button
    public JButton getSubmitButton() {
        return submitbutton;
    }
}
