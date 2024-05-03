package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.EconomySeat;
import model.FirstClassSeat;
import model.SeatInformation;

public class SeatSelectionView extends JFrame{
	private JPanel contentPanel;
	private JLabel seatSelectorLabel;
	private DefaultTableModel model;
	private JTable seatTable;
	private JButton selectSeat;
	private JButton backButton;
	private ArrayList<Integer> selectedSeatNumbers;

	
	public SeatSelectionView() {
		setTitle("Selection View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		getContentPane().setLayout(null);
		
		//Create header for the view
		seatSelectorLabel = new JLabel("Seat Selector");
		seatSelectorLabel.setLocation(0, 0);
		seatSelectorLabel.setSize(484, 20);
        seatSelectorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        seatSelectorLabel.setFont(new Font("Sitka Heading", Font.BOLD, 16));
        
        // Create table model for available seats
 		model = new DefaultTableModel();
        seatTable = new JTable(model);
        seatTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
         
         // Add columns to the table model
         model.addColumn("Seat Number");
         model.addColumn("Class");
         model.addColumn("Price");
         
         //setting the formatting of the table
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
         centerRenderer.setHorizontalAlignment(JLabel.CENTER);
         seatTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
      
         selectedSeatNumbers = new ArrayList<>();
         
         selectSeat = new JButton("Select Seat");
         selectSeat.setLocation(0, 333);
         selectSeat.setSize(484, 30);
         
         backButton = new JButton("Back");
         backButton.setLocation(0, 20);
         backButton.setSize(70, 30);
         
         // Add components to the frame
         JScrollPane scrollPane = new JScrollPane(seatTable);
         scrollPane.setSize(440, 250);
         scrollPane.setLocation(20, 60);
         contentPanel.add(seatSelectorLabel);
         contentPanel.add(scrollPane);
         contentPanel.add(selectSeat);
         contentPanel.add(backButton);
         
//         seatTable.addMouseListener(new SeatSelectionListener());

	}
	
	public void addSeatInformationToView(SeatInformation seat) {
		if(seat instanceof EconomySeat) {
			EconomySeat econSeat = (EconomySeat)seat;
			model.addRow(new Object[] {econSeat.getSeatNumber(), "Economy", "$" + econSeat.getSeatPrice()});

		}
		if(seat instanceof FirstClassSeat) {
			FirstClassSeat FCseat = (FirstClassSeat)seat;
			model.addRow(new Object[] {FCseat.getSeatNumber(), "First Class", "$" + FCseat.getSeatPrice()});

		}
		else {
			return;
		}
	}
	
	public int[] getSelectedSeatNumbers() {
		int[] selectedRows = seatTable.getSelectedRows();
		int[] selectedSeatNumbers = new int[selectedRows.length];
		for(int i=0; i<selectedRows.length; i++) {
			selectedSeatNumbers[i] = (int) model.getValueAt(selectedRows[i], 0);
		}
		return selectedSeatNumbers;
	}
	
	public void addActionListenerToSelectSeatButton(ActionListener listener) {
		selectSeat.addActionListener(listener);
	}
	
	public void addActionListenerToBackButton(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	public class SeatSelectionListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = seatTable.rowAtPoint(e.getPoint());
			int seatNumber = (int) model.getValueAt(row, 0);
			if(selectedSeatNumbers.contains(seatNumber)) {
				selectedSeatNumbers.remove(Integer.valueOf(seatNumber));
			}
			else {
				selectedSeatNumbers.add(seatNumber);
			}
			seatTable.changeSelection(row, 0, false, false);
		}
	}
	
	public void clearSeatTable() {
		model.setRowCount(0);
		return;
	}
}
