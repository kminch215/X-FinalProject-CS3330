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

    public PaymentView() {
        setTitle("Payment List View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);

        contentPanel = new JPanel();
        setContentPane(contentPanel);
        getContentPane().setLayout(null);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(363, 311, 89, 23);
        contentPanel.add(submitButton);
        submitbutton = submitButton;

        JTextArea textArea = new JTextArea();
        textArea.setBounds(47, 86, 379, 22);
        contentPanel.add(textArea);
        cardNumberField = textArea;

        JTextArea mmTextArea = new JTextArea();
        mmTextArea.setText("MM");
        mmTextArea.setToolTipText("");
        mmTextArea.setBounds(47, 145, 41, 22);
        contentPanel.add(mmTextArea);
        expirationMonthField = mmTextArea;

        JTextArea yyTextArea = new JTextArea();
        yyTextArea.setText("YY");
        yyTextArea.setBounds(112, 145, 41, 22);
        contentPanel.add(yyTextArea);
        expirationYearField = yyTextArea;

        JTextArea cvvTextArea = new JTextArea();
        cvvTextArea.setBounds(348, 145, 78, 22);
        contentPanel.add(cvvTextArea);
        cvvField = cvvTextArea;

        JLabel cardNumberLabel = new JLabel("Card Number");
        cardNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cardNumberLabel.setBounds(47, 61, 78, 14);
        contentPanel.add(cardNumberLabel);

        JLabel cvvLabel = new JLabel("CVV");
        cvvLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cvvLabel.setBounds(309, 149, 29, 14);
        contentPanel.add(cvvLabel);

        JLabel expirationLabel = new JLabel("Expiration Date");
        expirationLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        expirationLabel.setBounds(47, 120, 89, 14);
        contentPanel.add(expirationLabel);
    }

    public JTextArea getCardNumberField() {
        return cardNumberField;
    }

    public JTextArea getExpirationMonthField() {
        return expirationMonthField;
    }

    public JTextArea getExpirationYearField() {
        return expirationYearField;
    }

    public JTextArea getCvvField() {
        return cvvField;
    }
    public JButton getSubmitButton() {
        return submitbutton;
    }
}
