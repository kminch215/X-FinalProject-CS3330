package controller;

import model.ReceiptInformation;
import model.UserDashboard;
import view.UserDashboardView;
import model.UserInformation;
import model.UserListModel;

import javax.swing.*;

import controller.FlightListController.ActionListenerSelectFlight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Kendra Minch
 */
public class UserDashboardController {
    private UserDashboardView dashboardView;
    private UserDashboard dashboardModel;
    private UserListModel userListModel;

    //deault constructor
    public UserDashboardController() {
        this.dashboardView = new UserDashboardView(); 
        this.dashboardModel = new UserDashboard(UserDashboard.getUserID());
		dashboardView.addActionListenerToBookMoreFlights(new ActionListenerBookMoreFlights());
		dashboardView.addActionListenerDisplayReceipts(new ActionListenerReceiptInformation());
		dashboardView.setUserIDLabel("Customer ID: " + UserDashboard.getUserID());
		
        dashboardView.setVisible(true);
    }

    /**
	 * Action listener for when the user clicks on the book more flight button in the dashboardView
	 * 
	 * @author Kendra Minch
	 */
	public class ActionListenerBookMoreFlights implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dashboardView.setVisible(false);
			FlightListController flightController = new FlightListController();
		}
		
	}
	
	/**
	 * Action listener for when the user clicks on view my receipts button
	 * 
	 * @author Kendra Minch
	 */
	public class ActionListenerReceiptInformation implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dashboardView.setVisible(false);
			ReceiptController receiptController = new ReceiptController();
		}
		
	}
}
