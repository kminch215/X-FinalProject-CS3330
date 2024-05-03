package controller;

import model.PaymentListModel;
import view.PaymentView;
import controller.FlightListController;
import controller.SeatSelectionController;
import java.util.Scanner;
import java.util.Calendar;


public class PaymentController {

	private PaymentView paymentView;
	private PaymentListModel paymentModel;
	
	public PaymentController() {
		super();
		this.paymentView = new PaymentView();
		this.paymentModel = new PaymentListModel();
	
	}

		public static int convert(String str) {
			int num = 0;
			try {
				num = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
			}
			return num;
		}

	    public static void main(String[] args) {
			Scanner confirm = new Scanner(System.in);
			String yes = "yes";
			String no = "no";
			String back = "back";
			
			//pick a flight
			FlightListController flightController = new FlightListController();
			/* while (true) {
				System.out.println("\nIf you'd like to book a flight with us, please enter the corresponding number to continue.");
				String flight = confirm.nextLine().toLowerCase();
				int flightnum = convert(flight);
				if (flightnum <= 0 || flightnum > 5) {
					System.out.println("Invalid flight. Please enter a number between 1 and 5.");
					flight = confirm.nextLine();
					continue; // re-enter flight
				}
				
				//pick a seat
				SeatSelectionController seatController = new SeatSelectionController();
				String seat = confirm.nextLine().toLowerCase();
				int seatnum = convert(seat);
				System.out.println("Say 'back' to retype.");
				if (seat.equals(back)) {
				    flightController = new FlightListController();
				    flight = confirm.nextLine();
				    continue; // re-enter flight name
				}

				//Check if seatnum is not in getseatmodel array
				
				while (true) {
				    int[][] availableSeats = {
				        {32, 33, 12, 13, 15}, // availableSeats1
				        {19, 2, 32, 26, 84},  // availableSeats2
				        {32, 15, 64},         // availableSeats3
				        {23, 84, 64},         // availableSeats4
				        {96, 74, 14}          // availableSeats5
				    };
				    boolean seatAvailable = true;

				    // Check if seatnum is in the list of available seats for the selected flight
				    for (int availableSeat : availableSeats[flightnum - 1]) {
				        if (seatnum == availableSeat) {
				            seatAvailable = false;
				            break; // Exit the loop if seat is found
				        }
				    }

				    if (!seatAvailable) {
				        System.out.println("Seat is unavailable. Please select a new seat.");
				        // Code to re-enter seatnum goes here...
				    } else {
				        break; // Exit the loop if seat is available
				    }
				} */


				// Ticket confirmation loop
				while (true) {
					//System.out.print("For confirmation, flight: " + flight + " seat: " + seat + "\n"); //fix
		            System.out.println("Is this okay? \n(Enter 'yes' to proceed, 'no' to cancel)" /*, retrieve ticket details, not finished*/);
		            String ans = confirm.nextLine().toLowerCase();
		            
		            if (ans.equals(yes)) {
		            	// Payment information loop
		            	while (true) {
		            		System.out.println("To proceed with payments, please enter the following:");
		            		System.out.println("First name: ");
		            		String firstName = confirm.nextLine().toLowerCase();
		            		
		            		while (true) {						//!replace with UID, singleton call
		            			System.out.println("Last name: ");
		                        System.out.println("Say 'back' to retype.");
		            			String lastName = confirm.nextLine().toLowerCase();
		            			
		            			if (lastName.equals(back)) {
		            				System.out.println("First name...");
		            				firstName = confirm.nextLine().toLowerCase();
		            				break; // re-enter first name
		            			}								//!end replace with UID
		            			
		            			while (true) {
		            				// Card number
			            			System.out.println("Card number: ");
			            			String cardNumber = confirm.nextLine();
			                        if (cardNumber.length() != 16) {
			                        	System.out.println("Card invalid.");
				            			System.out.println("Card number: ");
			                        	cardNumber = confirm.nextLine();
			                        }
		            			
		            				System.out.println("CVV: ");
		            				String cvvNumber = confirm.nextLine();
		            				
		            				
		            				if (cvvNumber.length() != 3) {
		            					System.out.println("CVV invalid. Please enter 3 digits.");
		            					cvvNumber = confirm.nextLine();
		            				}
		            				
		            				// Expiration month
		            				System.out.println("Expiration month (MM): ");
		            				String expirationMonth = confirm.nextLine();
		            				int month = convert(expirationMonth);
		            				if (month <= 0 || month >= 12) {
		            					System.out.println("Invalid month. Please enter a number between 1 and 12.");
		            					expirationMonth = confirm.nextLine();
		            				}
		            				
		            				// Expiration year
		            				System.out.println("Expiration year (YY): ");
		            				String expirationYear = confirm.nextLine();
		            				int year = convert(expirationYear);
		            				if (year < 19 || year > 29) {
		            					System.out.println("Invalid year. Please enter a valid year.");
		            					expirationYear = confirm.nextLine();
		            				}
		            				
		            				// Confirmation
		            				System.out.println("Is this correct?");
		            				System.out.println(firstName + " " + lastName);
		            				System.out.println("Card number: XXXX-XXXX-XXXX-" + cardNumber.substring(cardNumber.length() - 4)); //conceal cardnum
		            				System.out.println("Expiration: " + expirationMonth + "/" + expirationYear);
		            				System.out.println("Enter 'yes' to confirm, 'no' to retype.");
		            				String confirmPayment = confirm.nextLine().toLowerCase();
		            				
		            				if (confirmPayment.equals(yes)) {
		                            	System.out.println("Payment processing... \n\nProcessed. \n"
		                            			+ "Thank you for choosing ___ airlines. Have a safe flight."); //input faux airline name
		                            	//!reciept needed
		                            	break; //payment processed, exit
		            				} else if (confirmPayment.equals(no)) {
		                            	// Re-enter details
		                            	continue;
		            				} else {
		                            	System.out.println("Invalid input. Please enter 'yes' or 'no'.");
		            				}
		            			} // End inner card loop
		            			break; // Exit outer Last Name loop
		            		} // End inner Last Name loop
		            		if (ans.equals(no)) { //!not finished, take user back to seating selection
		                    	System.out.println("goodbye");
		                        break;
		            		} else {
		            			System.out.println("Sorry, I didn't catch that. Please respond 'yes' or 'no' for options on ticket confirmation.");
		            			confirm.nextLine().toLowerCase();
		            		}
		            	}
		            }
		            confirm.close();
				} //last exit for payment
			}

		public void initialize() {
			paymentView.setVisible(true);
		}
	}