import java.util.Arrays;

import java.util.Scanner;


public class AirlineSystem {

	public final static int MAX_FLIGHT_CAPACITY = 20; // Max seats in flight

	public static boolean[] seatStatus;

	public static int fillCount = 0; // No of seats filled in after each

	// reservation

	public static Scanner input = new Scanner(System.in);



	public AirlineSystem() {

		super();

		// Initialize the seatStatus with Max capacity

		seatStatus = new boolean[MAX_FLIGHT_CAPACITY];

		// Assign all seat are empty by setting false

		Arrays.fill(seatStatus, Boolean.FALSE);

	}


	private void resInEconomy() {

		boolean resFlag = false;

		// 	Economy class seat from 9-20 means array accept from 8 to 19

		for (int i = 8; i <= 20; i++) {

			if (!seatStatus[i]) {

				seatStatus[i] = true;

				fillCount = fillCount + 1;

				resFlag = true;

				break;

			}

		}

		if (!resFlag) {

			System.out.println("Hi User , Economy Class was full, Is it okay to book in First Class [Yes/No]");

			String ch = input.next();

			if (ch.toLowerCase().equals("yes")) {

				resInFirstClass();

			}

		}

		for (int i = 0; i < seatStatus.length; i++) {

			System.out.print(seatStatus[i] + " ");

		}

	}



	private void resInFirstClass() {

		boolean resFlag = false;

		// First class seat from 1-8 means array accept from 0 to 7

		for (int i = 0; i <= 7; i++) {

			if (!seatStatus[i]) {

				seatStatus[i] = true;

				fillCount = fillCount + 1;

				resFlag = true;

				break;

			}

		}

		if (!resFlag) {

			System.out.println("Hi User , First Class was full, Is it okay to book in Economy [Yes/No]");

			String ch = input.next();

			if (ch.toLowerCase().equals("yes")) {

				resInEconomy();

			}

		}

		for (int i = 0; i < seatStatus.length; i++) {

			System.out.print(seatStatus[i] + " ");

		}

	}



	public static void main(String[] args) {

		AirlineSystem resSystem = new AirlineSystem();

		do {
			
			System.out.println("\nWelcome to Airline System Reservation by Dhiraj Senghani");
			System.out.println("\nHi, Please select your choice: ");

			System.out.println("1 for First Class\n2 for Economy");

			
			

			int choice = input.nextInt();

			switch (choice) {	

			case 1:

				resSystem.resInFirstClass();

				break;

			case 2:

				resSystem.resInEconomy();

				break;

			default:

				break;

			}

			System.out.println(" || Total Seats Reserved: " + fillCount);

		} while (fillCount <= 20);

	}

}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             