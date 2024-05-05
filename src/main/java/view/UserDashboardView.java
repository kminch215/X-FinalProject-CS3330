package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserDashboardView extends JFrame {
    private JLabel userIDLabel;
    private JLabel currentTicketsLabel;
    private JLabel ticketHistoryLabel;
    
    public UserDashboardView() {
        setTitle("User Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        
        userIDLabel = new JLabel();
        add(userIDLabel);
        
        currentTicketsLabel = new JLabel();
        add(currentTicketsLabel);
        
        ticketHistoryLabel = new JLabel();
        add(ticketHistoryLabel);
        
    }
    
    public void displayUserProfile(int userID) {
        userIDLabel.setText("User Profile for UserID: " + userID);
    }
    
    public void displayCurrentTickets(List<String> tickets) {
        StringBuilder ticketsText = new StringBuilder("<html>Current Tickets:<br>");
        for (String ticket : tickets) {
            ticketsText.append(ticket).append("<br>");
        }
        ticketsText.append("</html>");
        currentTicketsLabel.setText(ticketsText.toString());
    }
    
    public void displayTicketHistory(List<String> history) {
        StringBuilder historyText = new StringBuilder("<html>Ticket History:<br>");
        for (String event : history) {
            historyText.append(event).append("<br>");
        }
        historyText.append("</html>");
        ticketHistoryLabel.setText(historyText.toString());
    }
}
