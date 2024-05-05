package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.ReceiptInformation;
import javax.swing.JButton;

public class ReceiptView extends JFrame{
	private JPanel contentPanel;
	private JLabel receiptPageLabel;
	private JButton toUserDashboard;
	private JList<ReceiptInformation> receiptList;
	
	public ReceiptView() {
		setTitle("Receipt View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		getContentPane().setLayout(null);
		
		DefaultListModel<ReceiptInformation> receiptModel = new DefaultListModel<ReceiptInformation>();
		receiptList = new JList<ReceiptInformation>(receiptModel);
		receiptList.setBounds(10, 25, 466, 210);
		contentPanel.add(receiptList);
		
		//Create header for the view
		receiptPageLabel = new JLabel("Booking History");
		receiptPageLabel.setLocation(0, 0);
		receiptPageLabel.setSize(484, 20);
        receiptPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        receiptPageLabel.setFont(new Font("Sitka Heading", Font.BOLD, 16));
        contentPanel.add(receiptPageLabel);
        
        toUserDashboard = new JButton("To User Dashboard");
        toUserDashboard.setBounds(173, 259, 166, 23);
        contentPanel.add(toUserDashboard);
	}
	
	public DefaultListModel<ReceiptInformation> getReceiptList() {
		return (DefaultListModel<ReceiptInformation>) receiptList.getModel();
	}
	
	public void addActionListenerToSelectUserDashboardButton(ActionListener listener) {
		toUserDashboard.addActionListener(listener);
	}
}
