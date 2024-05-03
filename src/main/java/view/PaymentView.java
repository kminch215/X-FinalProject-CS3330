package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaymentView extends JFrame {

	private JPanel contentPanel;

	
	public PaymentView() {
		setTitle("Payment List View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		getContentPane().setLayout(null);
	}
}
