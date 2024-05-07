package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to create the user dashboard view
 */
public class UserDashboardView extends JFrame {
	
	private JPanel contentPanel;
	private JLabel customerDashboardLabel;
	private JButton myReceiptsButton;
	private JButton bookAnotherFlight;
	private JLabel userIDLabel;
    
	//constructor that formats the user dashboard view
    public UserDashboardView() {
    	setTitle("User Dashboard View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		getContentPane().setLayout(null);
		
		//label for the top
		customerDashboardLabel = new JLabel("Welcome to your Customer Dashboard!");
		customerDashboardLabel.setFont(new Font("Sitka Banner", Font.PLAIN, 24));
		customerDashboardLabel.setBounds(71, 0, 371, 48);
		contentPanel.add(customerDashboardLabel);
		
		//button for the customer to view their receipts
		myReceiptsButton = new JButton("View my receipts");
		myReceiptsButton.setBounds(306, 118, 136, 48);
		contentPanel.add(myReceiptsButton);
		
		//button for the customer to book a flight
		bookAnotherFlight = new JButton("Book flight");
		bookAnotherFlight.setBounds(71, 118, 155, 48);
		contentPanel.add(bookAnotherFlight);
		
		//empty label that will be filled when the customer logs in
		userIDLabel = new JLabel("");
		userIDLabel.setBounds(186, 40, 120, 26);
		contentPanel.add(userIDLabel);
    }
    
    //setter for the user id label
    public void setUserIDLabel(String label) {
    	this.userIDLabel.setText(label);
    }
    
    /**
     * Action listener for when the book flight button is pressed
     * @param listener
     * @author Kendra Minch
     */
    public void addActionListenerToBookMoreFlights(ActionListener listener) {
		bookAnotherFlight.addActionListener(listener);
	}

    /**
     * Action listener for when the diaply receipts button is pressed
     * @param listener
     * @author Kendra Minch
     */
    public void addActionListenerDisplayReceipts(ActionListener listener) {
		myReceiptsButton.addActionListener(listener);
	}
}
