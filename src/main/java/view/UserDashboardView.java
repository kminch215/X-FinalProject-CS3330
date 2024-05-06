package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UserDashboardView extends JFrame {
	
	private JPanel contentPanel;
	private JLabel customerDashboardLabel;
	private JButton myReceiptsButton;
	private JButton bookAnotherFlight;
	private JLabel userIDLabel;
    
    public UserDashboardView() {
    	setTitle("User Dashboard View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		getContentPane().setLayout(null);
		
		customerDashboardLabel = new JLabel("Welcome to your Customer Dashboard!");
		customerDashboardLabel.setFont(new Font("Sitka Banner", Font.PLAIN, 24));
		customerDashboardLabel.setBounds(71, 0, 371, 48);
		contentPanel.add(customerDashboardLabel);
		
		myReceiptsButton = new JButton("View my reciepts");
		myReceiptsButton.setBounds(306, 118, 136, 48);
		contentPanel.add(myReceiptsButton);
		
		bookAnotherFlight = new JButton("Book another flight");
		bookAnotherFlight.setBounds(71, 118, 155, 48);
		contentPanel.add(bookAnotherFlight);
		
		userIDLabel = new JLabel("");
		userIDLabel.setBounds(186, 40, 120, 26);
		contentPanel.add(userIDLabel);
    }
    
    public void addActionListenerToBookMoreFlights(ActionListener listener) {
		bookAnotherFlight.addActionListener(listener);
	}
    
    public void addActionListenerDisplayReceipts(ActionListener listener) {
		myReceiptsButton.addActionListener(listener);
	}
}
