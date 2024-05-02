package controller;

import model.UserDashboard;
import view.UserDashboardView;

public class UserDashboardController {

	private UserDashboardView dashboardView;
	private UserDashboard dashboardModel;
	
	public UserDashboardController() {
		super();
		this.dashboardView = new UserDashboardView();
		this.dashboardModel = new UserDashboard(null); //change this to input the userID
	}
}
